package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by c2614 on 23.02.2015.
 */
public class HomePage extends AbstractPage {
    private static final By HOME_PAGE_LINK = By.xpath(".//*[@id='body-container']/div/div/div[2]/div/p[1]");

    public HomePage (WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(HOME_PAGE_LINK).isDisplayed();
    }

    public HomePage open(){
        driver.get("http://olx.ua/");
        return this;
    }

    public KidsWorldPage openKidsWorld() {
        driver.findElement(By.cssSelector("a[data-code='detskiy-mir']")).click();
        return new KidsWorldPage(driver);
    }

    public CreateAdPage openCreateAd(){
        driver.findElement(By.xpath(".//*[@id='postNewAdLink']")).click();
        return new CreateAdPage(driver);
    }
}
