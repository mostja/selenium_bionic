package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.annotations.*;
import pages.HomePage;
import utils.PropertyLoader;
import webddriver.Browser;
import webddriver.BrowserFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;


/**
 * Created by c2614 on 23.02.2015.
 */
public abstract class AbstractTest {
    protected WebDriver driver;
    protected HomePage home;
    protected Logger logger;


    @BeforeMethod
    public void initEnv(){
        driver = BrowserFactory.create(PropertyLoader.loadProperty("browser"));
        logger = LoggerFactory.getLogger(getClass());
        logger.info("Opening OLX Homepage");
        home = new HomePage(driver).open();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void shutEnv(){
        if (driver!= null){
            driver.quit();
        }
    }
}
