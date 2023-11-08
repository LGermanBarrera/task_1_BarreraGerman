package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.App;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguagePage {

//    private static final Logger LOGGER = LogManager.getLogger(App.class);
    private WebDriver driver;

    private By englishChosen = By.cssSelector("div#icp-language-settings>div.a-spacing-mini");
    private By submitLanguage = By.cssSelector("input[aria-labelledby=\"icp-save-button-announce\"]");
    private By isPageInEnglish = By.cssSelector("img[alt=\"Shop Early Black Friday deals\"]");
    private By englishFlag = By.cssSelector("div#nav-xshop [data-csa-c-id=\"j7nyoc-iaviz0-lqt2sq-913dsz\"]");

    public LanguagePage(WebDriver driver) {
        this.driver = driver;
    }


    public void selectEnglish() {
        driver.findElement(englishChosen).click();
    }

    public LanguagePage clickOnSubmit() {
        driver.findElement(submitLanguage).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(isPageInEnglish))).isDisplayed();
//            return driver.findElement(isPageInEnglish).getAttribute("outerText");
        } catch (Exception e) {

//            LOGGER.error("English language was not selected");
        }
        return new LanguagePage(driver);
    }

    public boolean isEnglishSelected() {
        return driver.findElement(isPageInEnglish).isDisplayed();
    }

}
