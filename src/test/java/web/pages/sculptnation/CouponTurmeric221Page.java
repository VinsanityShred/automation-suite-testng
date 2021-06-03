package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CouponTurmeric221Page extends BasePage {

    //// Constructor ////
    public CouponTurmeric221Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By couponTurmericBlackPgCouponLocator = By.xpath("//*[@class='coupon']");
    private By couponTurmericBlackYesButtonLocator = By.xpath("//button[@class='site-btn scroll']");

    //// Methods ////
    @Step("Click the Yes button")
    public void clickTurmericBlackYesButton() {
        WebElement turmericBlackYesButton = driver.findElement(couponTurmericBlackYesButtonLocator);
        highlightElement(turmericBlackYesButton);
        turmericBlackYesButton.click();
        wait.until(ExpectedConditions.invisibilityOf(turmericBlackYesButton));
    }

    @Step("Is Turmeric Black Coupon Displayed")
    private boolean isTurmericBlackCouponDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponTurmericBlackPgCouponLocator));
        WebElement turmericBlackPgCoupon = driver.findElement(couponTurmericBlackPgCouponLocator);
        highlightElement(turmericBlackPgCoupon);
        return turmericBlackPgCoupon.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Turmeric Black Page Coupon Is Displayed")
    public void verifyTurmericBlackPgCouponIsDisplayed() {
        assertTrue(isTurmericBlackCouponDisplayed(), "Turmeric Black Page Coupon NOT Displayed");
    }
}
