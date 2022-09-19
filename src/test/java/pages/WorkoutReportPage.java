package pages;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutReportPage extends BasePage{

    private static final By VIEW_REPORT_BUTTON = By.id("saveButton");
    private static final By STARTING_DATE = By.id("WorkoutDate");
    private static final By ENDING_DATE = By.id("WorkoutDateEnd");
    private static final By ACTIVITY_TYPE = By.id("ActivityType");
    private static final By ACTIVITY_COLUMN_OF_TABLE = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[1]/td[2]");


    public WorkoutReportPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    @Step("Filling 'Report Filters' form")
    public WorkoutReportPage fillForm(Report report) {
        new Input(driver).clear(STARTING_DATE);
        new Input(driver).setValue(STARTING_DATE, report.getStartDate());
        new Input(driver).clear(ENDING_DATE);
        new Input(driver).setValue(ENDING_DATE, report.getEndDate());
        new Dropdown(driver).selectOptionByVisibleText(ACTIVITY_TYPE, report.getActivityType().getName());
        return this;
    }

    @Step("Clicking 'View Report' button")
    public void clickViewReportButton() {
        log.info("clicking 'View Report' button");
        clickButton(VIEW_REPORT_BUTTON);
    }

    @Step("Getting data from the actions column in the results table")
    public String getActivityFromTable() {
        log.info("getting data from the actions column in the results table");
        return driver.findElement(ACTIVITY_COLUMN_OF_TABLE).getText();
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(VIEW_REPORT_BUTTON).isDisplayed();
    }
}