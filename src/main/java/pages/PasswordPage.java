package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
    private WebDriver driver;
    @FindBy(css = "[type=\"password\"]")
    private WebElement password;
    //    private By password = By.cssSelector("[type=\"password\"]");
    @FindBy(id = "signInSubmit")
    private WebElement clickSubmit;

    //    private By clickSubmit = By.id("signInSubmit");
    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setPassword(String password1) {
        password.sendKeys(password1);
    }

    public HomePage clickSubmitButton() {
        clickSubmit.click();
        return new HomePage(driver);
    }

}
