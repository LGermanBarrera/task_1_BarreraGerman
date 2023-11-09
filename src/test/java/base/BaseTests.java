package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    @FindBy(css = "nav-bb-left,#nav-bb-logo")
    private WebElement basicLogo;
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public HomePage setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/ref=nav_logo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        driver.manage().window().fullscreen();
        homePage = new HomePage(driver);



        return new HomePage(driver);
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }

}
