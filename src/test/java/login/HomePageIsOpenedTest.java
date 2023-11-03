package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageIsOpenedTest extends BaseTests {


    @Test
    public void IsHomePageOpenedTest(){
        Assert.assertTrue(homePage.isHomePageOpened(),"The web page was not opened");
    }
}
