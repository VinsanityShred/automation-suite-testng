package web.pages.sculptnation;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CouponSalesFunnelPage extends BasePage {

    //// Constructor ////
    public CouponSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By couponBurnEvolvedPgCouponLocator = By.xpath("//*[@class='coupon']");
    private By couponPg218NoThanksLinkLocator = By.xpath("//*[text()='No thanks, my metabolism doesn’t need a boost.']");
    private By couponTurmericBlackPgCouponLocator = By.xpath("//*[@class='coupon']");
    private By couponTurmericBlackYesButtonLocator = By.xpath("//button[@class='site-btn scroll']");
    private By couponTestBoostPgCouponLocator = By.xpath("//*[@class='coupon']");
    private By couponGreensV2Pg217ImageLocator = By.xpath("//*[@class='coupon-bottle-img']");
    private By cupnGrnsPgCouponLocator = By.xpath("//*[@class='coupon']");
    private By cupnGrnsPgAddToCartLocator = By.xpath("//a[text()='Add To Cart']");
    private By couponBurnPmPg220ImageLocator = By.xpath("//*[@class='coupon-bottle-img']");
    private By couponBurn218PgImageLocator = By.xpath("//*[@class='coupon-bottle-img']");

    //// Methods ////
    @Step("Is Burn Coupon Page 218 Image Displayed")
    private boolean isBurnCouponImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponBurn218PgImageLocator));
        WebElement burnCouponImage = driver.findElement(couponBurn218PgImageLocator);
        highlightElement(burnCouponImage);
        return burnCouponImage.isDisplayed();
    }

    @Step("Is Burn PM Coupon Page 220 Image Displayed")
    private boolean isBurnPmPg220CouponImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponBurnPmPg220ImageLocator));
        WebElement burnPmPg220CouponImage = driver.findElement(couponBurnPmPg220ImageLocator);
        highlightElement(burnPmPg220CouponImage);
        return burnPmPg220CouponImage.isDisplayed();
    }

    @Step("Click on the Add To Cart link")
    public void clickAddToCartLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement addToCartLink = driver.findElements(cupnGrnsPgAddToCartLocator).get(index);
        highlightElement(addToCartLink);
        scrollToBottom(addToCartLink);
        addToCartLink.click();
        wait.until(ExpectedConditions.invisibilityOf(addToCartLink));
    }

    @Step("Is Greens Coupon Displayed")
    private boolean isGreensPgCouponDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cupnGrnsPgCouponLocator));
        WebElement greensPgCoupon = driver.findElement(cupnGrnsPgCouponLocator);
        highlightElement(greensPgCoupon);
        return greensPgCoupon.isDisplayed();
    }

    @Step("Is Greens V2 Coupon Page 217 Image Displayed")
    private boolean isCouponGreensV2Pg217ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponGreensV2Pg217ImageLocator));
        WebElement couponGreensV2Pg217Image = driver.findElement(couponGreensV2Pg217ImageLocator);
        highlightElement(couponGreensV2Pg217Image);
        return couponGreensV2Pg217Image.isDisplayed();
    }

    @Step("Is Test Boost Coupon Displayed")
    private boolean isTestBoostPgCouponDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponTestBoostPgCouponLocator));
        WebElement greensPgCoupon = driver.findElement(couponTestBoostPgCouponLocator);
        highlightElement(greensPgCoupon);
        return greensPgCoupon.isDisplayed();
    }

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

    @Step("Is Burn Evolved Coupon Displayed")
    private boolean isEvolvedCouponDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(couponBurnEvolvedPgCouponLocator));
        WebElement evolvedCoupon = driver.findElement(couponBurnEvolvedPgCouponLocator);
        highlightElement(evolvedCoupon);
        return evolvedCoupon.isDisplayed();
    }

    @Step("Click on the No Thanks link")
    public void clickNoThanksLink() {
        WebElement noThanksLink = driver.findElement(couponPg218NoThanksLinkLocator);
        wait.until(ExpectedConditions.visibilityOf(noThanksLink));
        highlightElement(noThanksLink);
        noThanksLink.click();
        wait.until(ExpectedConditions.invisibilityOf(noThanksLink));
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn Coupon Page 218 Image Is Displayed")
    public void verifyBurnCouponPg218ImageIsDisplayed() {
        assertTrue(isBurnCouponImageDisplayed(), "Burn Coupon Page 218 Image NOT Displayed");
    }

    @Step("Verify the Burn PM Coupon Page 220 Image Is Displayed")
    public void verifyBurnPmCouponPg220ImageIsDisplayed() {
        assertTrue(isBurnPmPg220CouponImageDisplayed(), "Burn PM Coupon Page 220 Image NOT Displayed");
    }

    @Step("Verify the Greens Page Coupon Is Displayed")
    public void verifyGreensPgCouponIsDisplayed() {
        assertTrue(isGreensPgCouponDisplayed(), "Greens Page Coupon NOT Displayed");
    }

    @Step("Verify the Greens V2 Coupon Page 217 Image Is Displayed")
    public void verifyCouponGreensV2Pg217ImageIsDisplayed() {
        assertTrue(isCouponGreensV2Pg217ImageDisplayed(), "Greens V2 Coupon Page 217 Image NOT Displayed");
    }

    @Step("Verify the Test Boost Page Coupon Is Displayed")
    public void verifyTestBoostPgCouponIsDisplayed() {
        assertTrue(isTestBoostPgCouponDisplayed(), "Test Boost Page Coupon NOT Displayed");
    }

    @Step("Verify the Turmeric Black Page Coupon Is Displayed")
    public void verifyTurmericBlackPgCouponIsDisplayed() {
        assertTrue(isTurmericBlackCouponDisplayed(), "Turmeric Black Page Coupon NOT Displayed");
    }

    @Step("Verify the Evolved Page Coupon Is Displayed")
    public void verifyEvolvedPgCouponIsDisplayed() {
        assertTrue(isEvolvedCouponDisplayed(), "Evolved Page Coupon NOT Displayed");
    }
}
