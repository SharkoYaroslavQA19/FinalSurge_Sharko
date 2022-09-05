package tests;

import Utils.DateFactory;
import io.qameta.allure.Description;
import models.Workout;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Modals.AddWorkoutModal;
import pages.WorkoutDetailsPage;
import pages.WorkoutsPage;

public class WorkoutsTest extends BaseTest{
    protected AddWorkoutModal AddWorkoutModal;
    protected pages.WorkoutsPage WorkoutsPage;
    protected pages.WorkoutDetailsPage WorkoutDetailsPage;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        LoginPage.setEmailInput(EMAIL);
        LoginPage.setPasswordInput(PASSWORD);
        LoginPage.clickLoginButton();
        AddWorkoutModal = new AddWorkoutModal(driver);
        WorkoutsPage = new WorkoutsPage (driver);
        WorkoutDetailsPage = new WorkoutDetailsPage(driver);
    }

    @Test(groups = {"Smoke"},description = "Adding Cross Training workout and verifying workout details")
    public void addStrengthTrainingTest() {
        HomePage.clickAddWorkout();
        Assert.assertTrue(WorkoutsPage.isPageOpened());
        WorkoutsPage.clickStrengthTrainingButton();
        Workout strengthTraining= DateFactory.addStrengthTraining();
        AddWorkoutModal.fillForm(strengthTraining).clickAddWorkoutButton();
        Assert.assertEquals(strengthTraining,WorkoutDetailsPage.getAddedWorkoutDetails());
    }
}