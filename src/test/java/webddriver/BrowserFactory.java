package webddriver;

import bsh.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.PropertyLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by c2614 on 04.03.2015.
 */
public class BrowserFactory {
       public static Browser create(String name){
        Browser browser = null;
        if("firefox".equals(name))
            browser = new Browser(new FirefoxDriver());
        else if ("chrome".equals(name)){
            String projectPath = PropertyLoader.loadProperty("project.path");
            String filePath = "/src/main/resources/chromedriver.exe";
            File file = new File(projectPath+filePath);
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            browser = new Browser(new ChromeDriver());
        } else
        browser = new Browser(new FirefoxDriver());

        return browser;
    }
}
