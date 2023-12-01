package com.amazonWebTests;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.amazonWebPageTest.ProductsPage;

import java.util.List;

public class SearchBarTest extends BaseTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchBarTest.class);

    @Test
    public void searchAProductTest() {
        SoftAssert softAssert= new SoftAssert();
        homePage.clickIfOldPageIsPresent();
        ProductsPage productsPage = homePage.clickOnSearchBar()
                .typeProduct("Xiaomi")
                .clickOnSearchIcon();
        List<WebElement> finalList1 = productsPage.printProductList();
        for (WebElement data : finalList1) {
            System.out.println(data.getText());
        }
//        Assert.assertFalse(finalList1.isEmpty(),"The list is empty");
    }
}
