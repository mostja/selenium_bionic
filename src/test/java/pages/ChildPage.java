package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by c2614 on 23.02.2015.
 */
public class ChildPage extends AbstractPage{
    private static final By OPEN_CHILDREN_DRESS_LINK = By.id("cat-539");

    public ChildPage(WebDriver driver){super(driver);}

    public void openOdezhda(){
        driver.findElement(OPEN_CHILDREN_DRESS_LINK).click();
    }

    public boolean isOpened(){
        return driver.findElement(OPEN_CHILDREN_DRESS_LINK).isDisplayed();
    }
}
