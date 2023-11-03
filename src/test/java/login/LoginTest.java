package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PasswordPage;
import pages.SignInPage;

public class LoginTest extends BaseTests {


    @Test
    public void loginTest() {
        SignInPage signIn = homePage.clickOnSignIn();
        signIn.setUsername("barreragerman27@gmail.com");
        PasswordPage setPassword = signIn.clickOnContinueButton();
        setPassword.setPassword("TonyDungy");
         homePage = setPassword.clickSubmitButton();
        Assert.assertTrue(homePage.isHomePageOpened(),"login was not performed");
    }
}
