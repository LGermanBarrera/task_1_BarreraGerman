package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.App;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    //    private static final Logger LOGGER = LogManager.getLogger(App.class);
    private WebDriver driver;
    private By logo = By.cssSelector("[aria-label=\"Amazon\"]");
    private By signIn = By.cssSelector("#nav-link-accountList-nav-line-1");

    private By burgerButton = By.cssSelector("[role='button']");

    private By greetingMessage = By.cssSelector("#hmenu-customer-profile-right");

    private By yourAccountButton = By.cssSelector("\ta[href^=\"/gp/css/homepage.html?ref_=nav_em_ya_0_1_1_35\"]");

    private By changeLang = By.cssSelector("[class='icp-nav-link-inner']");

    private By selectLanguages = By.cssSelector(".nav-a.nav-a-2.icp-link-style-2");
//            = By.cssSelector("div#nav-flyout-icp>div.nav-tpl-itemList >a");
    private By nineLanguages = By.cssSelector("div#nav-flyout-icp>div.nav-template.nav-flyout-content.nav-tpl-itemList>a[href^='#switch'] ");

    private By englishLang = By.cssSelector("div#nav-flyout-icp-footer-flyout>div.nav-template.nav-flyout-content.nav-tpl-itemList, a[href=\"#switch-lang=en_US\"]");
    //    private By englishLang = By.cssSelector("div#nav-flyout-icp-footer-flyout>div.nav-template.nav-flyout-content.nav-tpl-itemList,a[href='#switch-lang=en_US']::first-line");
    @FindBy(css = "nav-bb-left,#nav-bb-logo")
    private WebElement basicLogo;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageOpened() {
        return driver.findElement(logo).isDisplayed();
    }

    public SignInPage clickOnSignIn() {
        driver.findElement(signIn).click();
        return new SignInPage(driver);
    }

    public void clickOnBurgerButton() {
        driver.findElement(burgerButton).click();
    }

    public boolean isGreetingMessagePresent() {
//        LOGGER.info("Is_greeting_message_test is being executed");
        boolean result = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
            return result = wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(greetingMessage))).isDisplayed();
        } catch (Exception e) {
//            LOGGER.error("Error displaying Greeting Message " + e);

        }
        return false;
    }

    public YourAccountPage clickOnYourAccountButton() {
        driver.findElement(yourAccountButton).click();
        return new YourAccountPage(driver);
    }

    public LanguagePage clickOnLanguages() {
        driver.findElement(changeLang).click();
        return new LanguagePage(driver);
    }

    public HomePage hoverOverChangeLanguage() {
        WebElement langList = driver.findElement(selectLanguages);
        Actions action = new Actions(driver);
        action.moveToElement(langList).perform();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
            wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(englishLang))).isDisplayed();
        } catch (Exception e) {

//            LOGGER.error("English language was not selected");
        }

        return this;
    }

    public HomePage clickIfOldPageIsPresent() {
        try {
            if (basicLogo.isDisplayed()) ;
            return new HomePage(driver);
        } catch (Exception e) {
            System.out.println("The old page was not clicked");
            throw new RuntimeException(e);
        } finally {
            return new HomePage(driver);
        }
    }

    public List<WebElement> printLanguageList() {
        List<WebElement> languageList = driver.findElements(nineLanguages);
        return languageList;
    }
}

