package functional;

import entities.Advertisement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAdPage;
import pages.ReviewAdPage;

/**
 * Created by Mostja on 02-Mar-15.
 */
public class CreateAdTest extends AbstractTest {
    @Test
    public void createAdTest(){
        CreateAdPage createAd = home.openCreateAd();
        createAd.setAd(new Advertisement());
        createAd.acceptLicenseAgreement();
        ReviewAdPage review = createAd.createAd();
        Assert.assertTrue(review.isOpened());
    }
}
