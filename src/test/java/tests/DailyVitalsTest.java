package tests;

import Utils.TestDataFactory;
import models.DatePeriod;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DailyVitalsPage;
import pages.Modals.CustomViewModal;

import static org.testng.Assert.assertEquals;

public class DailyVitalsTest extends BaseTest{

    DailyVitalsPage dailyVitalsPage;
    CustomViewModal customViewModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        loginPage.setEmailInput(EMAIL);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        dailyVitalsPage = new DailyVitalsPage(driver);
        customViewModal = new CustomViewModal(driver);
    }

    @Test(groups = {"regression"},description = "Displaying daily vitals for the selected time period")
    public void viewVitalsTest() {
        Assert.assertTrue(homePage.isUserIconDisplayed());
        homePage.clickViewAddVitals();
        DatePeriod periodForView = TestDataFactory.getDatePeriod();
        dailyVitalsPage.clickCustomView()
                .fillForm(periodForView)
                .clickViewButton();
        assertEquals(dailyVitalsPage.getLastDateInTable(), periodForView.getEndDate());
    }
}