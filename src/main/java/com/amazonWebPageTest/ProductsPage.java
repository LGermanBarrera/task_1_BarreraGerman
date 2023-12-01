package com.amazonWebPageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductsPage extends WrapperAbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsPage.class);

    @FindBy(css = "div[data-asin^=\"B0\"]")
    private List<WebElement> productList;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //    public int printProductList() {
//        List<WebElement> productList = driver.findElements(By.cssSelector("div[data-asin^=\"B0\"]"));
//        LOGGER.info("Getting the product list ");
//        return productList.size();
//    }
    public List<WebElement> printProductList() {
        LOGGER.info("Getting the product list ");
        return productList;
    }


}
