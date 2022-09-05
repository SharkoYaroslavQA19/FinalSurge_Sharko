package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups={"smoke"},description = "authorization on the site")
    public void positiveLoginTest(){
        LoginPage.setEmailInput(EMAIL);
        LoginPage.setPasswordInput(PASSWORD);
        LoginPage.clickLoginButton();
        Assert.assertTrue(HomePage.isUserIconDisplayed());
    }

    @Test(groups = {"negative"}, dataProvider = "getNegativeLoginData",description = "Authorization with incorrect email")
    public void negativeLoginTest(String email, String password,String errorMessage) {
        LoginPage.setEmailInput(email);
        LoginPage.setPasswordInput(password);
        LoginPage.clickLoginButton();
        Assert.assertTrue(LoginPage.isErrorMessageForEmailDisplayed());
        Assert.assertEquals(LoginPage.getErrorMessageForEmailText(),errorMessage);
    }

    @DataProvider
    public Object[][] getNegativeLoginData() {
        return new Object[][]{
                {"sharko", PASSWORD, "Please enter a valid email address."},
                {"", PASSWORD, "Please enter your e-mail address."}
        };
    }
}
