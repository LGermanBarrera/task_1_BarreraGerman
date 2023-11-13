package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourAccountPage {
    private static final Logger LOGGER = LogManager.getLogger(YourAccountPage.class);
    private WebDriver driver;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class=\"a-row a-spacing-base\"]")
    private WebElement pageTitle;
//    private By pageTitle = By.cssSelector("[class=\"a-row a-spacing-base\"]");

    public boolean isTitlePresent() {
        LOGGER.info("Here it is getting the title element");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(
                    pageTitle));
            return pageTitle.isDisplayed();
        } catch (Exception e) {
            LOGGER.error("Error getting page title" + e);
        }
        return false;
    }


}
