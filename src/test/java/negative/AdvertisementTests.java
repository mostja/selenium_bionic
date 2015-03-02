package negative;

import entities.Advertisement;
import functional.AbstractTest;
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
                new Object[] {"title", "url", "smth"},
                new Object[] {"another", "newOne", "correctOne"}
        };
    }

    @Test (dataProvider = "negativeAdvs")
    public void createAdvTest(String title, String url, String smth){
        Advertisement adv = new Advertisement(false);
        adv.title = title;
        adv.photoUrl = url;
        adv.desrcr = smth;
        CreateAdPage advPage = new CreateAdPage(driver);


    }

}
