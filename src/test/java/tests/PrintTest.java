package tests;

import Utils.TestDataFactory;
import io.qameta.allure.Description;
import models.DatePeriod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Modals.PrintWorkoutModal;
import pages.PrintPage;

import static org.testng.Assert.assertTrue;

public class PrintTest extends BaseTest {

    PrintWorkoutModal printWorkoutModal;
    PrintPage printPage;


    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        loginPage.setEmailInput(EMAIL);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        printWorkoutModal = new PrintWorkoutModal(driver);
        printPage = new PrintPage(driver);
    }



    @Test(description = "Opening print page with workouts for the selected time period",groups = {"regression"})
    public void printWorkoutsTest() {
        homePage.clickPrintWorkouts();
        DatePeriod periodForPrint = TestDataFactory.getDatePeriod();
        printWorkoutModal.fillForm(periodForPrint);
        assertTrue(printPage.isPageOpened());
    }
}