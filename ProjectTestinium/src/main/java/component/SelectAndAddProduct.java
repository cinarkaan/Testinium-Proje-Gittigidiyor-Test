package component;

import log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Util;

import java.util.List;

public class SelectAndAddProduct extends Util {

    private String price1 = "", price2 = "", productLink = "";

    public SelectAndAddProduct(WebDriver webDriver, String url) {
       super(webDriver,url);
        PageFactory.initElements(this.webDriver,this);
    }

    public void selectProduct (WebDriverWait webDriverWait) throws InterruptedException {
        Log4j.info("Selecting from is shown product");
        webDriver.get(url);
        selected();
        price1 += webDriver.findElement(By.id("sp-price-discountPrice")).getText();
        Log4j.info("Selected product is adding to basket");
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-basket")));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();",webElement);
        Log4j.info("Selected product is added to basket with successfully");
        Thread.sleep(2500);
        webDriver.get("https://www.gittigidiyor.com/sepetim");
        Thread.sleep(2500);
        price2 += webDriver.findElement(By.className("real-discounted-price")).getText();
        if (price1.equalsIgnoreCase(price2))
            Log4j.info("Price is matched");
        Thread.sleep(2500);
        Log4j.info("Product of basket is added one ");
        Select select = new Select(webDriver.findElement(By.xpath("//*[@class='amount']")));
        select.selectByIndex(1);
    }

    private void selected () throws InterruptedException {
        List<WebElement> products = webDriver.findElements(By.cssSelector("ul.catalog-view" + ">*"));
        int productNumber = getRandomNumber(0,products.size());
        Log4j.info("Number of selected product : " + productNumber);
        products.get(productNumber).click();
        Thread.sleep(2500);
        productLink += webDriver.getCurrentUrl();
        Log4j.info("The product selected was successfully : " + webDriver.getTitle());
    }

    private int getRandomNumber (int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
