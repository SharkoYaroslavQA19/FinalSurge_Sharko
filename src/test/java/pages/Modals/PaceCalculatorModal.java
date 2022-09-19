package pages.Modals;

import Utils.Screenshots;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PaceCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PaceCalculatorModal extends BaseModal {

    private final static By DISTANCE = By.id("RunDist");
    private final static By DISTANCE_TYPE = By.id("DistType");
    private final static By HOURS = By.id("TimeHH");
    private final static By MINUTES = By.id("TimeMM");
    private final static By SECONDS = By.id("TimeSS");
    private final static By CALCULATE_PACES_BUTTON = By.id("saveButtonSettings");
    private final static By PACE_CHART_TABLE = By.xpath("//*[@class='w-box-content']/table[contains(@class,'table-condensed table-hover')]");


    public PaceCalculatorModal(WebDriver driver) {
        super(driver);
    }

    @Step("Filling 'Pace Calculator' form")
    public PaceCalculatorModal fillForm(PaceCalculator paceCalculator) {
        new Dropdown(driver).selectOptionByValue(DISTANCE_TYPE, paceCalculator.getDistanceType().getValue());
        new Input(driver).setValue(DISTANCE, paceCalculator.getDistance());
        new Input(driver).setValue(HOURS, paceCalculator.getHours());
        new Input(driver).setValue(MINUTES, paceCalculator.getMinutes());
        new Input(driver).setValue(SECONDS, paceCalculator.getSeconds());
        Screenshots.attachScreenshot(driver);
        return this;
    }

    @Step("Clicking Calculate Pace button")
    public void clickCalculateButton() {
        log.info("clicking 'Calculate Pace' button");
        clickButton(CALCULATE_PACES_BUTTON);
    }

    @Step("Table 'Pace Chart' is visible")
    public boolean paceChartIsVisible() {
        log.info("Table 'Pace Chart' is visible");
        return driver.findElement(PACE_CHART_TABLE).isDisplayed();
    }
}
