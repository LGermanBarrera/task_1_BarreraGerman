package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;


public class BaseTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTests.class);
    @FindBy(css = "nav-bb-left,#nav-bb-logo")
    private WebElement basicLogo;
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public HomePage setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
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
        driver.close();
        driver.quit();
    }

}
