package amazonWebTests;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YourAccountPage;

import java.time.Duration;
import java.util.List;

public class YourAccountButtonTest extends BaseTests {

    @Test
    public void yourAccountButtonTest() {
        homePage.clickIfOldPageIsPresent();
        homePage.hoverOverChangeLanguage();
        homePage.printLanguageList();
        List<WebElement> langList = homePage.printLanguageList();
        langList.get(0).click();
        homePage.clickOnBurgerButton();
        YourAccountPage yourAccount = homePage.clickOnYourAccount();

        Assert.assertTrue(yourAccount.isTitlePresent(),"Your account button was not clicked");
    }
}
