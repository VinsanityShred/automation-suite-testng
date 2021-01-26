package web.pages.sculptnation;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class SNLoginPage extends BasePage {
    //// Constructor ////
    public SNLoginPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By sNLoginPgLogoLocator = By.cssSelector("#app > div > header > nav > div > a > img");
    By sNLoginPgEmailTextFieldLocator = By.id("email");
    By sNLoginPgPasswordTextFieldLocator = By.id("password");
    By sNLoginPgLoginButtonLocator = By.xpath("//*[@dusk='loginButton']");

    //// Methods ////
    @Step("Clicks on the Log in button")
    public void clickLoginButton() {
        final WebElement loginButton = driver.findElement(sNLoginPgLoginButtonLocator);
            highlightElement(loginButton);
            loginButton.click();
        Util.waitMilliseconds(2000);
    }

    //// Setters ////

    @Step("Set the Password")
    public void setPassword(String password){
        final WebElement passwordTextField = driver.findElement(sNLoginPgPasswordTextFieldLocator);
            highlightElement(passwordTextField);
            passwordTextField.sendKeys(password);
    }

    @Step("Set the Email Address")
    public void setEmailAddress(String emailAddress){
        final WebElement emailAddressTextField = driver.findElement(sNLoginPgEmailTextFieldLocator);
            highlightElement(emailAddressTextField);
            emailAddressTextField.sendKeys(emailAddress);

    }

    //// Getters ////
    @Step("Get the login page logo")
    private boolean getLoginLogo(){
        final WebElement loginLogo = driver.findElement(sNLoginPgLogoLocator);
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
}
