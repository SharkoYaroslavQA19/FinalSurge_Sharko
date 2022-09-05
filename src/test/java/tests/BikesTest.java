package tests;

import Utils.DateFactory;
import io.qameta.allure.Description;
import models.Bike;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BikesPage;
import pages.Modals.BikeModal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BikesTest extends BaseTest {

    protected BikesPage BikesPage;
    protected BikeModal BikeModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        LoginPage.setEmailInput(EMAIL);
        LoginPage.setPasswordInput(PASSWORD);
        LoginPage.clickLoginButton();
        BikesPage = new BikesPage(driver);
        BikeModal = new BikeModal(driver);
    }


    @Test(groups = {"Smoke"})
    @Description(value = "Adding 'New bike' equipment and verifying equipment details")
    public void addNewBikeTest() {
        HomePage.moveGearRoutesMenu();
        HomePage.clickBikes();
        assertTrue(BikesPage.isPageOpened());
        Bike newBikeDetails = DateFactory.getBikeWithAllData();
        BikesPage.fillForm(newBikeDetails).clickAddBikeButton().clickBikeName(newBikeDetails.getBikeName());
        Bike actualBikeDetails = BikeModal.getBikeDetails();
        assertEquals(actualBikeDetails, newBikeDetails);
    }
}
