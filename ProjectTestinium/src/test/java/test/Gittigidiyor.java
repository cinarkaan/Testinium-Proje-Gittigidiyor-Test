package test;

import base.Base;
import component.*;
import log4j.Log4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class Gittigidiyor extends Base {

    @Before
    public void initialize () {
        super.beforeMethod();
    }

    @Test
    public void HomePage () {
        try {
            Log4j.initializeLog4j();
            Log4j.startLog("HomePage");
            HomePage homePage = new HomePage(webDriver,"https://www.gittigidiyor.com/");
            homePage.getHomePage();
            afterMethod();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("HomePage Test Failed");
        }
    }

    @Test
    public void LoginPage () {
        try {
            Log4j.initializeLog4j();
            Log4j.startLog("LoginPage");
            LoginPage loginPage = new LoginPage(webDriver,"https://www.gittigidiyor.com/uye-girisi");
            loginPage.getLoginPage();
            afterMethod();
        }catch (Exception e) {
            e.printStackTrace();
            Assert.fail("LoginPage Test Failed");
        }
    }

    @Test
    public void SearchComputer () {
        try {
            Log4j.initializeLog4j();
            Log4j.startLog("SearchComputer");
            SearchComputer searchComputer = new SearchComputer(webDriver,"https://www.gittigidiyor.com/");
            searchComputer.searchComputer();
            afterMethod();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Search Computer Test Failed");
        }

    }

    @Test
    public void SelectAndAddProduct () {
        try {
            Log4j.initializeLog4j();
            Log4j.startLog("SelectedProduct");
            SelectAndAddProduct selectProduct = new SelectAndAddProduct(webDriver,SearchComputer.productPage);
            selectProduct.selectProduct(webDriverWait);
            Thread.sleep(5000);
            String count = webDriver.findElement(By.className("detail-text")).getText();
            if (count.contains("2")) {
                Log4j.info("Product count has been two ");
            }
            WebElement webElement = webDriver.findElement(By.className("btn-delete"));
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();",webElement);
            Log4j.info("Basket is empty");
            String isEmpty = webDriver.findElement(By.className("detail-text")).getText();
            Thread.sleep(7000);
            if (isEmpty.contains("2")) {
                Log4j.info("The basket is confirmed to be empty . All test was successfully");
            } else{
                Assert.fail("Something was wrong ");
            }
            afterMethod();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("GetProduct Test Fail");
        }
    }

}
