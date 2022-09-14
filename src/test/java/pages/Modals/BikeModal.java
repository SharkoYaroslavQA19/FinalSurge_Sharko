package pages.Modals;

import Utils.Screenshots;
import enums.BikeBrand;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class BikeModal extends BaseModal{
    private static final By BIKE_NAME = By.id("ShoeName");
    private static final By BIKE_BRAND = By.xpath("//*[@id='s2id_ShoeBrand']//span");
    private static final By BIKE_MODEL = By.id("ShoeModel");
    private static final By BIKE_COST = By.id("ShoeCost");
    private static final By DATE = By.id("ShoeDate");
    private static final By DISTANCE = By.id("StartDist");



    public BikeModal(WebDriver driver) {
        super(driver);
    }

    @Step("Getting 'Bike' equipment details")
    public Bike getBikeDetails() {
        Bike bike = new Bike();
        bike.setBikeName(getValue(BIKE_NAME));
        bike.setBikeBrand(BikeBrand.fromString(getText(BIKE_BRAND)));
        bike.setModel(getValue(BIKE_MODEL));
        bike.setCost(getValue(BIKE_COST));
        bike.setDate(getValue(DATE));
        bike.setDistance(getValue(DISTANCE));
        Screenshots.attachScreenshot(driver);
        return bike;
    }

    public String getValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }


}