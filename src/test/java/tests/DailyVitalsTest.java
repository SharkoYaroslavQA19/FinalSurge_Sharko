package tests;

import Utils.DateFactory;
import io.qameta.allure.Description;
import models.DatePeriod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DailyVitalsPage;
import pages.Modals.CustomViewModal;

import static org.testng.Assert.assertEquals;

public class DailyVitalsTest extends BaseTest {

    DailyVitalsPage DailyVitalsPage;
    CustomViewModal CustomViewModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        LoginPage.setEmailInput(EMAIL);
        LoginPage.setPasswordInput(PASSWORD);
        LoginPage.clickLoginButton();
        HomePage.clickViewAddVitals();
        DailyVitalsPage = new DailyVitalsPage(driver);
        CustomViewModal = new CustomViewModal(driver);
    }

    @Test(groups = {"Regression"})
    @Description(value = "Displaying daily vitals for the selected time period")
    public void viewVitalsTest() {
        DatePeriod periodForView = DateFactory.getDatePeriod();
        DailyVitalsPage.clickCustomView().fillForm(periodForView).clickViewButton();
        assertEquals(DailyVitalsPage.getLastDateInTable(), periodForView.getEndDate());
    }
}