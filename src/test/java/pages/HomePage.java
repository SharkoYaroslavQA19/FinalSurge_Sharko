package pages;

import Utils.Screenshots;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.Modals.IntensityCalculatorModal;

@Log4j2
public class HomePage extends BasePage {
    private final static By USER_ICON = By.id("LayoutProfilePic");
    private final static By LOGOUT = By.xpath("//a[text()='Logout']");
    private final static By WORKOUTS_MENU_LOCATOR = By.xpath("//a[text()='Workouts']");
    private final static By ADD_WORKOUT_BUTTON = By.xpath("//a[text()='Add Workout']");
    private static final By GEAR_ROUTES_MENU = By.xpath("//a[text()='Gear & Routes']");
    private static final By BIKES_LINK = By.xpath("//a[text()='Bikes']");
    private static final By DAILY_VITALS_MENU = By.xpath("//a[text()='Daily Vitals']");
    private static final By VIEW_ADD_VITALS_LINK = By.xpath("//a[text()='View & Add Vitals']");
    private static final By REPORTS_STATISTICS_LINK = By.xpath("//a[text()='Reports & Statistics']");
    private static final By PRINT_WORKOUTS_LINK = By.xpath("//a[text()='Print Workouts']");
    private static final By WORKOUT_CALCULATORS_LINK = By.cssSelector("[data-reveal-id='IntensityCalc']");
    Actions action = new Actions(driver);
    public HomePage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void waitForPageLoaded() {

    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Step("presence of user icon on display")
    public boolean isUserIconDisplayed() {
        return driver.findElement(USER_ICON).isDisplayed();
    }

    @Step("Clicking Logout button")
    public void clickLogOutButton(){
       log.info("Clicking Logout button");
       clickButton(LOGOUT);
       Screenshots.attachScreenshot(driver);
    }


    @Step("Moving to menu section")
    public void moveMenuSection(By locator) {
        log.info("Moving to menu section");
        action.moveToElement(driver.findElement(locator)).perform();
    }
    @Step("Moving to Workouts Menu")
    public void moveToWorkoutsMenu() {
        log.info("Moving to Workouts Menu");
        action.moveToElement(driver.findElement(WORKOUTS_MENU_LOCATOR)).perform();
    }
    @Step("Clicking add Workout link")
    public void clickAddWorkout() {
        moveToWorkoutsMenu();
        log.info("Clicking add Workout link");
        driver.findElement(ADD_WORKOUT_BUTTON).click();

    }

    @Step("Clicking 'Reports & Statistics' link")
    public void clickReportsAndStatistics() {
        moveToWorkoutsMenu();
        log.info("clicking 'Reports & Statistics' link");
        clickButton(REPORTS_STATISTICS_LINK);
    }

    @Step("Moving to 'Gear & Routes' menu")
    public void moveGearRoutesMenu() {
        log.info("moving to 'Gear & Routes' menu");
        moveMenuSection(GEAR_ROUTES_MENU);
    }
    @Step("Clicking 'Bikes' link")
    public void clickBikes() {
        moveGearRoutesMenu();
        log.info("clicking 'Bikes' link");
        clickButton(BIKES_LINK);
    }

    @Step("Clicking 'Bikes' link")
    public void clickShoes() {
        moveGearRoutesMenu();
        log.info("clicking 'Bikes' link");
        clickButton(BIKES_LINK);
    }

    @Step("Moving to 'Daily Vitals' menu")
    public void moveDailyVitalsMenu() {
        log.info("moving to 'Daily Vitals' menu");
        moveMenuSection(DAILY_VITALS_MENU);
    }

    @Step("Clicking 'View & Add Vitals' link")
    public void clickViewAddVitals() {
        moveDailyVitalsMenu();
        log.info("clicking 'View & Add Vitals' link");
        clickButton(VIEW_ADD_VITALS_LINK);
    }

    @Step("Clicking 'Print Workouts' link")
    public void clickPrintWorkouts() {
        moveToWorkoutsMenu();
        log.info("clicking 'Print Workouts' link");
        clickButton(PRINT_WORKOUTS_LINK);
    }

    @Step("Clicking 'Workout Calculators' link")
    public IntensityCalculatorModal clickWorkoutCalculators() {
        log.info("clicking 'Workout Calculators' link");
        clickButton(WORKOUT_CALCULATORS_LINK);
        return new IntensityCalculatorModal(driver);
    }
}
