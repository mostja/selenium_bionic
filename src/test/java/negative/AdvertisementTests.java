package negative;

import entities.Advertisement;
import entities.ErrorMessages;
import functional.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAdPage;
import pages.ReviewAdPage;
import utils.DataGenerator;

/**
 * Created by c2614 on 02.03.2015.
 */
public class AdvertisementTests extends AbstractTest {

    @DataProvider (name = "invalidTitles")
    public Object[][] invalidTitles() {
        return new Object[][] {
                new Object[] {"bla", "Заголовок должен быть не короче 5 знаков"},
                new Object[] {"", "Пожалуйста, укажите заголовок"},
                new Object[] {DataGenerator.getRandomEmail(), "Поле заполнено неверно. Указание email или адреса сайта запрещено.."}
        };
    }

    @DataProvider (name = "invalidDescription")
     public Object[][] invalidDescription() {
        return new Object[][] {
                new Object[] {"bla", "Описание должно быть не короче 50 знаков"},
                new Object[] {"", "добавьте описание объявления"},
                new Object[] {DataGenerator.getRandomStringUpperCase(55), "Слишком много заглавных букв"}
        };
    }

    @DataProvider (name = "invalidSize")
     public Object[][] invalidSize() {
        return new Object[][] {
                new Object[] {1000, "Введите значение меньшее или равное 999"},
                new Object[] {0, "Введите значение большее или равное 1"}
        };
    }

    @DataProvider (name = "invalidName")
    public Object[][] invalidName() {
        return new Object[][] {
                new Object[] {"", "Пожалуйста, укажите имя контактного лица"},
                new Object[] {DataGenerator.getRandomString(51), "Не может быть длинее 50 символов"},
                new Object[] {DataGenerator.getRandomString(1), "Не может быть короче 2 символов"}
        };
    }

    @DataProvider (name = "invalidEmail")
    public Object[][] invalidEmail() {
        return new Object[][] {
                new Object[] {DataGenerator.getRandomString(5), "Email-адрес не похож на настоящий"},
                new Object[] {"", "Пожалуйста, укажите email-адрес"}
        };
    }


    @Test (dataProvider = "invalidTitles")
    public void invalidTitleTest(String title, String error){
        Advertisement adv = new Advertisement();
        adv.title = title;
        CreateAdPage advPage = home.openCreateAd();
        advPage.setAd(adv);
        advPage.acceptLicenseAgreement();
        advPage.createAd();
        Assert.assertEquals((driver.findElement(ErrorMessages.TITLE_ERROR).getText()), error);
        logger.info("Error "+"\""+error+"\""+"is present");
    }

    @Test (dataProvider = "invalidDescription")
    public void invalidDescriptionTest(String description, String error){
        Advertisement adv = new Advertisement();
        adv.description = description;
        CreateAdPage advPage = home.openCreateAd();
        advPage.setAd(adv);
        advPage.acceptLicenseAgreement();
        advPage.createAd();
        Assert.assertEquals((driver.findElement(ErrorMessages.DESCRIPTION_ERROR).getText()), error);
        logger.info("Error "+"\""+error+"\""+"is present");
    }

    @Test (dataProvider = "invalidSize")
     public void invalidSizeTest(int size, String error){
        Advertisement adv = new Advertisement();
        adv.size = size;
        CreateAdPage advPage = home.openCreateAd();
        advPage.setAd(adv);
        advPage.acceptLicenseAgreement();
        advPage.createAd();
        Assert.assertEquals((driver.findElement(ErrorMessages.SIZE_ERROR).getText()), error);
        logger.info("Error "+"\""+error+"\""+"is present");
    }

    @Test (dataProvider = "invalidName")
    public void invalidNameTest(String name, String error){
        Advertisement adv = new Advertisement();
        adv.name = name;
        CreateAdPage advPage = home.openCreateAd();
        advPage.setAd(adv);
        advPage.acceptLicenseAgreement();
        advPage.createAd();
        Assert.assertEquals((driver.findElement(ErrorMessages.NAME_ERROR).getText()), error);
        logger.info("Error "+"\""+error+"\""+"is present");
    }

    @Test (dataProvider = "invalidEmail")
    public void invalidEmailTest(String email, String error){
        Advertisement adv = new Advertisement();
        adv.email = email;
        CreateAdPage advPage = home.openCreateAd();
        advPage.setAd(adv);
        advPage.acceptLicenseAgreement();
        advPage.createAd();
        Assert.assertEquals((driver.findElement(ErrorMessages.EMAIL_ERROR).getText()), error);
        logger.info("Error "+"\""+error+"\""+"is present");
    }
}
