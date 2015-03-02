package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by c2614 on 23.02.2015.
 */
public class KidsDressPage extends AbstractPage{
    public KidsDressPage(WebDriver driver){
        super(driver);
    }
    public boolean isOpened(){
        return (driver.getCurrentUrl().contains("/detskiy-mir/detskaya-odezhda/")
                && driver.findElement(By.id("main-category-choose-label"))
                .getText().contains("Детская одежда"));
    }
}
