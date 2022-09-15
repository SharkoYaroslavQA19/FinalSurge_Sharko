package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(groups={"smoke"},description = "authorization on the site")
    public void positiveLoginTest(){
        loginPage.setEmailInput(EMAIL);
        loginPage.setPasswordInput(PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isUserIconDisplayed());
    }

    @Test(groups = {"negative"}, dataProvider = "getNegativeLoginData",description = "Authorization with incorrect email")
    public void negativeLoginTest(String email, String password,String errorMessage) {
        loginPage.setEmailInput(email);
        loginPage.setPasswordInput(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageForEmailDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageForEmailText(),errorMessage);
    }

    @DataProvider
    public Object[][] getNegativeLoginData() {
        return new Object[][]{
                {"sharko", PASSWORD, "Please enter a valid email address."},
                {"", PASSWORD, "Please enter your e-mail address."}
        };
    }
}
