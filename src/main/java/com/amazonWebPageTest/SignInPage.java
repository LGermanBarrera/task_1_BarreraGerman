package com.amazonWebPageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends WrapperAbstractPage {
    private WebDriver driver;
    @FindBy(css = "[type=email]")
    private WebElement userEmail;
    //    private By userEmail = By.cssSelector("[type=email]");
    @FindBy(css = "[class=\"a-button-input\"]")
    private WebElement continueButton;
//    private By continueButton = By.cssSelector("[class=\"a-button-input\"]");

    @FindBy(css = "#auth-error-message-box .a-box-inner .a-alert-heading ")
    private WebElement errorMessage;

    @FindBy(css = "input[id=\"continue\"] ")
    private WebElement clickContinue;

    @FindBy(css = "#signInSubmit")
    private WebElement clickSubmitPass;


    @FindBy(css = "[type=\"password\"]")
    private WebElement setPassword;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SignInPage setUsername(String username) {
        userEmail.sendKeys(username);
        return this;
    }

    public PasswordPage clickOnContinueButton() {
        continueButton.click();
        return new PasswordPage(driver);
    }

    public boolean isProblemMessagePresent() {
        return isElementPresent(errorMessage);
    }

    public SignInPage clickContinueBtn() {
        click(clickContinue, "Submit credentials button");
        return this;
    }

    public SignInPage clickOnSignInBtn() {
        click(clickSubmitPass, "Submit credentials button");
        return this;
    }

    public SignInPage setPassword(String password) {
        setPassword.sendKeys(password);
        return this;
    }
}
