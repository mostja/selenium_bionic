package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by c2614 on 23.02.2015.
 */
public class ChildPage extends AbstractPage{
    public ChildPage(WebDriver driver){super(driver);}

    public void openOdezhda(){
        driver.findElement(By.id("cat-539")).click();
    }

    public boolean isOpened(){
        return driver.findElement(By.id("cat-539")).isDisplayed();
    }
}
