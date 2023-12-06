package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.amazonWebPageTest.HomePage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTests.class);
    static WebDriver driver;
    public HomePage homePage;


    @BeforeClass
    @Parameters({"platform", "browserName", "remoteUrl"})
    public HomePage setUp(String platform, String browserName, String remoteUrl) throws MalformedURLException {

        DesiredCapabilities caps = null;


        if (browserName.equals("safari")) {
            caps = new DesiredCapabilities();
            caps.setBrowserName("safari");
            caps.setPlatform(Platform.MAC);
        } else if (browserName.equals("chrome")) {
            caps = new DesiredCapabilities();
            caps.setBrowserName("chrome");
            caps.setPlatform(Platform.MAC);
        } else if (browserName.equals("firefox")) {
            caps = new DesiredCapabilities();
            caps.setBrowserName("firefox");
            caps.setPlatform(Platform.MAC);
        }

        driver = new RemoteWebDriver(new URL(remoteUrl), caps);


        driver.get("https://www.amazon.com/ref=nav_logo");
        LOGGER.info("HERE driver is initializing");
        homePage = new HomePage(driver);
        LOGGER.info("Page is being opened");

        return new HomePage(driver);
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void takeScreenShots(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/", result.getName() + ".png"));
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

}
