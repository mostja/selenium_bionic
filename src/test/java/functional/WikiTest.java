package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by c2614 on 18.02.2015.
 */
public class WikiTest {
    public WebDriver driver;

    @BeforeSuite
    public void initDriver(){
        driver = new FirefoxDriver();
    }
    @AfterSuite
    public void shutEnv(){
        driver.quit();
    }

    public void testWiki(){
        driver.get("https://ru.wikipedia.org/wiki");
        Assert.assertTrue(driver.findElement(By.className("mw-wiki-logo")).isDisplayed());
    }
}
