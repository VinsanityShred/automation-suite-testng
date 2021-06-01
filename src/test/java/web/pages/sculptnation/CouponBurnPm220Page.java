package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CouponBurnPm220Page extends BasePage {

    //// Constructor ////
    public CouponBurnPm220Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By couponBurnPmPg220ImageLocator = By.xpath("//*[@class='coupon-bottle-img']");

    //// Methods ////
    @Step("Is Burn PM Coupon Page 220 Image Displayed")
    private boolean isBurnPmPg220CouponImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponBurnPmPg220ImageLocator));
        WebElement burnPmPg220CouponImage = driver.findElement(couponBurnPmPg220ImageLocator);
        highlightElement(burnPmPg220CouponImage);
        return burnPmPg220CouponImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn PM Coupon Page 220 Image Is Displayed")
    public void verifyBurnPmCouponPg220ImageIsDisplayed() {
        assertTrue(isBurnPmPg220CouponImageDisplayed(), "Burn PM Coupon Page 220 Image NOT Displayed");
    }
}
