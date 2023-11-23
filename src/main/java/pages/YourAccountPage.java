package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourAccountPage extends WrapperAbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(YourAccountPage.class);

    public YourAccountPage(WebDriver driver) {
        super(driver);

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class=\"a-row a-spacing-base\"]")
    private WebElement pageTitle;
//    private By pageTitle = By.cssSelector("[class=\"a-row a-spacing-base\"]");

    public boolean isTitlePresent() {
        LOGGER.info("Here it is getting the title element");
      return isElementPresent(pageTitle);
    }


}
