package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest{
    protected String EXPECTED_MESSAGE="You have been successfully logged out of the system.";

    @Test(groups={"regression"},description = "Logout user")
    public void logOutTest(){
        LoginPage.setEmailInput(EMAIL);
        LoginPage.setPasswordInput(PASSWORD);
        LoginPage.clickLoginButton();
        Assert.assertTrue(HomePage.isUserIconDisplayed());
        HomePage.clickLogOutButton();
        Assert.assertEquals(LoginPage.getLogoutMessage(),EXPECTED_MESSAGE);
    }
}
