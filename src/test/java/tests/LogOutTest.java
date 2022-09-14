package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest {
    protected String EXPECTED_MESSAGE="You have been successfully logged out of the system.";

    @Test(groups={"regression"},description = "Logout user")
    public void logOutTest(){
        loginPage.setEmailInput(EMAIL);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isUserIconDisplayed());
        homePage.clickLogOutButton();
        Assert.assertEquals(loginPage.getLogoutMessage(),EXPECTED_MESSAGE);
    }
}
