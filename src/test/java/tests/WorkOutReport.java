package tests;

import Utils.TestDataFactory;
import io.qameta.allure.Description;
import models.Report;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WorkoutReportPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class WorkOutReport extends BaseTest {
    WorkoutReportPage workoutReportPage;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        loginPage.setEmailInput(EMAIL);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        workoutReportPage = new WorkoutReportPage(driver);
    }

    @Test(groups = {"regression"})
    @Description("Reporting on workouts of the selected type for the selected period")
    public void reportWorkoutTest() {
        assertTrue(homePage.isUserIconDisplayed());
        homePage.clickReportsAndStatistics();
        assertTrue(workoutReportPage.isPageOpened());
        Report reportView = TestDataFactory.getReportInform();
        workoutReportPage.fillForm(reportView)
                .clickViewReportButton();
        assertEquals(workoutReportPage.getActivityFromTable(), reportView.getActivityType().getName());
    }
}