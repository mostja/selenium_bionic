package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by Mostja on 22-Feb-15.
 */
public class OLXTest {
    public WebDriver driver;

    @BeforeSuite
    public void initDriver(){
        driver = new FirefoxDriver();
    }
    @AfterSuite
    public void shutEnv(){
        driver.quit();
    }
    @Test
    public void testSearch(){
        driver.get("http://olx.ua/");
        Assert.assertTrue(driver.findElement(By.id("headerSearch")).isDisplayed());
        driver.findElement(By.id("headerSearch")).sendKeys("canon 60d");
    }
}
