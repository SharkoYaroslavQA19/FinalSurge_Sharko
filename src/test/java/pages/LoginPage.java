package pages;

import Utils.PropertyReader;
import Utils.Screenshots;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class LoginPage extends BasePage{

    private final static String URL = System.getenv().getOrDefault("URL", PropertyReader.getProperty("finalSurge.url"));
    private static final By EMAIL_INPUT = By.id("login_name");
    private static final By PASSWORD_INPUT = By.id("login_password");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Login']");
    private static final By ACCOUNT_LOGOUT_MESSAGE = By.cssSelector("[class^='alert']");
    private final static By ERROR_MESSAGE_TEXT = By.xpath("//label[@for='login_name' and @class='error']");
    private final static By ERROR_MASSAGE_FORM_TEXT = By.xpath("//div[contains(@class, 'alert-error')]/strong");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(LOGIN_BUTTON);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Step("Set Email")
    public void setEmailInput(String email) {
        log.info("Set Email");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("Set Password")
    public void setPasswordInput(String password) {
        log.info("Set Password");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Click Login button")
    public void clickLoginButton() {
        log.info("Click Login button");
        clickButton(LOGIN_BUTTON);
        Screenshots.attachScreenshot(driver);
    }
    @Step("message about successfully logged out of the system")
    public String getLogoutMessage() {
        log.info("message about successfully logged out of the system");
        return driver.findElement(ACCOUNT_LOGOUT_MESSAGE).getText();
    }
    @Step("Checking the presence of error message on display")
    public boolean isErrorMessageForEmailDisplayed() {
        return driver.findElement(ERROR_MESSAGE_TEXT).isDisplayed();
    }

    public String getErrorMessageForEmailText() {
        return driver.findElement(ERROR_MESSAGE_TEXT).getText();
    }

    @Step("Checking the presence of error message on display")
    public boolean isErrorMessageForFormDisplayed() {
        return driver.findElement(ERROR_MASSAGE_FORM_TEXT).isDisplayed();
    }

    public String getErrorMessageForFormText() {
        return driver.findElement(ERROR_MASSAGE_FORM_TEXT).getText();
    }

    public void open() {
        driver.get(URL);
    }
}
