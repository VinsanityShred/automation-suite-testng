package web.pages.vshred;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredOrderFormPage extends BasePage {

    public static final String TEST_NAME = "Kurt Duerksen";
    public static final String TEST_EMAIL = "kduerksen+vshred001@betabreakersbugs.com";
    public static final String TEST_PHONE = "7077890744";

    public static final String TEST_CARD_NUMBER = "5555555555554444";
    public static final String TEST_CARD_EXPDT = "0723";
    public static final String TEST_CARD_CVV = "321";
    public static final String TEST_CARD_ZIP_CODE = "94945";

    public VshredOrderFormPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    // Confirm presence of this element
    By vsProductDetailsSelector = By.cssSelector("#billing-form > div.checkout-product-details > div.product-details-content > div.product-details-text");
    // ** CONTACT INFORMATION **
    By vsNameSelector = By.cssSelector("#name"); // NAME
    By vsEmailSelector = By.cssSelector("#email"); // EMAIL
    By vsPhoneSelector = By.cssSelector("#phone"); // PHONE
    By vsContactNextStepSelector = By.cssSelector("#billing-form > div.checkout-product-details > div:nth-child(3) > div > div.expand-inputs > span"); // CONTACT NEXT STEP BUTTON
    // ** PAYMENT INFORMATION **
    By vsCardSelector = By.xpath("//*[@id=\"credit-card-number\"]"); // CARD NUMBER
    //By vsCardSelector = By.cssSelector("#credit-card-number"); // CARD NUMBER
    By vsExpDtSelector = By.cssSelector("#expiration"); // EXP DATE
    By vsCvvSelector = By.cssSelector("#cvv"); // CVV
    By vsPostalCodeSelector = By.cssSelector("#postal-code"); // POSTAL CODE
    By vsPaymentNextStepSelector = By.cssSelector("#billing-form > div.checkout-product-details > div:nth-child(4) > div.expand-area.expand-area-2 > div.expand-inputs.close-input.close-input > span"); // PAYMENT_NEXT_STEP
    // TODO: Find and interact with this??
    //  WT_LOSS_GUARANTEE_CHECKBOX: #billing-form > div.checkout-product-details > div:nth-child(4) > div.expand-area.expand-area-3 > div.expand-inputs.close-input > div.checkbox-area > label
    // Confirm presence of this element before submit
    By vsOrderSummary = By.cssSelector("#order-summary"); // ORDER_SUMMARY_BOX
    By vsSubmitOrderButton = By.cssSelector("#submit-order"); // SUBMIT_ORDER

    //// Methods ////
    @Step("Click on contact next step button")
    public void clickContactNextStep() {
        final WebElement contactNextStep = driver.findElement(vsContactNextStepSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Contact Next Step Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(contactNextStep));
        scrollToTop(contactNextStep);
        highlightElement(contactNextStep);
        contactNextStep.click();
        //waitForInvisibilityOfElement(contactNextStep);
        //waitForVisibilityOfElement(driver.findElement(vsCardSelector));
    }

    @Step("Click on payment next step button")
    public void clickPaymentNextStep() throws InterruptedException {
        final WebElement paymentNextStep = driver.findElement(vsPaymentNextStepSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Payment Next Step Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(paymentNextStep));
        scrollToTop(paymentNextStep);
        highlightElement(paymentNextStep);
        paymentNextStep.click();
        //waitForInvisibilityOfElement(paymentNextStep);
        waitForVisibilityOfElement(driver.findElement(vsSubmitOrderButton));
    }

    @Step("Click on submit order button")
    public void clickSubmitOrder() {
        final WebElement submitOrder = driver.findElement(vsSubmitOrderButton);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Submit Order Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(submitOrder));
        scrollToMiddle(submitOrder);
        highlightElement(submitOrder);
        submitOrder.click();
        waitForInvisibilityOfElement(submitOrder);
    }

    //// Setters ////
    @Step("Set Contact Defaults")
    public void setContactDefaults() {
        //setContactName(TEST_NAME);
        //setContactEmail(TEST_EMAIL);
        //setContactPhone(TEST_PHONE);
    }

    @Step("Set Payment Defaults")
    public void setPaymentDefaults() throws InterruptedException {
        Thread.sleep(5000); // Give time for fields to appear in DOM
        //setCardNumber(TEST_CARD_NUMBER);
        setCardExpDt(TEST_CARD_EXPDT);
        setCardCvv(TEST_CARD_CVV);
        setCardPostalCode(TEST_CARD_ZIP_CODE);
    }

    @Step("Set Contact Name")
    public void setContactName(String strName) {
        final WebElement contactName = driver.findElement(vsNameSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Name Field").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(contactName));
        highlightElement(contactName);
        contactName.sendKeys(strName);
    }

    @Step("Set Contact Email")
    public void setContactEmail(String strEmail) {
        final WebElement contactEmail = driver.findElement(vsEmailSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Email Field").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(contactEmail));
        highlightElement(contactEmail);
        contactEmail.sendKeys(strEmail);
    }

    @Step("Set Contact Email")
    public void setContactPhone(String strPhone) {
        final WebElement contactPhone = driver.findElement(vsPhoneSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Phone Field").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(contactPhone));
        highlightElement(contactPhone);
        contactPhone.sendKeys(strPhone);
    }

    @Step("Set Card Number")
    public void setCardNumber(String strCardNum) {
        final WebElement cardNumber = driver.findElement(vsCardSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Card Number Field").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(cardNumber));
        highlightElement(cardNumber);
        cardNumber.sendKeys(strCardNum);
    }

    @Step("Set Card Expire Date")
    public void setCardExpDt(String strCardExpDt) {
        final WebElement cardExpDt = driver.findElement(vsExpDtSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Card Expire Date Field").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(cardExpDt));
        highlightElement(cardExpDt);
        cardExpDt.sendKeys(strCardExpDt);
    }

    @Step("Set Card CVV")
    public void setCardCvv(String strCardCvv) {
        final WebElement cardCvv = driver.findElement(vsCvvSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Card CVV Field").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(cardCvv));
        highlightElement(cardCvv);
        cardCvv.sendKeys(strCardCvv);
    }

    @Step("Set Card Postal Code")
    public void setCardPostalCode(String strCardPostalCode) {
        final WebElement cardPostalCode = driver.findElement(vsPostalCodeSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Card Postal Code Field").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(cardPostalCode));
        highlightElement(cardPostalCode);
        cardPostalCode.sendKeys(strCardPostalCode);
    }

    //// Getters ////
    @Step("Get the product details box")
    private boolean getProductDetails(){
        final WebElement productDetailsBox = driver.findElement(vsProductDetailsSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Product Details Box").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(productDetailsBox));
        highlightElement(productDetailsBox);
        return productDetailsBox.isDisplayed();
    }

    @Step("Get the order summary box")
    private boolean getOrderSummary(){
        final WebElement orderSummaryBox = driver.findElement(vsOrderSummary);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Order Summary Box").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(orderSummaryBox));
        highlightElement(orderSummaryBox);
        return orderSummaryBox.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify Product Details Is Displayed")
    public void verifyProductDetailsIsDisplayed() throws InterruptedException {
        if (!getProductDetails()) {
            throw new InterruptedException("Product Details Box NOT Displayed");
        } else {
            System.out.println("Product Details Box Is Displayed");
        }
    }

    @Step("Check: Verify Order Summary Is Displayed")
    public void verifyOrderSummaryIsDisplayed() throws InterruptedException {
        if (!getOrderSummary()) {
            throw new InterruptedException("Order Summary NOT Displayed");
        } else {
            System.out.println("Order Summary Is Displayed");
        }
    }
}
