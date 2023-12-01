package com.amazonWebTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BurgerButtonTest extends BaseTests {

    @Test
    public void burgerButtonTest() {
        homePage.clickIfOldPageIsPresent();
        homePage.clickOnBurgerButton();
        Assert.assertTrue(homePage.isGreetingMessagePresent()
                , "The burger button was not clicked");
    }
}
