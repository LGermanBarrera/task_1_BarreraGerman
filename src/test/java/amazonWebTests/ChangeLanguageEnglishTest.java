package amazonWebTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LanguagePage;

public class ChangeLanguageEnglishTest extends BaseTests {

    @Test
    public void chooseEnglishLanguageTest() {
        LanguagePage languagePage = homePage.clickOnLanguages();
        languagePage.selectEnglish();
        languagePage.clickOnSubmit();
        Assert.assertTrue(languagePage.isEnglishSelected(),  "The English was not selected");

    }
}
