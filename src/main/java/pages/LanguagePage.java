package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguagePage {

    private WebDriver driver;

    @FindBy(css = "div#icp-language-settings>div.a-spacing-mini")
    private WebElement englishChosen;
    //    private By englishChosen = By.cssSelector("div#icp-language-settings>div.a-spacing-mini");
    @FindBy(css = "input[aria-labelledby=\"icp-save-button-announce\"]")
    private WebElement submitLanguage;
    //    private By submitLanguage = By.cssSelector("input[aria-labelledby=\"icp-save-button-announce\"]");
    @FindBy(css = "img[alt=\"Shop Early Black Friday deals\"]")
    private WebElement isPageInEnglish;
    //    private By isPageInEnglish = By.cssSelector("img[alt=\"Shop Early Black Friday deals\"]");
    @FindBy(css = "div#nav-xshop [data-csa-c-id=\"j7nyoc-iaviz0-lqt2sq-913dsz\"]")
    private WebElement englishFlag;
//    private By englishFlag = By.cssSelector("div#nav-xshop [data-csa-c-id=\"j7nyoc-iaviz0-lqt2sq-913dsz\"]");

    public LanguagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void selectEnglish() {
        englishChosen.click();
    }

    public LanguagePage clickOnSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(
                submitLanguage));
        submitLanguage.click();
        return new LanguagePage(driver);
    }

    public boolean isEnglishSelected() {
        return isPageInEnglish.isDisplayed();
    }

}
