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
        //// Verify product options is displayed ////
        vsPostOrderOfferTwo.verifyProductOptIsDisplayed();
    }

    //// Locators ////
    private By vsProductOptSelector = By.xpath("/html/body/div[2]/section/div/div/ul/li[2]/a");
    private By vsNoThanksLinkSelector = By.xpath("/html/body/div[2]/div/section[7]/div/p/a");

    //// Methods ////
    @Step("Click on No Thanks message and link")
    public void clickNoThanks() {
        // Page design requires a long wait for the "no thanks" link to appear
        System.out.println("Waiting 30 sec for offer two 'no thanks' link to appear");
        Util.waitMilliseconds(30000); // Give time for field to appear in DOM
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
    @Step("Get product options")
    private boolean getProductOpt(){
        System.out.println("Looking for product options");
        Util.waitMilliseconds(1500); // Give time for field to appear in DOM
        final WebElement productOpt = driver.findElement(vsProductOptSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Product Options").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(productOpt));
        highlightElement(productOpt);
        return productOpt.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify Product Options Is Displayed")
    public void verifyProductOptIsDisplayed() throws InterruptedException {
        if (!getProductOpt()) {
            throw new InterruptedException("Offer Two product options NOT Displayed");
        } else {
            System.out.println("Offer Two product options Is Displayed");
        }
    }
}
