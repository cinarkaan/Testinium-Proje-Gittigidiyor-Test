package util;

import org.openqa.selenium.WebDriver;

public class Util {

    protected WebDriver webDriver;
    protected String url;

    public Util () {

    }

    public Util (WebDriver webDriver,String url) {
        this.url = url;
        this.webDriver = webDriver;
    }



}
