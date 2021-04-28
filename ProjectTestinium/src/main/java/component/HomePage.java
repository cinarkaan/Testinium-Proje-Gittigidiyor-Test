package component;
import log4j.Log4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.Util;

public class HomePage extends Util {

    public HomePage (WebDriver webDriver,String url) {
        super(webDriver,url);
        PageFactory.initElements(this.webDriver,this);
    }

    public void getHomePage() {
        Log4j.info("Connecting to : " + url + "page");
        webDriver.get(url);
        Assert.assertEquals(webDriver.getTitle(),"GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
        Log4j.info("HomePage Test Successfully");
    }

}
