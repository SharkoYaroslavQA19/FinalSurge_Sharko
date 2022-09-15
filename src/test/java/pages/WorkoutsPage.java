package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class WorkoutsPage extends BasePage{
    private final static By ACTIVITIES_SIDEBAR = By.cssSelector(".aw_sidebar");
    private final static By STRENGTH_TRAINING_BUTTON_LOCATOR = By.xpath("//a[@data-code='strength-t']");

    public WorkoutsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageLoaded() {

    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(ACTIVITIES_SIDEBAR).isDisplayed();
    }
    @Step("add new workout")
    public void clickStrengthTrainingButton() {
        log.info("add new workout");
        driver.findElement(STRENGTH_TRAINING_BUTTON_LOCATOR).click();
    }
}