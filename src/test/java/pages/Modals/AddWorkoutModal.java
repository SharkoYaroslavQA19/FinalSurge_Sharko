package pages.Modals;

import Utils.Screenshots;
import elements.Dropdown;
import elements.Input;
import elements.RadioButton;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AddWorkoutModal extends BaseModal {

    private final static By TIME_OF_DAY=By.id("WorkoutTime");
    private final static By WORKOUT_NAME=By.id("Name");
    private final static By WORKOUT_DESCRIPTION=By.id("Desc");
    private final static By DURATION=By.id("DurationNoInt");
    private final static By PERCEIVED_EFFORT=By.id("PerEffort");
    private final static By ADD_WORKOUT_BUTTON=By.id("saveButton");


    public AddWorkoutModal(WebDriver driver) {
        super(driver);
    }
    public AddWorkoutModal fillForm(Workout workout){
        new Input(driver).write(TIME_OF_DAY, workout.getTimeOfDay());
        new Input(driver).write(WORKOUT_NAME, workout.getWorkoutName());
        new Input(driver).write(WORKOUT_DESCRIPTION, workout.getWorkoutDescription());
        new Input(driver).write(DURATION, workout.getDuration());
        new RadioButton(driver).clickRadioButton(workout.getFeelingWhileTraining().getName());
        new Dropdown(driver).selectOptionByValue(PERCEIVED_EFFORT,workout.getPerceivedEffort().getValue());
        return this;
    }
    public void clickAddWorkoutButton(){
        driver.findElement(ADD_WORKOUT_BUTTON).click();
        Screenshots.attachScreenshot(driver);
    }

}