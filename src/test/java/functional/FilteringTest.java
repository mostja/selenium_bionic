package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbstractPage;
import pages.ChildDressPage;
import pages.ChildPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

/**
 * Created by c2614 on 23.02.2015.
 */
public class FilteringTest extends AbstractTest{

    @Test
    public void visualFilterTest(){
        openDetskiyMir();
        openDetskajaOdezhda();
    }

    public void openDetskiyMir(){
        HomePage homepage = new HomePage(driver);
        homepage.open();
        homepage.openDetskijMir();
        ChildPage childPage = new ChildPage(driver);
        Assert.assertTrue(childPage.isOpened());
    }

    public void openDetskajaOdezhda(){
        ChildPage childPage = new ChildPage(driver);
        childPage.openOdezhda();
        ChildDressPage childDressPage = new ChildDressPage(driver);
        Assert.assertTrue(childDressPage.isOpened());
    }

}
