package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by c2614 on 23.02.2015.
 */
public class AbstractPage {
    protected  WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }
}