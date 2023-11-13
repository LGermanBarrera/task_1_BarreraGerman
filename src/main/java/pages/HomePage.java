package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
    private WebDriver driver;
    private By logo = By.cssSelector("[aria-label=\"Amazon\"]");
    private By signIn = By.cssSelector("#nav-link-accountList-nav-line-1");

    private By burgerButton = By.cssSelector("i[class=\"hm-icon nav-sprite\"]");
//    private By burgerButton = By.cssSelector("a#nav-logo-sprites");

    private By greetingMessage = By.cssSelector("#hmenu-customer-profile-right");
    private By changeLang = By.cssSelector("[class='icp-nav-link-inner']");

    private By selectLanguages = By.cssSelector(".nav-a.nav-a-2.icp-link-style-2");
    //            = By.cssSelector("div#nav-flyout-icp>div.nav-tpl-itemList >a");
    private By nineLanguages = By.cssSelector("div#nav-flyout-icp>div.nav-template.nav-flyout-content.nav-tpl-itemList>a[href^='#switch'] ");

    private By englishLang = By.cssSelector("div#nav-flyout-icp-footer-flyout>div.nav-template.nav-flyout-content.nav-tpl-itemList, a[href=\"#switch-lang=en_US\"]");
    //    private By englishLang = By.cssSelector("div#nav-flyout-icp-footer-flyout>div.nav-template.nav-flyout-content.nav-tpl-itemList,a[href='#switch-lang=en_US']::first-line");
    private By basicLogo = By.cssSelector("div.nav-bb-left a#nav-bb-logo");

    private By englishLogo = By.cssSelector("img[alt=\"Shop Early Black Friday deals\"]");

    private By menuList = By.cssSelector("div#hmenu-content>ul[class=\"hmenu hmenu-visible\"]>li");

    private By yourAccount = By.cssSelector("div#hmenu-content [class=\"hmenu hmenu-visible\"]>li a[href$=\"1_35\"]");

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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(burgerButton))).isDisplayed();
            driver.findElement(burgerButton).click();
            LOGGER.info("Burger button is clicked");
        } catch (Exception e) {
            LOGGER.error("Burger button was not clicked");
        }
    }

    public boolean isGreetingMessagePresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(greetingMessage))).isDisplayed();
//            return driver.findElement(greetingMessage).isDisplayed();
        } catch (Exception e) {
           LOGGER.info("Burger button was not clicked");
        }
        return driver.findElement(greetingMessage).isDisplayed();
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

            LOGGER.error("English language was not selected " + e);
        }

        return this;
    }

    public HomePage clickIfOldPageIsPresent() {
        try {
            if (driver.findElement(basicLogo).isDisplayed()) ;
            driver.findElement(basicLogo).click();
            return new HomePage(driver);
        } catch (Exception e) {
          LOGGER.info("The old page was not clicked" +e);
            throw new RuntimeException(e);
        } finally {
            return new HomePage(driver);
        }
    }

    public List<WebElement> printLanguageList() {
        List<WebElement> languageList = driver.findElements(nineLanguages);
        return languageList;
    }

    public List<WebElement> burgerButtonList() {
        List<WebElement> list = driver.findElements(menuList);
        return list;
    }

    public YourAccountPage clickOnYourAccount() {
        driver.findElement(yourAccount).click();
        return new YourAccountPage(driver);
    }
}

