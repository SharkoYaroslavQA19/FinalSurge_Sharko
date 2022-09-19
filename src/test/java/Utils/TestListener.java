package Utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        log.debug(String.format("Test %s started", result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        log.debug(String.format("Test %s finished", result.getName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ITestListener.super.onTestFailure(result);
        log.debug(String.format("Test %s failed", result.getName()));
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        Screenshots.attachScreenshot(driver);
    }
}