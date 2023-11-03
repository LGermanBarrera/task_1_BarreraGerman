package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {
    private WebDriver driver;
    private By password = By.cssSelector("[type=\"password\"]");
    private By clickSubmit = By.id("signInSubmit");
    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setPassword(String password1){
        driver.findElement(password).sendKeys(password1);
    }

    public HomePage clickSubmitButton(){
        driver.findElement(clickSubmit).click();
        return new HomePage(driver);
    }

}
