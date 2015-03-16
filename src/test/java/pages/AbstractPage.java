package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by c2614 on 23.02.2015.
 */
public abstract class AbstractPage {
    protected  WebDriver driver;
    protected Logger logger;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        this.logger = LoggerFactory.getLogger(getClass());
    }

    public abstract boolean isOpened();

   }
