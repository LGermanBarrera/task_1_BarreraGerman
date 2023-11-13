package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;
    @FindBy(css = "[type=email]")
    private WebElement userEmail;
    //    private By userEmail = By.cssSelector("[type=email]");
    @FindBy(css = "[class=\"a-button-input\"]")
    private WebElement continueButton;
//    private By continueButton = By.cssSelector("[class=\"a-button-input\"]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        userEmail.sendKeys(username);
    }

    public PasswordPage clickOnContinueButton() {
        continueButton.click();
        return new PasswordPage(driver);
    }

}
