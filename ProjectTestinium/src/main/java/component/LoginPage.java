package component;

import log4j.Log4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.Util;

public class LoginPage extends Util {

    public LoginPage (WebDriver webDriver,String url) {
        super(webDriver,url);
        PageFactory.initElements(this.webDriver,this);
    }

    public void getLoginPage () {
        Log4j.info("Connecting to : " + url + "page");
        webDriver.get(url);
        Assert.assertEquals(webDriver.getTitle(),"Üye Girişi - GittiGidiyor");
        Log4j.info("Successfully was connected to : " + url + " page");
        webDriver.findElement(By.id("L-UserNameField")).sendKeys("ccinarkaan");
        webDriver.findElement(By.id("L-PasswordField")).sendKeys("Lchkdr2016");
        webDriver.findElement(By.id("gg-login-enter")).click();
        Assert.assertEquals(webDriver.getTitle(),"GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
        Log4j.info("Logged Test Successfully");
    }


}
