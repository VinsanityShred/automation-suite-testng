package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CouponTestBoost219Page extends BasePage {

    //// Constructors ////
    public CouponTestBoost219Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By couponTestBoostPgCouponLocator = By.xpath("//*[@class='coupon']");

    //// Methods ////
    @Step("Is Test Boost Coupon Displayed")
    private boolean isTestBoostPgCouponDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponTestBoostPgCouponLocator));
        WebElement greensPgCoupon = driver.findElement(couponTestBoostPgCouponLocator);
        highlightElement(greensPgCoupon);
        return greensPgCoupon.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Test Boost Page Coupon Is Displayed")
    public void verifyTestBoostPgCouponIsDisplayed() {
        assertTrue(isTestBoostPgCouponDisplayed(), "Test Boost Page Coupon NOT Displayed");
    }
}
