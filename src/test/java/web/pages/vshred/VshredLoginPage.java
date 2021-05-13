package web.pages.vshred;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredLoginPage extends BasePage {

    public static final String INVALID_EMAIL_PASS_MSG = "Your email and/or password were invalid.";
    //public static final String FORM_ERRORS_MSG = "Please check the form below for errors.";

    public VshredLoginPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////

    By vsEmailAddressFieldLocator = By.id("email");
    By vsPasswordFieldLocator = By.id("password");
    By vsLoginPageLogoLocator = By.cssSelector("#menu1 > div > div > div.col-md-2.col-sm-2.hidden-xs >" +
            " div > a > img.logo.logo-light");
    By vsLoginButtonLocator = By.xpath("//button[text()='Login']");
    //By vsErrMsgLocator = By.cssSelector("#toast-container");
    //By vsErrMsgLocator = By.className("toast-error");
    By vsToastCloseButton = By.cssSelector(".toast-close-button");
    By vsHelpBlockLocator = By.className("help-block");

    //// Methods ////

    @Step("Click on the login button")
    public void clickLoginButton() {
        final WebElement loginButton = driver.findElement(vsLoginButtonLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find A Clickable Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(loginButton));
        scrollToTop(loginButton);
        highlightElement(loginButton);
        loginButton.click();
        waitForInvisibilityOfElement(loginButton);
    }

    //// Setters ////

    @Step("Set Password")
    public void setUserPassword(String strPassword) {
        final WebElement userPassword = driver.findElement(vsPasswordFieldLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Text Field").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOf(userPassword));
        highlightElement(userPassword);
        userPassword.sendKeys(strPassword);
    }

    @Step("Set email address")
    public void setEmailAddress(String strEmailAddress) {
        final WebElement emailAddress = driver.findElement(vsEmailAddressFieldLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Text Field").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(emailAddress));
        scrollToMiddle(emailAddress);
        highlightElement(emailAddress);
        emailAddress.sendKeys(strEmailAddress);
    }

    //// Getters ////

    @Step("Get the login page title")
    private boolean getLoginLogo(){
        final WebElement loginLogo = driver.findElement(vsLoginPageLogoLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logo Image").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(loginLogo));
        highlightElement(loginLogo);
        return loginLogo.isDisplayed();
    }

    //// Verifiers ////

    @Step("Check: Verify Login Page Logo Is Displayed")
    public void verifyLoginLogoIsDisplayed() throws InterruptedException {
        if (!getLoginLogo()) {
            throw new InterruptedException("Login Page Logo NOT Displayed");
        } else {
            System.out.println("Login Page Logo Displayed");
        }
    }

    @Step("Is error message displayed")
    public void verifyErrMsgIsDisplayed() throws InterruptedException {
        Thread.sleep(2500); // Give time for error message box to appear
        final WebElement toastCloseButton = driver.findElement(vsToastCloseButton);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Error Message Box Close Button").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(toastCloseButton));
        highlightElement(toastCloseButton);

        if (!toastCloseButton.isDisplayed()) {
            throw new InterruptedException("Error message box NOT displayed");
        }
    }

    @Step("Is help block message displayed")
    public void verifyHelpBlockText(String aTextMsg) throws InterruptedException {
        final WebElement loginPageHelpBlock = driver.findElement(vsHelpBlockLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Help Block").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(loginPageHelpBlock));
        highlightElement(loginPageHelpBlock);

        // Verify help block text matches given parameter string
        if (!loginPageHelpBlock.getText().equalsIgnoreCase(aTextMsg)) {
            throw new InterruptedException("Login Page Help Block Text NOT expected text");
        } else {
            System.out.println("Login Page Help Block Text Displayed and Matching: " + loginPageHelpBlock.getText());
        }
    }


    public void waitForLoad() {
    }
}
