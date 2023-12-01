package com.amazonWebPageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class WrapperAbstractPage{
    protected WebDriver driver;
    private Wait<WebDriver> wait;
    private static final Logger LOGGER = LoggerFactory.getLogger(WrapperAbstractPage.class);

    protected WrapperAbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public WrapperAbstractPage() {
    }

    public boolean isElementPresent(WebElement element) {
       try{
           wait.until(ExpectedConditions.visibilityOf(element));
           LOGGER.info("Here the assertion is performed");
        return element.isDisplayed();
       }catch (Exception e){
           LOGGER.error("The element is not visible: " + e);
       }
       return false;
    }

    public void click(WebElement element, String elementName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            LOGGER.info("Clicked on " + elementName);
        } catch (Exception e) {
            LOGGER.error("Error clicking on " + elementName, e);
        }
    }


}
