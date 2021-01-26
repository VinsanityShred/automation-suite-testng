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

public class SNLandingPage extends BasePage {

    //// Constructor ////
    public SNLandingPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By sNLandingPgLogoLocator = By.cssSelector("#app > div > header > nav > div > a > img");
    By SNLadingPgDiscountModalCloseButtonLocator = By.cssSelector("#closeIconContainer");
    By sNLandingPgMyAccountLinkLocator = By.xpath("//*[@href='/my-account']");

    //// Methods ////
    @Step("Click the My Account link")
    public void clickMyAccountLink() {
        final WebElement myAccountLink = driver.findElement(sNLandingPgMyAccountLinkLocator);
        highlightElement(myAccountLink);
        myAccountLink.click();
        Util.waitMilliseconds(2000);
    }

    @Step("Click Modal Close Button")
    public void clickDiscountModalCloseButton() {
        final WebElement discountModalCloseButton = driver.findElement(SNLadingPgDiscountModalCloseButtonLocator);
        highlightElement(discountModalCloseButton);
        discountModalCloseButton.click();
        Util.waitMilliseconds(1000);
    }

    @Step("Is the login page logo")
    private boolean isLandingLogo(){
        final WebElement landingLogo = driver.findElement(sNLandingPgLogoLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logo Image").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(landingLogo));
        highlightElement(landingLogo);
        return landingLogo.isDisplayed();
    }

    @Step("Is Discount modal displayed")
    public void closeDiscountModalDisplayed() throws Exception{
        Util.waitMilliseconds(3000);
        switchToFrame("attentive_creative");
        System.out.println("Discount Modal IS Displayed ");
        clickDiscountModalCloseButton();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Check: Verify Landing Page Logo Is Displayed")
    public void verifyLandingPgLogoIsDisplayed() throws InterruptedException {
        Util.waitMilliseconds(2000);
        if (!isLandingLogo()) {
            throw new InterruptedException("Landing Page Logo NOT Displayed");
        } else {
            System.out.println("Landing Page Logo Displayed");
        }
    }

}
