package web.pages.vshred;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredPostOrderOffer_2 extends BasePage {
    public static VshredPostOrderOffer_2 vsPostOrderOfferTwo;

    public VshredPostOrderOffer_2(WebDriver driver) {
        super(driver);
    }

    public static void createVSPostOrderOfferTwo(WebDriver driver) {
        vsPostOrderOfferTwo = new VshredPostOrderOffer_2(driver);
    }

    public static void verifyVSPostOrderOfferTwoPage() throws Exception {
        //// Verify name entry field ////
        vsPostOrderOfferTwo.verifyCouponOfferIsDisplayed();
    }

    //// Locators ////
    private By vsCouponOfferSelector = By.xpath("/html/body/main/div/div/div/section[1]/div/div/div");
    private By vsNoThanksLinkSelector = By.xpath("//*[@id=\"option-area\"]/div[2]/div/a");

    //// Methods ////
    @Step("Click on No Thanks message and link")
    public void clickNoThanks() {
        // Page design requires a long wait for the "no thanks" link to appear
        System.out.println("Looking for offer two 'no thanks' link");
        //Util.waitMilliseconds(30000); // Give time for field to appear in DOM
        final WebElement linkNoThanks = driver.findElement(vsNoThanksLinkSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find No Thanks Link").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(linkNoThanks));
        highlightElement(linkNoThanks);
        System.out.println("Clicking offer two 'no thanks' link");
        linkNoThanks.click();
    }

    //// Getters ////
    @Step("Get coupon offer")
    private boolean getWarningMessage(){
        System.out.println("Looking for offer two coupon");
        final WebElement couponOffer = driver.findElement(vsCouponOfferSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Coupon Offer").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(couponOffer));
        highlightElement(couponOffer);
        return couponOffer.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify Coupon Offer Is Displayed")
    public void verifyCouponOfferIsDisplayed() throws InterruptedException {
        if (!getWarningMessage()) {
            throw new InterruptedException("Offer Two Coupon NOT Displayed");
        } else {
            System.out.println("Offer Two Coupon Is Displayed");
        }
    }
}
