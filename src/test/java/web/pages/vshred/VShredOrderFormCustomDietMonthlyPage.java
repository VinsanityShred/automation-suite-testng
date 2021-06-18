package web.pages.vshred;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.vshred.VshredOrderFormPage;

import java.time.Duration;

public class VShredOrderFormCustomDietMonthlyPage extends VshredOrderFormPage {
    public VShredOrderFormCustomDietMonthlyPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on contact next step button")
    @Override
    protected void clickContactNextStep() {
        Util.waitMilliseconds(1000);
        final WebElement contactNextStep = driver.findElement(vsCustomDietMonthlyContactNextStepSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Contact Next Step Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(contactNextStep));
        highlightElement(contactNextStep);
        contactNextStep.click();
        waitForVisibilityOfElement(driver.findElement(vsSubmitOrderButton));
    }

    @Step("Click on payment next step button")
    @Override
    protected void clickPaymentNextStep() {
        final WebElement paymentNextStep = driver.findElement(vsCustomDietMonthlyPaymentNextStepSelector);
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

