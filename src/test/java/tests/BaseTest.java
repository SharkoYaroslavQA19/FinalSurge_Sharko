package tests;

import Utils.DriverFactory;
import Utils.PropertyReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest{
    protected final static String EMAIL = System.getenv().getOrDefault("EMAIL", PropertyReader.getProperty("finalSurge.email"));
    protected final static String PASSWORD = System.getenv().getOrDefault("PASSWORD", PropertyReader.getProperty("finalSurge.password"));
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "firefox");
        driver = DriverFactory.getDriver(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        testContext.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage (driver);

    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }

    @AfterClass(alwaysRun = true)
    public void finish() {
        this.driver.quit();
    }
}
