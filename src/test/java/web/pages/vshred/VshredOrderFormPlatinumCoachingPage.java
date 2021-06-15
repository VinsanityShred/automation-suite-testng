package web.pages.vshred;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VshredOrderFormPlatinumCoachingPage extends VshredOrderFormPage {
    public static VshredOrderFormPlatinumCoachingPage vsPlatinumCoachingOrderFormPage;

    public VshredOrderFormPlatinumCoachingPage(WebDriver driver) { super(driver); }

    public static void createVSPlatinumCoachingOrderFormPage(WebDriver driver) {
        vsPlatinumCoachingOrderFormPage = new VshredOrderFormPlatinumCoachingPage(driver);
    }

    //// LOCATORS ////
    private By vsTermsConditionsSelector = By.xpath("//*[@id=\"billing-form\"]/div[1]/div[3]/div[3]/div[2]/div[1]/label/span");

    @Step("Click on checkbox to agree to terms and conditions")
    public void clickAgreeToTermsAndConditions() {
        Util.waitMilliseconds(1000); // Wait for element to appear in DOM
        final WebElement termsCheckbox = driver.findElement(vsTermsConditionsSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Payment Next Step Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(termsCheckbox));
        highlightElement(termsCheckbox);
        termsCheckbox.click();
        //waitForVisibilityOfElement(driver.findElement(vsSubmitOrderButton));
    }

    @Step("Click on platinum coaching payment next step button")
    @Override
    protected void clickPaymentNextStep() {
        Util.waitMilliseconds(1000); // Wait for element to appear in DOM
        final WebElement paymentNextStep = driver.findElement(vsPlatinumCoachingPaymentNextStepSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Payment Next Step Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(paymentNextStep));
        highlightElement(paymentNextStep);
        paymentNextStep.click();
        waitForVisibilityOfElement(driver.findElement(vsSubmitOrderButton));
    }

}
