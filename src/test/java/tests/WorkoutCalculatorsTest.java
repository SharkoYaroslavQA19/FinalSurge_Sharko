package tests;

import Utils.TestDataFactory;
import models.WorkoutCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Modals.HansonsCalculatorModal;
import pages.Modals.IntensityCalculatorModal;

import static org.testng.Assert.assertTrue;

public class WorkoutCalculatorsTest extends BaseTest {

    IntensityCalculatorModal intensityCalculatorModal;
    HansonsCalculatorModal hansonsCalculatorModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        loginPage.setEmailInput(EMAIL);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        intensityCalculatorModal = new IntensityCalculatorModal(driver);
        hansonsCalculatorModal = new HansonsCalculatorModal(driver);
    }


    @Test(groups = {"regression"},description = "using a calculator to calculate intensive running")
    public void calculateIntensityTest() {
        WorkoutCalculator intensityForm = TestDataFactory.getIntesityInform();
        homePage.clickWorkoutCalculators()
                .fillForm(intensityForm)
                .clickCalculateButton();
        assertTrue(intensityCalculatorModal.presetTextIsVisible());
    }


    @Test(groups = {"regression"},description = "using a calculator to calculate Hanson's the morathon")
    public void calculateHansonsTest() {
        WorkoutCalculator hansonForm = TestDataFactory.getHansonsInform();
        homePage.clickWorkoutCalculators()
                .openHansonCalculator()
                .fillForm(hansonForm)
                .clickCalculateButton();
        assertTrue(hansonsCalculatorModal.presetTextIsVisible());
    }
}