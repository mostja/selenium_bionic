package entities;

import org.openqa.selenium.By;

/**
 * Created by Mostja on 16-Mar-15.
 */
public class ErrorMessages {
    public static final By TITLE_ERROR = By.cssSelector("label.error[for='add-title']");
    public static final By DESCRIPTION_ERROR = By.cssSelector("label.error[for='add-description']");
    public static final By SIZE_ERROR = By.cssSelector("label.error[for='param79']");
    public static final By NAME_ERROR = By.cssSelector("label.error[for='add-person']");
    public static final By EMAIL_ERROR = By.cssSelector("label.error[for='add-email']");
}
