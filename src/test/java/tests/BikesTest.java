package tests;

import Utils.TestDataFactory;
import models.Bike;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BikesPage;
import pages.Modals.BikeModal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BikesTest extends BaseTest{

    protected BikesPage bikesPage;
    protected BikeModal bikeModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        loginPage.setEmailInput(EMAIL);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        bikeModal = new BikeModal(driver);
        bikesPage = new BikesPage(driver);
    }


    @Test(groups = {"regression"},description = "Adding 'New bike' equipment and verifying equipment details")
    public void addNewBikeTest() {
        Assert.assertTrue(homePage.isUserIconDisplayed());
        homePage.moveGearRoutesMenu();
        homePage.clickBikes();
        assertTrue(bikesPage.isPageOpened());
        Bike newBikeDetails = TestDataFactory.getBikeWithAllData();
        bikesPage.fillForm(newBikeDetails)
                .clickAddBikeButton()
                .clickBikeName(newBikeDetails.getBikeName());
        Bike actualBikeDetails = bikeModal.getBikeDetails();
        assertEquals(actualBikeDetails, newBikeDetails);
    }
}
