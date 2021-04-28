package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Base {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public void beforeMethod () {
        System.setProperty("webdriver.edge.driver","C:\\driver\\msedgedriver.exe");
        webDriver = new EdgeDriver();
        webDriverWait = new WebDriverWait(webDriver,20);
        webDriver.manage().window().maximize();
    }

    public void afterMethod () {
        webDriver.quit();
    }


}
