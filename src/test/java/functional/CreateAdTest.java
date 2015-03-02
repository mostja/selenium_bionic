package functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateAdPage;
import pages.CreateAdRubric;
import pages.DataGenerator;
import pages.ReviewAdPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mostja on 02-Mar-15.
 */
public class CreateAdTest extends AbstractTest {
    @Test
    public void createAdTest(){
        CreateAdPage createAd = home.openCreateAd();
        String title = DataGenerator.getRandomString(10);
        int size = DataGenerator.getRandomInt(50);
        String description = DataGenerator.getRandomString(55);
        File photoFile = new File("D:\\Selenium\\Khalash_Bionic\\src\\main\\resources\\image.jpg");
        String photoUrl = photoFile.getAbsolutePath();
        String name = DataGenerator.getRandomString(10);
        String email = DataGenerator.getRandomEmail();
        ReviewAdPage review = createAd.reviewAd(title, size, description, photoUrl, name, email);
        Assert.assertTrue(review.isOpened());
    }
}
