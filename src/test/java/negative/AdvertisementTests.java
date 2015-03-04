package negative;

import entities.Advertisement;
import functional.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAdPage;

/**
 * Created by c2614 on 02.03.2015.
 */
public class AdvertisementTests extends AbstractTest {

    @DataProvider
    public Object[][] negativeAdvs() {
        return new Object[][] {
                new Object[] {"bla", "blabla", "D:/src/test/resourses/images.jpg", "b", "bla.com", 0},

        };
    }

    @Test (dataProvider = "negativeAdvs")
    public void createAdvTest(String title, String description, String url,
                              String name,String email, int size){
        Advertisement adv = new Advertisement();
        adv.title = title;
        adv.description = description;
        adv.photoUrl = url;
        adv.name = name;
        adv.email = email;
        adv.size = size;
        CreateAdPage advPage = home.openCreateAd();
        advPage.setAd(adv);
        Assert.assertTrue(advPage.errorIsPresent());
    }

}
