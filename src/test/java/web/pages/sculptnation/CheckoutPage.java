package web.pages.sculptnation;

import com.github.javafaker.Faker;
import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import java.util.Random;

public class CheckoutPage extends BasePage {

    //// Constructor ////
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //// Variables ////
    Faker faker = new Faker();
    int randomSeven = new Random().nextInt(9999999);
    int randomThree = new Random().nextInt(999);
    String emailAddress = "automation-testing"+randomSeven+"@test.com";
    String FirstName = faker.name().firstName();
    String LastName = faker.name().lastName();
    String StreetAddress = faker.address().streetAddress();
    String City = faker.address().city();
    String State = faker.address().stateAbbr();
    String Zip = faker.address().zipCodeByState(State);
    String PhoneNumber = faker.phoneNumber().cellPhone();
    String Password = faker.animal().name();
    String CardNumber = "4111 1111 1111 1111";
    String ExpirationMonth = "12";
    String ExpirationYear = "2023";
    String CvvCode = String.valueOf(randomThree);

    //// Locators ////
    private By chckPgEmailAddressFieldLocator = By.id("email");
    private By chckPgFirstNameFieldLocator = By.id("first-name");
    private By chckPgLastNameFieldLocator = By.id("last-name");
    private By chckPgAddressFieldLocator = By.id("address-1");
    private By chckPgCityFieldLocator = By.id("city");
    private By chckPgStateFieldLocator = By.id("state");
    private By chckPgZipCodeFieldLocator = By.id("zip-code");
    private By chckPgPhoneNumberFieldLocator = By.id("phone-number-64_phone_number");
    private By chckPgPasswordFieldLocator = By.id("password");
    private By chckPgIframeCardNumberLocator = By.xpath("//iframe[@name='braintree-hosted-field-number']");
    private By chckPgCardNumberFieldLocator = By.id("credit-card-number");
    private By chckPgExpirationMonthFieldLocator = By.xpath("//*[@name='braintree-hosted-field-expirationMonth']");
    private By chckPgExpirationYearFieldLocator = By.xpath("//*[@name='braintree-hosted-field-expirationYear']");
    private By chckPgCVVFieldLocator = By.xpath("//*[@name='braintree-hosted-field-cvv']");
    private By chckPgPlaceOrderButtonLocator = By.xpath("//*[text()='PLACE ORDER']");

    //// Methods ////
    @Step("Set Billing Details and Payment Information")
    public void setCheckoutField() {
        setEmailAddress(emailAddress);
        setFirstName(FirstName);
        setLastName(LastName);
        setStreetAddress(StreetAddress);
        setCity(City);
        setState(State);
        setZipCode(Zip);
        setPhoneNumber(PhoneNumber);
        setPassword(Password);
        scrollToBottomOfPageByKeys();
        Util.waitMilliseconds(3000);
        setCardNumber();
    }

    @Step("Click Place Oder Button")
    public void clickPlaceOrderButton() {
        WebElement placeOrderButton = driver.findElement(chckPgPlaceOrderButtonLocator);
        highlightElement(placeOrderButton);
        placeOrderButton.click();
        wait.until(ExpectedConditions.invisibilityOf(placeOrderButton));
    }

    //// Getters ////

    //// Setters ////
    @Step("Set CVV")
    public void setCVV(String strCVV) {
        WebElement cVV = driver.findElement(chckPgCVVFieldLocator);
        highlightElement(cVV);
        cVV.sendKeys(strCVV);
    }

    @Step("Set Expiration Year")
    public void setExpirationYear(String strExpYear) {
        WebElement expirationYear = driver.findElement(chckPgExpirationYearFieldLocator);
        highlightElement(expirationYear);
        expirationYear.sendKeys(strExpYear);
    }

    @Step("Set Expiration Month")
    public void setExpirationMonth(String strExpMonth) {
        WebElement expirationMonth = driver.findElement(chckPgExpirationMonthFieldLocator);
        highlightElement(expirationMonth);
        expirationMonth.sendKeys(strExpMonth);
    }

    @Step("Set Card Number")
    public void setCardNumber() {
        WebElement cardNumber = driver.findElement(chckPgIframeCardNumberLocator);
        highlightElement(cardNumber);
        cardNumber.click();
    }

    @Step("Set Password")
    public void setPassword(String strPassword) {
        WebElement password = driver.findElement(chckPgPasswordFieldLocator);
        highlightElement(password);
        password.sendKeys(strPassword);
    }

    @Step("Set Phone Number")
    public void setPhoneNumber(String strPhoneNumber) {
        WebElement phoneNumber = driver.findElement(chckPgPhoneNumberFieldLocator);
        highlightElement(phoneNumber);
        phoneNumber.sendKeys(strPhoneNumber);
    }

    @Step("Set Zip Code")
    public void setZipCode(String strZipCode) {
        WebElement zipCode = driver.findElement(chckPgZipCodeFieldLocator);
        highlightElement(zipCode);
        zipCode.sendKeys(strZipCode);
    }

    @Step("Set State")
    public void setState(String strState) {
        WebElement state = driver.findElement(chckPgStateFieldLocator);
        highlightElement(state);
        state.sendKeys(strState);
    }

    @Step("Set City")
    public void setCity(String strCity) {
        WebElement city = driver.findElement(chckPgCityFieldLocator);
        highlightElement(city);
        city.sendKeys(strCity);
    }

    @Step("Set Street Address")
    public void setStreetAddress(String strStreetAddress) {
        WebElement streetAddress = driver.findElement(chckPgAddressFieldLocator);
        highlightElement(streetAddress);
        streetAddress.sendKeys(strStreetAddress);
    }

    @Step("Set Last Name")
    public void setLastName(String strLastName) {
        WebElement lastName = driver.findElement(chckPgLastNameFieldLocator);
        highlightElement(lastName);
        lastName.sendKeys(strLastName);
    }

    @Step("Set First Name")
    public void setFirstName(String strFirstName) {
        WebElement firstName = driver.findElement(chckPgFirstNameFieldLocator);
        highlightElement(firstName);
        firstName.sendKeys(strFirstName);
    }

    @Step("Set Email Address")
    public void setEmailAddress(String strEmail) {
        WebElement emailAddress = driver.findElement(chckPgEmailAddressFieldLocator);
        highlightElement(emailAddress);
        emailAddress.sendKeys(strEmail);
    }

    //// Verifiers ////
}
