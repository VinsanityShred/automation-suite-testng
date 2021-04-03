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
import static org.testng.Assert.assertTrue;

public class SNLandingPage extends BasePage {

    //// Constructor ////
    public SNLandingPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By sNLdnPgLogoLocator = By.cssSelector("#app > div > header > nav > div > a > img");
    By sNLdnPgDiscountModalCloseButtonLocator = By.cssSelector("#closeIconContainer");
    By sNLdnPgMyAccountLinkLocator = By.xpath("//*[@href='/my-account']");
    By sNLdnPgFBMediaLinkLocator = By.xpath("//*[@class='fab fa-facebook-f mx-1']");
    By sNLdnPgInstagramMediaLinkLocator = By.xpath("//*[@class='fab fa-instagram mx-1']");
    By FBPgLogoLocator = By.xpath("//*[@alt='Facebook']");
    By FBPgLogoLocator2 = By.xpath("//*[@title='Go to Facebook Home']");
    By InstgrmPgLogoLocator = By.xpath("//h1[text()='Instagram']");
    By sNLdnPgContactUsLocator = By.xpath("//*[@class='fas fa-envelope']");
    By sNLdnPgPhoneIconLocator = By.xpath("//*[@class='fas fa-phone']");
    By sNLandPgCartIconLocator = By.xpath("//*[@class='fas fa-shopping-cart']");

    //// Methods ////
    @Step("Click on Cart icon")
    public void clickCartIcon() {
        final WebElement cartIcon = driver.findElement(sNLandPgCartIconLocator);
        highlightElement(cartIcon);
        cartIcon.isEnabled();
        cartIcon.click();
    }

    @Step("Click on Phone icon")
    public void clickPhoneIcon() {
        final WebElement phoneIcon = driver.findElement(sNLdnPgPhoneIconLocator);
        highlightElement(phoneIcon);
        phoneIcon.isEnabled();
        phoneIcon.click();
    }

    @Step("Click on Contact Us envelop icon")
    public void clickEnvelopIcon() {
        final WebElement envelopIcon = driver.findElement(sNLdnPgContactUsLocator);
        highlightElement(envelopIcon);
        envelopIcon.click();
    }

    @Step("Click on Instagram social media link")
    public void clickInstagramMediaLink() {
        final WebElement InstagramMediaLink = driver.findElement(sNLdnPgInstagramMediaLinkLocator);
        highlightElement(InstagramMediaLink);
        InstagramMediaLink.click();
    }

    @Step("Click on Facebook social media link")
    public void clickFBMediaLink() {
        final WebElement fbMediaLink = driver.findElement(sNLdnPgFBMediaLinkLocator);
        highlightElement(fbMediaLink);
        fbMediaLink.click();
    }

    @Step("Click the My Account link")
    public void clickMyAccountLink() {
        final WebElement myAccountLink = driver.findElement(sNLdnPgMyAccountLinkLocator);
        highlightElement(myAccountLink);
        myAccountLink.click();
        Util.waitMilliseconds(2000);
    }

    @Step("Click Modal Close Button")
    public void clickDiscountModalCloseButton() {
        final WebElement discountModalCloseButton = driver.findElement(sNLdnPgDiscountModalCloseButtonLocator);
        highlightElement(discountModalCloseButton);
        discountModalCloseButton.click();
        Util.waitMilliseconds(1000);
    }

    @Step("Is the login page logo")
    private boolean isLandingLogo(){
        final WebElement landingLogo = driver.findElement(sNLdnPgLogoLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logo Image").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(landingLogo));
        highlightElement(landingLogo);
        return landingLogo.isDisplayed();
    }

    @Step("Is Discount modal displayed")
    public void closeDiscountModalDisplayed() {
        Util.waitMilliseconds(3000);
        switchToFrame("attentive_creative");
        System.out.println("Discount Modal IS Displayed ");
        clickDiscountModalCloseButton();
    }

    //// Setters ////

    //// Getters ////
    @Step("Get the Instagram page logo")
    public boolean getInstagramLogoImage() {
        final WebElement instagramLogo = driver.findElement(InstgrmPgLogoLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logo Image").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(instagramLogo));
        highlightElement(instagramLogo);
        return instagramLogo.isDisplayed();
    }

    @Step("Get the Facebook page logo 2")
    public boolean getFBLogoImage2() {
        final WebElement fbLogo2 = driver.findElement(FBPgLogoLocator2);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logo Image").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(fbLogo2));
        highlightElement(fbLogo2);
        return fbLogo2.isDisplayed();
    }

    @Step("Get the Facebook page logo")
    public boolean getFBLogoImage() {
        final WebElement fbLogo = driver.findElement(FBPgLogoLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logo Image").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(fbLogo));
        highlightElement(fbLogo);
        return fbLogo.isDisplayed();
    }

    @Step("Check: Verify Facebook Page Logo Is Displayed")
    public void verifyFBLogoIsDisplayed() throws InterruptedException {
        if (getFBLogoImage2()) {
            System.out.println("Facebook Page Logo Displayed");
        } else if (getFBLogoImage()) {
            System.out.println("Facebook Page Logo Displayed");
        } else {
            throw new InterruptedException("Facebook Page Logo NOT Displayed");
        }
    }

    //// Verifiers ////
    @Step("Check: Verify current Page URL")
    public void verifyCartPageURL() {
        assertTrue(getPageUrl().endsWith("/cart"));
    }

    @Step("Check: Verify Instagram Page Logo Is Displayed")
    public void verifyInstagramLogoIsDisplayed() throws InterruptedException {
        if (getInstagramLogoImage()) {
            System.out.println("Instagram Page Logo IS Displayed");
        } else {
            throw new InterruptedException("Instagram Page Logo NOT Displayed");
        }
    }

    @Step("Check: Verify Landing Page Logo Is Displayed")
    public void verifyLandingPgLogoIsDisplayed() throws InterruptedException {
        Util.waitMilliseconds(2000);
        if (isLandingLogo()) {
            System.out.println("Landing Page Logo IS Displayed");
        } else {
            throw new InterruptedException("Landing Page Logo NOT Displayed");
        }
    }

}
