package amazonWebTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EnglishLanguagePage;

public class ChangeLanguageEnglishTest extends BaseTests {

    @Test
    public void chooseEnglishLanguageTest() {
        EnglishLanguagePage languagePage = homePage.clickOnLanguages();
        languagePage.selectEnglish();
        languagePage.clickOnSubmit();
        Assert.assertEquals(languagePage.isEnglishSelected(), "All", "The English was not selected");
//        homePage.clickOnBurgerButton();
//        YourAccountPage yourAccount = homePage.clickOnYourAccountButton();
//        Assert.assertTrue(yourAccount.isTitlePresent(),"Your account was not clicked");
    }
}
