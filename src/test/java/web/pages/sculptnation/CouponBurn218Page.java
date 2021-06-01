package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CouponBurn218Page extends BasePage {

    //// Constructor ////
    public CouponBurn218Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By couponBurn218PgImageLocator = By.xpath("//*[@class='coupon-bottle-img']");

    //// Methods ////
    @Step("Is Burn Coupon Page 218 Image Displayed")
    private boolean isBurnCouponImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponBurn218PgImageLocator));
        WebElement burnCouponImage = driver.findElement(couponBurn218PgImageLocator);
        highlightElement(burnCouponImage);
        return burnCouponImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn Coupon Page 218 Image Is Displayed")
    public void verifyBurnCouponPg218ImageIsDisplayed() {
        assertTrue(isBurnCouponImageDisplayed(), "Burn Coupon Page 218 Image NOT Displayed");
    }
}
