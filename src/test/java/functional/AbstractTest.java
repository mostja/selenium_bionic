package functional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

/**
 * Created by c2614 on 23.02.2015.
 */
public abstract class AbstractTest {
    protected WebDriver driver;
    protected HomePage home;

    @BeforeSuite
    public void initEnv(){
        driver = new FirefoxDriver();
        home = new HomePage(driver).open();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void shutEnv(){
//        if (driver!= null){
//            driver.quit();
//        }
    }
}
