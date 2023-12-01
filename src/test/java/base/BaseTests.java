package base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.amazonWebPageTest.HomePage;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTests.class);
    static WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    @Parameters({"platform","browserName","remoteUrl"})
    public HomePage setUp(String platform,String browserName, String remoteUrl) throws MalformedURLException {
       DesiredCapabilities  caps = null;

        if (browserName.equals("safari")) {
            caps = new DesiredCapabilities();
            caps.setBrowserName("safari");
        } else if (browserName.equals("chrome")) {
            caps =new DesiredCapabilities();
            caps.setBrowserName("chrome");
        } else if (browserName.equals("firefox")) {
            caps = new DesiredCapabilities();
            caps.setBrowserName("firefox");
        }
        assert caps != null;
        caps.setPlatform(Platform.MAC);
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

}
