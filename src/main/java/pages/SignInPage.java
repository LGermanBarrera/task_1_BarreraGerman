package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;

    private By userEmail = By.cssSelector("[type=email]");
    private By continueButton = By.cssSelector("[class=\"a-button-input\"]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(userEmail).sendKeys(username);
    }

    public PasswordPage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return new PasswordPage(driver);
    }

}
