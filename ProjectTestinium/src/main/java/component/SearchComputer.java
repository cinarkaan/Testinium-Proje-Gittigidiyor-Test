package component;

import log4j.Log4j;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.Util;

import java.util.List;


public class SearchComputer extends Util {

    public static String productPage = "";

    public SearchComputer (WebDriver webDriver,String url) {
        super(webDriver,url);
        PageFactory.initElements(this.webDriver,this);
    }

    public void searchComputer () {
        Log4j.info("The computer text is searching on the GittiGidiyor website");
        webDriver.get(url);
        webDriver.findElement(By.className("sc-4995aq-0")).sendKeys("Bilgisayar");
        webDriver.findElement(By.className("qjixn8-0")).click();
        Log4j.info("Getting Second Page");
        goToPageTwo();
        webDriver.get(productPage);
        Assert.assertEquals(webDriver.getTitle(),"Bilgisayar - GittiGidiyor - 2/100");
        Log4j.info("Search Test Successfully");
    }

    private void goToPageTwo ( ) {
        List<WebElement> ulList = webDriver.findElements(By.cssSelector("ul.clearfix" + ">*"));
        String pageTwo = "";
        for (int i = 0; i < ulList.size() ; i++) {
            if (ulList.get(i).getText().equalsIgnoreCase("2")) {
                productPage += ulList.get(i).findElement(By.xpath("//a[text()='2']")).getAttribute("href");
                break;
            }
        }
    }




}
