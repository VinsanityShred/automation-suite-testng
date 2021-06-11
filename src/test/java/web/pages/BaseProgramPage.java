package web.pages;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseProgramPage extends BasePage {
    public BaseProgramPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    protected By vsClickToPurchaseLocator;

    //// Methods ////
    @Step("Click on program purchase button")
    public void clickPurchaseButton() {
        System.out.println("Going to click program purchase button");
        Util.waitMilliseconds(1000); // Give time for element to appear in DOM
        final WebElement clickToPurchase = driver.findElement(vsClickToPurchaseLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Purchase Program").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(clickToPurchase));
        scrollToMiddle(clickToPurchase);
        highlightElement(clickToPurchase);
        clickToPurchase.click();
        waitForInvisibilityOfElement(clickToPurchase);
    }

    //// Setters ////

    //// Getters ////
    @Step("Get click to purchase button")
    private boolean getClickToPurchase(){
        System.out.println("Looking for program purchase button");
        Util.waitMilliseconds(1000); // Give time for element to appear in DOM
        final WebElement clickToPurchase = driver.findElement(vsClickToPurchaseLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Click To Purchase Button").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(clickToPurchase));
        highlightElement(clickToPurchase);
        return clickToPurchase.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify Purchase Button Is Displayed")
    public void verifyPurchaseButtonIsDisplayed() throws InterruptedException {
        if (!getClickToPurchase()) {
            throw new InterruptedException("Purchase Button NOT Displayed");
        } else {
            System.out.println("Purchase Button Is Displayed");
        }
    }

}
