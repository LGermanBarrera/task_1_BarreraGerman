package amazonWebTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LanguagePage;

public class BurgerButtonTest extends BaseTests {

    @Test
    public void burgerButtonTest() {
        homePage.clickIfOldPageIsPresent();
        LanguagePage languagePage = homePage.clickOnLanguages();
        languagePage.selectEnglish();
        languagePage.clickOnSubmit();
        homePage.clickOnBurgerButton();
        Assert.assertTrue(homePage.isGreetingMessagePresent()
                , "The burger button was not clicked");
    }
}
