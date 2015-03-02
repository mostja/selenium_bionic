package functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KidsDressPage;
import pages.KidsWorldPage;

/**
 * Created by c2614 on 23.02.2015.
 */
public class VisualFilterTest extends AbstractTest{

    @Test
    public void visualFilterTest(){
        KidsWorldPage kidsWorld = home.openKidsWorld();
        Assert.assertTrue(kidsWorld.isOpened());
        KidsDressPage kidsDress = kidsWorld.openKidsDress();
        Assert.assertTrue(kidsDress.isOpened());
    }

}
