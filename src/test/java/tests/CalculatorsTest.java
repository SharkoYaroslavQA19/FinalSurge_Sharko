package tests;

import Utils.TestDataFactory;
import io.qameta.allure.Description;
import models.CaloricNeeds;
import models.PaceCalculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Modals.CaloricNeedsModal;
import pages.Modals.PaceCalculatorModal;

import static org.testng.Assert.assertTrue;

public class CalculatorsTest extends BaseTest {

    protected CaloricNeedsModal caloricNeedsModal;
    protected PaceCalculatorModal paceCalculatorModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        loginPage.setEmailInput(EMAIL);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        homePage.clickOtherCalculators();
        caloricNeedsModal = new CaloricNeedsModal(driver);
        paceCalculatorModal = new PaceCalculatorModal(driver);
    }


    @Test(groups = {"regression"})
    @Description(value = "Using 'Other Calculators' to calculate daily caloric needs")
    public void calculateCaloricNeedsTest() {
        CaloricNeeds form = TestDataFactory.getCaloricNeedInform();
        caloricNeedsModal.fillForm(form)
                .clickCalculateButton();
        assertTrue(caloricNeedsModal.caloricNeedsIsVisible());
    }

    @Test(groups = {"regression"})
    @Description(value = "Using 'Other Calculators' to calculate pace")
    public void paceCalculatorTest() {
        PaceCalculator form = TestDataFactory.getPaceCalculatorInform();
        caloricNeedsModal.clickPaceCalculatorButton()
                .fillForm(form)
                .clickCalculateButton();
        assertTrue(paceCalculatorModal.paceChartIsVisible());
    }
}