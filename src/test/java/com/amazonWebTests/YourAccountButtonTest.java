package com.amazonWebTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.amazonWebPageTest.YourAccountPage;

public class YourAccountButtonTest extends BaseTests {

    @Test
    public void yourAccountButtonTest() {
        homePage.clickIfOldPageIsPresent();
        homePage.clickOnBurgerButton();
        YourAccountPage yourAccount = homePage.clickOnYourAccount();

        Assert.assertTrue(yourAccount.isTitlePresent(),"Your account button was not clicked");
    }
}
