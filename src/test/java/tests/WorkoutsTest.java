package tests;

import Utils.TestDataFactory;
import models.Workout;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Modals.AddWorkoutModal;
import pages.WorkoutDetailsPage;
import pages.WorkoutsPage;

public class WorkoutsTest extends BaseTest{
    protected AddWorkoutModal addWorkoutModal;
    protected WorkoutsPage workoutsPage;
    protected WorkoutDetailsPage workoutDetailsPage;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        loginPage.setEmailInput(EMAIL);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        addWorkoutModal = new AddWorkoutModal(driver);
        workoutsPage = new WorkoutsPage(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
    }

    @Test(groups = {"smoke"},description = "Adding Cross Training workout and verifying workout details")
    public void addStrengthTrainingTest() {
        homePage.clickAddWorkout();
        Assert.assertTrue(workoutsPage.isPageOpened());
        workoutsPage.clickStrengthTrainingButton();
        Workout strengthTraining= TestDataFactory.addStrengthTraining();
        addWorkoutModal.fillForm(strengthTraining)
                .clickAddWorkoutButton();
        Assert.assertEquals(strengthTraining,workoutDetailsPage.getAddedWorkoutDetails());
    }
}