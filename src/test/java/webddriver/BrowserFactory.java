package webddriver;

import bsh.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import utils.PropertyLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by c2614 on 04.03.2015.
 */
public class BrowserFactory {
//    public static final String hubUrl = "http://192.168.10.49:9999/wd/hub";
//
//       public static Browser create(String name){
//        Browser browser = null;
//        if("firefox".equals(name)){
//            browser = new Browser(new FirefoxDriver());
//        }
//        if("firefox_r".equals(name)){
//            try {
//                 WebDriver driver = new RemoteWebDriver(new URL(hubUrl), DesiredCapabilities.firefox());
//               } catch (MalformedURLException e) {
//                   e.printStackTrace();
//               }
//           }
//        else if ("chrome".equals(name)){
//            String projectPath = PropertyLoader.loadProperty("project.path");
//            String filePath = "/src/main/resources/chromedriver.exe";
//            File file = new File(projectPath+filePath);
//            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
//            browser = new Browser(new ChromeDriver());
//        } else
//        browser = new Browser(new FirefoxDriver());
//
//        return browser;
//    }
    public static final String hubUrl = "http://192.168.10.49:9999/wd/hub";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String FIREFOX_REMOTE = "firefox_r";
    public static final String HTML_UNIT = "htmlunit";

    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String MAC = "mac";

    public static Browser create(String browser)
    {
        Browser testDriver = setDefaultConfiguration(browser);
        return testDriver;
    }

    private static Browser setDefaultConfiguration(String browser)
    {
        WebDriver driver = null;
        DesiredCapabilities capabilities = setDefaultCapabilities(browser);

        if (browser.equals(FIREFOX))
        {
            driver = new FirefoxDriver(capabilities);
        } else
        if (browser.equals(CHROME))
        {
            String projectPath = PropertyLoader.loadProperty("project.path");
            String filePath = "/src/main/resources/chromedriver.exe";
            File file = new File(projectPath+filePath);
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new Browser(new ChromeDriver());
        } else
        if (browser.equals(FIREFOX_REMOTE))
        {
            try {
                 driver = new RemoteWebDriver(new URL(hubUrl), DesiredCapabilities.firefox());
               } catch (MalformedURLException e) {
                   e.printStackTrace();
               }
        } else
        if (browser.equals(HTML_UNIT))
        {
            driver = new HtmlUnitDriver(capabilities);
        } else
            Assert.fail("Browser configuration error");

        //additional configuration
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new Browser(driver);
    }

    private static WebDriver setScreenResolution(WebDriver driver)
    {
        int xDimension = Integer.parseInt(PropertyLoader.loadProperty("selenium.screen.x"));
        int yDimension = Integer.parseInt(PropertyLoader.loadProperty("selenium.screen.y"));
        driver.manage().window().setSize(new Dimension(xDimension,yDimension));
        return driver;
    }

    private static DesiredCapabilities setDefaultCapabilities(String browser)
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities = setPlatform(capabilities,"");

        if (browser.contains(FIREFOX)){
            capabilities = DesiredCapabilities.firefox();
        } else
        if (browser.contains(CHROME)){
            capabilities = DesiredCapabilities.chrome();
        } else
        if (browser.contains(HTML_UNIT)){
            capabilities = DesiredCapabilities.htmlUnit();
        }else
            Assert.fail("No configuration available for driver");

        return capabilities;
    }

    private static DesiredCapabilities setPlatform(DesiredCapabilities capabilities,String platformName)
    {
        if (platformName.equals(MAC))
        {
            capabilities.setPlatform(Platform.MAC);
        } else
        {
            capabilities.setPlatform(Platform.WINDOWS);
        }
        return capabilities;
    }
}
