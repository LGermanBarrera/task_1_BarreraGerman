package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.WrapperAbstractPage;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTests.class);
    static WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public HomePage setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName("Safari");
//         driver = new RemoteWebDriver(new URL("http://192.168.50.101:4444"), caps);


        driver.get("https://www.amazon.com/ref=nav_logo");
        LOGGER.info("HERE driver is initializing");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().fullscreen();
        homePage = new HomePage(driver);
        LOGGER.info("Page is being opened");


        return new HomePage(driver);
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }

}
