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

public class VshredPostOrderOffer_1 extends BasePage {
    public static VshredPostOrderOffer_1 vsPostOrderOfferOne;

    public VshredPostOrderOffer_1(WebDriver driver) {
        super(driver);
    }

    public static void createVSPostOrderOfferOne(WebDriver driver) {
        vsPostOrderOfferOne = new VshredPostOrderOffer_1(driver);
    }

    //// Locators ////
    private By vsWarnMsgSelector = By.xpath("/html/body/header/div/div/h1");
    private By vsNoThanksLinkSelector = By.xpath("/html/body/div[2]/section[3]/div[2]/div/div[2]/div[2]/p[6]/a");

    //// Methods ////
    @Step("Click on No Thanks message and link")
    public void clickNoThanks() {
        // Page design requires a long wait for the "no thanks" link to appear
        System.out.println("Waiting 30 sec for offer one 'no thanks' link to appear");
        Util.waitMilliseconds(30000); // Give time for field to appear in DOM
        final WebElement linkNoThanks = driver.findElement(vsNoThanksLinkSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find No Thanks Link").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(linkNoThanks));
        highlightElement(linkNoThanks);
        System.out.println("Clicking offer one 'no thanks' link");
        linkNoThanks.click();
    }

    //// Getters ////
    @Step("Get warning message")
    private boolean getWarningMessage(){
        System.out.println("Looking for warning message");
        Util.waitMilliseconds(1000); // Give time for field to appear in DOM
        final WebElement warningMsg = driver.findElement(vsWarnMsgSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Warning Message").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(warningMsg));
        highlightElement(warningMsg);
        return warningMsg.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify Warning Message Is Displayed")
    public void verifyWarnMsgIsDisplayed() throws InterruptedException {
        if (!getWarningMessage()) {
            throw new InterruptedException("Offer One Warning message NOT Displayed");
        } else {
            System.out.println("Offer One Warning message Is Displayed");
        }
    }

    public static void verifyVSPostOrderOfferOnePage() throws Exception {
        //// Verify warning message is displayed ////
        vsPostOrderOfferOne.verifyWarnMsgIsDisplayed();
    }
}
