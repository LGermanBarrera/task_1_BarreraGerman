package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.App;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourAccountPage {
//    private static final Logger LOGGER = LogManager.getLogger(App.class);
    private WebDriver driver;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pageTitle = By.cssSelector("[class=\"a-row a-spacing-base\"]");

    public boolean isTitlePresent() {
//        LOGGER.info("Here it is getting the title element");
        boolean result = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
            return result = wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(pageTitle))).isDisplayed();
        }catch (Exception e){
//            LOGGER.error("Error getting page title");
        }
        return false;
    }


}
