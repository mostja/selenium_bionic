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
public class GitHubTest {
    public WebDriver driver;

    @BeforeSuite
    public void initDriver(){
        driver = new FirefoxDriver();
    }
    @AfterSuite
    public void shutEnv(){
        driver.quit();
    }

    public void testGitHub(){
        driver.get("https://github.com/");
        Assert.assertTrue(driver.findElement(By.linkText("Sign In")).isDisplayed());
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("login_field")).sendKeys("mostja");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.name("commit")).click();
        Assert.assertTrue(driver.findElement(By.className("header-nav-link sign-out-button tooltipped tooltipped-s")).isDisplayed());
    }

}
