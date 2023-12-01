package com.amazonWebPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class HomePage extends WrapperAbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
    private By logo = By.cssSelector("[aria-label=\"Amazon\"]");
    //    @FindBy(css = "[aria-label=\"Amazon\"]")
//    private WebElement logo;
    //    private By signIn = By.cssSelector("#nav-link-accountList-nav-line-1");
    @FindBy(css = "#nav-link-accountList-nav-line-1")
    private WebElement signIn;

    //    @FindBy(css = "i[class=\"hm-icon nav-sprite\"] ")
//    @FindBy(css = "a#nav-hamburger-menu ")
//    @FindBy(css = "[class~=\"hm-icon\"]")
    @FindBy(css = "[class~=\"hm-icon\"]")
    private WebElement burgerButton;
//    private By burgerButton = By.cssSelector("i[class=\"hm-icon nav-sprite\"]");
//    private By burgerButton = By.cssSelector("a#nav-logo-sprites");

    //    private By burgerButton = By.cssSelector("a#nav-hamburger-menu");
//    @FindBy(css = ".hmenu-visible>#hmenu-canvas>#hmenu-customer-profile-link>#hmenu-customer-profile>#hmenu-customer-profile-right>#hmenu-customer-name")
    @FindBy(css = ".hmenu-translateX #hmenu-customer-avatar-icon")
    private WebElement greetingMessage;
    //    private By greetingMessage = By.cssSelector("#hmenu-customer-profile-right");
    @FindBy(css = "[class='icp-nav-link-inner']")
    private WebElement changeLang;
//    private By changeLang = By.cssSelector("[class='icp-nav-link-inner']");

    @FindBy(css = ".nav-a.nav-a-2.icp-link-style-2")
    private WebElement selectLanguages;
    //    private By selectLanguages = By.cssSelector(".nav-a.nav-a-2.icp-link-style-2");
    //            = By.cssSelector("div#nav-flyout-icp>div.nav-tpl-itemList >a");
    @FindBy(css = "div#nav-flyout-icp>div.nav-template.nav-flyout-content.nav-tpl-itemList>a[href^='#switch']")
    private WebElement nineLanguages;
//    private By nineLanguages = By.cssSelector("div#nav-flyout-icp>div.nav-template.nav-flyout-content.nav-tpl-itemList>a[href^='#switch'] ");

    @FindBy(css = "div#nav-flyout-icp-footer-flyout>div.nav-template.nav-flyout-content.nav-tpl-itemList, a[href=\"#switch-lang=en_US\"]")
    private WebElement englishLang;
    //    private By englishLang = By.cssSelector("div#nav-flyout-icp-footer-flyout>div.nav-template.nav-flyout-content.nav-tpl-itemList, a[href=\"#switch-lang=en_US\"]");
    //    private By englishLang = By.cssSelector("div#nav-flyout-icp-footer-flyout>div.nav-template.nav-flyout-content.nav-tpl-itemList,a[href='#switch-lang=en_US']::first-line");
    @FindBy(css = "div.nav-bb-left a#nav-bb-logo")
    private WebElement basicLogo;
//    private By basicLogo = By.cssSelector("div.nav-bb-left a#nav-bb-logo");

    @FindBy(css = "img[alt=\"Shop Early Black Friday deals\"]")
    private WebElement englishLogo;
//    private By englishLogo = By.cssSelector("img[alt=\"Shop Early Black Friday deals\"]");

    @FindBy(css = "div#hmenu-content>ul[class=\"hmenu hmenu-visible\"]>li")
    private WebElement menuList;
//    private By menuList = By.cssSelector("div#hmenu-content>ul[class=\"hmenu hmenu-visible\"]>li");

    @FindBy(css = "div#hmenu-content [class=\"hmenu hmenu-visible\"]>li a[href$=\"1_35\"]")
    private WebElement yourAccount;
//    private By yourAccount = By.cssSelector("div#hmenu-content [class=\"hmenu hmenu-visible\"]>li a[href$=\"1_35\"]");

    @FindBy(css = "#twotabsearchtextbox ")
    private WebElement searchBar;

    @FindBy(css = ".nav-right>.nav-search-submit ")
    private WebElement searchBarButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignInPage clickOnSignIn() {
        click(signIn, "Signing button");
        return new SignInPage(driver);
    }

    public void clickOnBurgerButton() {
        click(burgerButton, "Burger button 'All' ");
//        driver.findElement(burgerButton).click();
    }

    public boolean isGreetingMessagePresent() {
        return isElementPresent(greetingMessage);
//        return driver.findElement(logo).isDisplayed();

    }


    public HomePage hoverOverChangeLanguage() {

        Actions action = new Actions(driver);
        action.moveToElement(selectLanguages).perform();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
            wait.until(ExpectedConditions.visibilityOf(englishLang));
        } catch (Exception e) {
            LOGGER.error("English language was not selected " + e);
        }
        return this;
    }

    public HomePage clickIfOldPageIsPresent() {
        try {
            if (basicLogo.isDisplayed())
                basicLogo.click();
            return new HomePage(driver);
        } catch (Exception e) {
            LOGGER.info("The old page was not clicked " + e);
            throw new RuntimeException(e);
        } finally {
            return new HomePage(driver);
        }
    }

    public List<WebElement> printLanguageList() {
        List<WebElement> languageList = driver.findElements(By.cssSelector("div#nav-flyout-icp>div.nav-template.nav-flyout-content.nav-tpl-itemList>a[href^='#switch']"));
        return languageList;
    }

    public List<WebElement> burgerButtonList() {
        List<WebElement> list = driver.findElements(By.cssSelector(menuList.getText()));
        return list;
    }

    public YourAccountPage clickOnYourAccount() {
        click(yourAccount, "Your Account button");
        return new YourAccountPage(driver);
    }

    public HomePage clickOnSearchBar() {
        click(searchBar, "Search bar");
        return this;
    }

    public HomePage typeProduct(String xiaomi) {
        LOGGER.info("Typing products name");
        searchBar.sendKeys(xiaomi);
        return this;
    }

    public ProductsPage clickOnSearchIcon() {
        click(searchBarButton, "Search Bar icon");
        return new ProductsPage(driver);

    }
}

