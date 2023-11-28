package amazonWebTests;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownLanguages extends BaseTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchBarTest.class);

    @Test
    public void dropDownLanguageTest() {
        homePage.clickIfOldPageIsPresent();
        homePage.hoverOverChangeLanguage();
        homePage.printLanguageList();
        List<WebElement> langList = homePage.printLanguageList();
        for (WebElement data : langList) {
            System.out.println(data.getText());
        }
        langList.get(0).click();
    }
}
//span[style='unicode-bidi:isolate; direction:ltr;'][dir='ltr']::first-line