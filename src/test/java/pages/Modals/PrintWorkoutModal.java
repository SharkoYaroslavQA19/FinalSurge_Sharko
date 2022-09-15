package pages.Modals;

import Utils.Screenshots;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.DatePeriod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PrintWorkoutModal extends BaseModal {

    private static final By STARTING_DATE = By.name("PrintStartDate");
    private static final By ENDING_DATE = By.id("PrintEndDate");
    private static final By PRINT_WORKOUTS_BUTTON = By.id("saveButtonPrint");
    private static final By PRINT_WORKOUTS_IFRAME = By.id("PrintWorkoutsiFrame");


    public PrintWorkoutModal(WebDriver driver) {
        super(driver);
    }
    @Step("Filling 'Print Workouts' form")
    public void fillForm( DatePeriod printWorkouts) {
        driver.switchTo().frame(driver.findElement(PRINT_WORKOUTS_IFRAME));
        new Input(driver).setValue(STARTING_DATE, printWorkouts.getStartDate());
        new Input(driver).setValue(ENDING_DATE, printWorkouts.getEndDate());
        Screenshots.attachScreenshot(driver);
        clickPrintWorkoutsButton();
        driver.switchTo().defaultContent();
    }
    @Step("Clicking 'Print Workouts' button")
    public void clickPrintWorkoutsButton() {
        log.info("clicking 'Print Workouts' button");
        clickButton(PRINT_WORKOUTS_BUTTON);
    }

}
