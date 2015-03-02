package pages;

import org.openqa.selenium.By;

/**
 * Created by Mostja on 02-Mar-15.
 */
public enum CreateAdRubric {

    KIDS_WORLD(".//*[@id='cat-36']/span[1]"),
    REAL_ESTATE(".//*[@id='cat-1']/span[1]");

    private String xPath;

    CreateAdRubric(String xPath){
        this.xPath = xPath;
    }

    public By getBy()
    {
        return By.xpath(xPath);
    }
}
