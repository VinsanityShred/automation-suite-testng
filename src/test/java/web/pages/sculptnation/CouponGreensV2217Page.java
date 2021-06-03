package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CouponGreensV2217Page extends BasePage {

    //// Constructor ////
    public CouponGreensV2217Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By couponGreensV2Pg217ImageLocator = By.xpath("//*[@class='coupon-bottle-img']");

    //// Methods ////
    @Step("Is Greens V2 Coupon Page 217 Image Displayed")
    private boolean isCouponGreensV2Pg217ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponGreensV2Pg217ImageLocator));
        WebElement couponGreensV2Pg217Image = driver.findElement(couponGreensV2Pg217ImageLocator);
        highlightElement(couponGreensV2Pg217Image);
        return couponGreensV2Pg217Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Greens V2 Coupon Page 217 Image Is Displayed")
    public void verifyCouponGreensV2Pg217ImageIsDisplayed() {
        assertTrue(isCouponGreensV2Pg217ImageDisplayed(), "Greens V2 Coupon Page 217 Image NOT Displayed");
    }
}
