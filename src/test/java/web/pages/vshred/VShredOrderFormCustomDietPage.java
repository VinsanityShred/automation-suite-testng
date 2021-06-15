package web.pages.vshred;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VShredOrderFormCustomDietPage extends VshredOrderFormPage {
    public VShredOrderFormCustomDietPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on payment next step button")
    @Override
    protected void clickPaymentNextStep() {
        final WebElement paymentNextStep = driver.findElement(vsCustomDietPaymentNextStepSelector);
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
