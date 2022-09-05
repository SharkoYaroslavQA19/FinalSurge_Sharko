package pages;
import enums.FeelingWhileTraining;
import enums.PerceivedEffort;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WorkoutDetailsPage extends BasePage{
    private static final By VIEW_YOUR_WORKOUT_TEXT= By.xpath("//span[text()='View and Edit your workout.']");
    private static final By ACTUAL_TIME = By.xpath("//div[@class='formSep']/div/small");
    private static final By ACTUAL_NAME = By.xpath("//span[@class='activityTypeName']/parent::div/following-sibling::div");
    private static final By ACTUAL_DESCRIPTION = By.xpath("//small[contains(text(),'Description:')]/ancestor::p");
    private static final By ACTUAL_DURATION = By.xpath("//small[text()='Workout Statistics:']/following-sibling::span[@class='label label-info']");
    private static final By ACTUAL_PERCEIVED_EFFORT = By.xpath("//div[@class='formSep'][3]");
    private static final By ACTUAL_FEELING = By.xpath("//small[text()='How I Felt:']/following-sibling::span");

    public WorkoutDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    public Workout getAddedWorkoutDetails() {
        Workout addedWorkout = new Workout();
        addedWorkout.setTimeOfDay(getActualTime());
        addedWorkout.setWorkoutName(getActualName());
        addedWorkout.setWorkoutDescription(getDescription());
        addedWorkout.setDuration(getActualDuration());
        addedWorkout.setPerceivedEffort(PerceivedEffort.fromString(getActualPerceivedEffort()));
        addedWorkout.setFeelingWhileTraining(FeelingWhileTraining.fromString(getActualFeeling()));
        return addedWorkout;
    }
    @Override
    public boolean isPageOpened() {
        return driver.findElement(VIEW_YOUR_WORKOUT_TEXT).isDisplayed();
    }

    public String getActualName() {
        return driver.findElement(ACTUAL_NAME).getText().trim();
    }

    public String getActualTime() {
        return driver.findElement(ACTUAL_TIME).getText().split("-")[1].trim();
    }

    public String getDescription() {
        return driver.findElement(ACTUAL_DESCRIPTION).getText().split(":")[1].trim();
    }

    public String getActualDuration() {
        return driver.findElement(ACTUAL_DURATION).getText().split(":",2)[1].trim();
    }

    public String getActualPerceivedEffort() {
        return driver.findElement(ACTUAL_PERCEIVED_EFFORT).getText().split("rt")[1].trim();
    }

    public String getActualFeeling() {
        return driver.findElement(ACTUAL_FEELING).getText().trim();
    }


}