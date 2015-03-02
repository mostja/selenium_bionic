package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mostja on 02-Mar-15.
 */
public class CreateAdPage extends AbstractPage{
    protected WebDriverWait wait;
    protected Actions actions;

    public CreateAdPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
    }

    @Override
    public boolean isOpened() {
        return false;
    }

    public ReviewAdPage reviewAd(String title,
                                 int size, String description, String photoUrl,
                                 String name, String email){
        setTitle(title);
        setRubric();
        setPrise();
        setState();
        setSize(size);
        setBusiness();
        setDescription(description);
        addPhoto(photoUrl);
        setRegion();
        setName(name);
        setEmail(email);
        acceptLicenseAgreement();

        driver.findElement(By.xpath(".//*[@id='preview-link']/span")).click();

        return new ReviewAdPage(driver);
    }

    private void setTitle(String title){
        driver.findElement(By.xpath(".//*[@id='add-title']")).sendKeys(title);
    }

    private void setRubric(){
        driver.findElement(By.xpath(".//*[@id='targetrenderSelect1-0']/dt/a")).click();
        waitAndClick(By.xpath(".//*[@id='cat-36']/span[1]"));
        waitAndClick(By.xpath(".//*[@id='category-36']/div[2]/div[2]/div/ul/li[1]/a/span[1]"));
        driver.findElement(By.xpath(".//*[@id='category-539']/div[2]/div[2]/div/ul/li[1]/a/span[1]")).click();
    }
    private void waitAndClick(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    private void setPrise(){
        waitAndClick(By.xpath(".//*[@id='parameter-div-price']/div[2]/div/div[1]/p[1]/label[1]"));
    }

    private void setState(){
        driver.findElement(By.xpath(".//*[@id='targetparam13']/dt/a")).click();
        driver.findElement(By.xpath(".//*[@id='targetparam13']/dd/ul/li[2]/a")).click();
    }

    private void setSize(int size){
        driver.findElement(By.xpath(".//*[@id='parameter-div-size']/div[2]/div/input")).sendKeys(Integer.toString(size));
    }

    private void setBusiness(){
        driver.findElement(By.xpath(".//*[@id='targetid_private_business']/dt/a")).click();
        driver.findElement(By.xpath(".//*[@id='targetid_private_business']/dd/ul/li[2]/a")).click();
    }

    private void setDescription(String description){
        driver.findElement(By.xpath(".//*[@id='add-description']")).sendKeys(description);
    }

    private void addPhoto(String url){
        driver.findElement(By.xpath(".//*[@id='add-file-1']/div/a/span")).click();
        setClipboardData(url);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(900);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    private static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    private void setRegion(){
        driver.findElement(By.xpath(".//*[@id='targetregion-id-select']/dt/a")).click();
        driver.findElement(By.xpath(".//*[@id='targetregion-id-select']/dd/ul/li[2]/a")).click();
        driver.findElement(By.xpath(".//*[@id='targetsubregion-id-select']/dt/a")).click();
        driver.findElement(By.xpath(".//*[@id='targetsubregion-id-select']/dd/ul/li[2]/a")).click();
    }

    private void setName(String name){
        driver.findElement(By.xpath(".//*[@id='add-person']")).sendKeys(name);
    }

    private void setEmail(String email){
        driver.findElement(By.xpath(".//*[@id='add-email']")).sendKeys(email);
    }

    private void acceptLicenseAgreement(){
        driver.findElement(By.xpath(".//*[@id='accept']/div/div[2]/div/label")).click();
    }
}
