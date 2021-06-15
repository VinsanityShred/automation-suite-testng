package web.pages.vshred;

import framework.Auth;
import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredOrderFormPage extends BasePage {

    private static final String TEST_PHONE = "7077890744";

    private static final String TEST_CARD_NUMBER = "5555555555554444";
    private static final String TEST_CARD_EXPDT = "0723";
    private static final String TEST_CARD_CVV = "321";
    private static final String TEST_CARD_ZIP_CODE = "94945";

    public static VshredOrderFormPage vsOrderFormPage;

    public VshredOrderFormPage(WebDriver driver) {
        super(driver);
    }

    public static void createVSOrderFormPage(WebDriver driver) {
        vsOrderFormPage = new VshredOrderFormPage(driver);
    }

    public static void verifyVSOrderFormPage() throws Exception {
        //// Verify name entry field ////
        vsOrderFormPage.verifyNameFieldIsDisplayed();
    }

    //// Locators ////
    // ** CONTACT INFORMATION **
    private By vsNameSelector = By.xpath("//*[@id=\"name\"]"); // NAME
    private By vsEmailSelector = By.cssSelector("#email"); // EMAIL
    private By vsPhoneSelector = By.cssSelector("#phone"); // PHONE
    private By vsContactNextStepSelector = By.cssSelector("#billing-form > div.checkout-product-details > div:nth-child(3) > div > div.expand-inputs > span"); // CONTACT NEXT STEP BUTTON
    protected By vsCustomDietMonthlyContactNextStepSelector = By.cssSelector("#billing-form > div.expand-area.expand-area-1 > div.expand-inputs > span"); // CONTACT NEXT STEP BUTTON
    //protected By vsCustomDietMonthlyContactNextStepSelector = By.xpath("//*[@id=\"billing-form\"]/div[1]/div[2]/span"); // CONTACT NEXT STEP BUTTON
    
    // ** PAYMENT INFORMATION **
    private By vsCardSelector = By.xpath("//*[@name='braintree-hosted-field-number']");
    private By vsExpDtSelector = By.xpath("//*[@name='braintree-hosted-field-expirationDate']"); // EXP DATE
    private By vsCvvSelector = By.xpath("//*[@name='braintree-hosted-field-cvv']");
    private By vsPostalCodeSelector = By.xpath("//*[@name='braintree-hosted-field-postalCode']");
    protected By vsCustomDietPaymentNextStepSelector =        By.xpath("//*[@id=\"billing-form\"]/div[1]/div[3]/div[2]/div[2]/span");
    protected By vsCustomDietMonthlyPaymentNextStepSelector = By.xpath("//*[@id=\"billing-form\"]/div[2]/div[2]/span");
    protected By vsPlatinumCoachingPaymentNextStepSelector =  By.xpath("//*[@id=\"billing-form\"]/div[1]/div[3]/div[2]/div[2]/span");
    private By vsPaymentNextStepSelector =                    By.xpath("//*[@id=\"billing-form\"]/div[1]/div[4]/div[1]/div[2]/span");
    private By vsOrderSummary = By.cssSelector("#order-summary"); // ORDER_SUMMARY_BOX
    //protected By vsSubmitOrderButton = By.cssSelector("#submit-order"); // SUBMIT_ORDER
    protected By vsSubmitOrderButton = By.xpath("//*[@id=\"submit-order\"]");
    private By vsErrorSubscribingMsgSelector = By.xpath("//*[@id=\"billing-form\"]/div[3]/div[2]/div[2]/div/span");

    //// Methods ////
    @Step("Fill in contact details and click next step")
    public void completeContactInfoAndNext() {
        vsOrderFormPage.setContactDefaults();
        vsOrderFormPage.clickContactNextStep();
    }

    @Step("Fill in custom diet monthly contact details and click next step")
    public void completeCustomDietMonthlyContactInfoAndNext() {
        vsOrderFormPage.setContactDefaults();
        vsOrderFormPage.clickCustomDietMonthlyContactNextStep();
    }

    @Step("Fill in payment details and click next step")
    public void completePaymentDetailsAndNext() {
        vsOrderFormPage.setPaymentDefaults();
        vsOrderFormPage.clickPaymentNextStep();
    }

    @Step("Fill in custom diet payment details and click next step")
    public void completeCustomDietPaymentDetailsAndNext() {
        vsOrderFormPage.setPaymentDefaults();
        vsOrderFormPage.clickCustomDietPaymentNextStep();
    }

    @Step("Fill in custom diet monthly payment details and click next step")
    public void completeCustomDietMonthlyPaymentDetailsAndNext() {
        vsOrderFormPage.setPaymentDefaults();
        vsOrderFormPage.clickCustomDietMonthlyPaymentNextStep();
    }

    @Step("Fill in custom diet monthly payment details and click next step")
    public void completePlatinumCoachingPaymentDetailsAndNext() {
        vsOrderFormPage.setPaymentDefaults();
        vsOrderFormPage.clickPlatinumCoachingPaymentNextStep();
    }

    public void submitOrder() throws Exception {
        //vsOrderFormPage.verifyOrderSummaryIsDisplayed(); **NOTE** Not all cases have this displayed
        vsOrderFormPage.clickSubmitOrder();
    }

    @Step("Click on contact next step button")
    protected void clickContactNextStep() {
        final WebElement contactNextStep = driver.findElement(vsContactNextStepSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Contact Next Step Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(contactNextStep));
        highlightElement(contactNextStep);
        contactNextStep.click();
    }

    @Step("Click on contact next step button")
    protected void clickCustomDietMonthlyContactNextStep() {
        final WebElement contactNextStep = driver.findElement(vsCustomDietMonthlyContactNextStepSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Monthly Diet Plan Contact Next Step Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(contactNextStep));
        highlightElement(contactNextStep);
        contactNextStep.click();
    }

    @Step("Click on payment next step button")
    protected void clickPaymentNextStep() {
        Util.waitMilliseconds(2000); // Give time for field to appear in DOM
        final WebElement paymentNextStep = driver.findElement(vsPaymentNextStepSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Payment Next Step Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(paymentNextStep));
        highlightElement(paymentNextStep);
        paymentNextStep.click();
        waitForVisibilityOfElement(driver.findElement(vsSubmitOrderButton));
    }

    @Step("Click on payment next step button")
    protected void clickCustomDietPaymentNextStep() {
        Util.waitMilliseconds(1500); // Give time for field to appear in DOM
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

    @Step("Click on payment next step button")
    protected void clickCustomDietMonthlyPaymentNextStep() {
        Util.waitMilliseconds(2000); // Give time for field to appear in DOM
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

    @Step("Click on payment next step button")
    protected void clickPlatinumCoachingPaymentNextStep() {
        Util.waitMilliseconds(2000); // Give time for field to appear in DOM
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

    @Step("Click on submit order button")
    public void clickSubmitOrder() throws Exception {
        Util.waitMilliseconds(1500); // Give time for field to appear in DOM
        final WebElement submitOrder = driver.findElement(vsSubmitOrderButton);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Submit Order Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(submitOrder));
        highlightElement(submitOrder);
        try {
            System.out.println("CLICKING SUBMIT ORDER");
            submitOrder.click();
            System.out.println("**DONE** CLICKING SUBMIT ORDER");
            System.out.println("WAITING FOR SUBMIT INVISIBILITY...");
            waitForInvisibilityOfElement(submitOrder);
            System.out.println("**DONE** WAITING FOR INVISIBILITY");
        } catch (Exception e) {
            // Handle "error subscribing" by clicking submit again
            System.out.println("RE-CLICKING SUBMIT ORDER");
            submitOrder.click();
            System.out.println("**DONE** RE-CLICKING SUBMIT ORDER");
            System.out.println("WAITING AGAIN FOR SUBMIT INVISIBILITY...");
            waitForInvisibilityOfElement(submitOrder);
            System.out.println("**DONE** WAITING FOR INVISIBILITY");
        }
    }

    //// Setters ////
    @Step("Set Contact Defaults")
    public void setContactDefaults() {
        setContactName(Auth.validMemberUserName());
        setContactEmail(Auth.validMemberUserEmail());
        setContactPhone(TEST_PHONE);
    }

    @Step("Set Payment Defaults")
    public void setPaymentDefaults() {
        setCardNumber(TEST_CARD_NUMBER);
        setCardExpDt(TEST_CARD_EXPDT);
        setCardCvv(TEST_CARD_CVV);
        setCardPostalCode(TEST_CARD_ZIP_CODE);
    }

    @Step("Set Contact Name")
    public void setContactName(String strName) {
        System.out.println("Setting contact name");
        Util.waitMilliseconds(1000); // Give time for field to appear in DOM
        WebElement contactName = driver.findElement(vsNameSelector);
        Actions action = new Actions(driver);
        action.moveToElement(contactName).perform();
        contactName.clear();
        contactName.click();
        setTextBySendKeys(strName);
        System.out.println("Contact name IS set");
    }

    @Step("Set Contact Email")
    public void setContactEmail(String strEmail) {
        WebElement contactEmail = driver.findElement(vsEmailSelector);
        Actions action = new Actions(driver);
        action.moveToElement(contactEmail).perform();
        contactEmail.clear();
        contactEmail.click();
        setTextBySendKeys(strEmail);
    }

    @Step("Set Contact Phone")
    public void setContactPhone(String strPhone) {
        WebElement contactPhone = driver.findElement(vsPhoneSelector);
        Actions action = new Actions(driver);
        action.moveToElement(contactPhone).perform();
        contactPhone.clear();
        contactPhone.click();
        setTextBySendKeys(strPhone);
    }

    @Step("Set Card Number")
    public void setCardNumber(String strCardNum) {
        WebElement cardNumber = driver.findElement(vsCardSelector);
        Actions action = new Actions(driver);
        action.moveToElement(cardNumber).perform();
        cardNumber.click();
        setTextBySendKeys(strCardNum);
    }

    @Step("Set Card Expire Date")
    public void setCardExpDt(String strCardExpDt) {
        WebElement cardExpDt = driver.findElement(vsExpDtSelector);
        Actions action = new Actions(driver);
        action.moveToElement(cardExpDt).perform();
        cardExpDt.click();
        setTextBySendKeys(strCardExpDt);
    }

    @Step("Set Card CVV")
    public void setCardCvv(String strCardCvv) {
        WebElement cardCvv = driver.findElement(vsCvvSelector);
        Actions action = new Actions(driver);
        action.moveToElement(cardCvv).perform();
        cardCvv.click();
        setTextBySendKeys(strCardCvv);
    }

    @Step("Set Card Postal Code")
    public void setCardPostalCode(String strCardPostalCode) {
        WebElement cardPostalCode = driver.findElement(vsPostalCodeSelector);
        Actions action = new Actions(driver);
        action.moveToElement(cardPostalCode).perform();
        cardPostalCode.click();
        setTextBySendKeys(strCardPostalCode);
    }

    //// Getters ////
    @Step("Get name edit field")
    private boolean getNameField(){
        System.out.println("Looking for name field");
        Util.waitMilliseconds(1000); // Give time for field to appear in DOM
        final WebElement nameEditField = driver.findElement(vsNameSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Name Field").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(nameEditField));
        highlightElement(nameEditField);
        return nameEditField.isDisplayed();
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
    @Step("Check: Verify Order Summary Is Displayed")
    public void verifyOrderSummaryIsDisplayed() throws InterruptedException {
        if (!getOrderSummary()) {
            throw new InterruptedException("Order Summary NOT Displayed");
        } else {
            System.out.println("Order Summary Is Displayed");
        }
    }

    @Step("Check: Verify Name Edit Field Is Displayed")
    public void verifyNameFieldIsDisplayed() throws InterruptedException {
        if (!getNameField()) {
            throw new InterruptedException("Name Field NOT Displayed");
        } else {
            System.out.println("Name Field Is Displayed");
        }
    }
}
