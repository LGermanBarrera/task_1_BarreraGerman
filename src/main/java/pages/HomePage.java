package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By logo = By.cssSelector("[aria-label=\"Amazon\"]");
    private By signIn = By.cssSelector("#nav-link-accountList-nav-line-1");

    private By burgerButton = By.cssSelector("[role='button']");

    private By greetingMessage = By.cssSelector("#hmenu-customer-profile-right");

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

    public boolean isGreetingMessagePresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        return wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(greetingMessage))).isDisplayed();
    }

}
