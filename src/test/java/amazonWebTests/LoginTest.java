package amazonWebTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PasswordPage;
import pages.SignInPage;

public class LoginTest extends BaseTests {


    @Test
    public void badEmailCredentialTest() {
        homePage.clickIfOldPageIsPresent();
        SignInPage signIn = homePage.clickOnSignIn();
        signIn.setUsername("barreragerma27@gmail.com");
        signIn.clickContinueBtn();
        Assert.assertTrue(signIn.isProblemMessagePresent(),"login was not performed");
    }

    @Test
    public void badPasswordCredentialTest() {
        homePage.clickIfOldPageIsPresent();
        SignInPage signIn = homePage.clickOnSignIn();
        signIn.setUsername("barreragerman27@gmail.com")
                .clickContinueBtn()
                .setPassword("TogyBungy")
                .clickOnSignInBtn();
        Assert.assertTrue(signIn.isProblemMessagePresent(),"login was not performed");
    }
}
