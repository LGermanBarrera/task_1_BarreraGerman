package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
    private WebDriver driver;

    //    private By password = By.cssSelector("[type=\"password\"]");


    //    private By clickSubmit = By.id("signInSubmit");
    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }





}
