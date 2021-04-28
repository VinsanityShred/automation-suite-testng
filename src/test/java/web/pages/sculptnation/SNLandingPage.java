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
    By sNLandPgAboutUsLinkLocator = By.xpath("//*[@href='/about-us']");
    By sNLandPgClothingLinkLocator = By.xpath("//*[@href='https://clothing.vshred.com']");
    By sNLandPgSupplementGuideLinkLocator = By.id("__BVID__12__BV_toggle_");
    By sNLandPgFemaleGuideLinkLocator = By.xpath("//*[@href='/supplement-guide-for-women']");
    By sNLandPgMaleGuideLinkLocator = By.xpath("//*[@href='/supplement-guide-for-men']");
    By sNLandPgSupplementsLinkLocator = By.xpath("//*[@href='/products']");
    By sNLandPgHomeLinkLocator = By.xpath("//a[contains(text(),'Home') and contains(@class,'nav-link')]");
    By sNLandPgWatchNowLinkLocator = By.className("burn-vsl-banner__cta");

    //// Methods ////
    @Step("Click on the Watch Now link")
    public void clickWatchVideoLink() {
        WebElement watchVideoLink = driver.findElement(sNLandPgWatchNowLinkLocator);
        highlightElement(watchVideoLink);
        watchVideoLink.click();
    }

    @Step("Is the Watch Video Link Displayed")
    private boolean isWatchVideoLinkDisplayed() {
        WebElement watchVideoLink = driver.findElement(sNLandPgWatchNowLinkLocator);
        highlightElement(watchVideoLink);
        return watchVideoLink.isDisplayed();
    }

    @Step("Click on the Supplements Link")
    public void clickHomeLink() {
        final WebElement homeLink = driver.findElement(sNLandPgHomeLinkLocator);
        highlightElement(homeLink);
        homeLink.isEnabled();
        homeLink.click();
    }

    @Step("Click on the Supplements Link")
    public void clickSupplementsLink() {
        final WebElement supplementsLink = driver.findElement(sNLandPgSupplementsLinkLocator);
        highlightElement(supplementsLink);
        supplementsLink.isEnabled();
        supplementsLink.click();
    }

    @Step("Click on the Male Supplement Guide Link")
    public void clickMaleGuideLink() {
        final WebElement MaleGuideLink = driver.findElement(sNLandPgMaleGuideLinkLocator);
        highlightElement(MaleGuideLink);
        MaleGuideLink.isEnabled();
        MaleGuideLink.click();
    }

    @Step("Click on the Female Supplement Guide Link")
    public void clickFemaleGuideLink() {
        final WebElement femaleGuideLink = driver.findElement(sNLandPgFemaleGuideLinkLocator);
        highlightElement(femaleGuideLink);
        femaleGuideLink.isEnabled();
        femaleGuideLink.click();
    }

    @Step("Click on the Supplement Guide Link")
    public void clickSupplementGuideLink() {
        final WebElement supplementGuideLink = driver.findElement(sNLandPgSupplementGuideLinkLocator);
        highlightElement(supplementGuideLink);
        supplementGuideLink.isEnabled();
        supplementGuideLink.click();
    }

    @Step("Click on the Clothing Link")
    public void clickClothingLink() {
        final WebElement clothingLink = driver.findElement(sNLandPgClothingLinkLocator);
        highlightElement(clothingLink);
        clothingLink.isEnabled();
        clothingLink.click();
    }

    @Step("Click on the About Us Link")
    public void clickAboutUsLink() {
        final WebElement aboutUsLink = driver.findElement(sNLandPgAboutUsLinkLocator);
        highlightElement(aboutUsLink);
        aboutUsLink.isEnabled();
        aboutUsLink.click();
    }

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
    private boolean isLandingLogoDisplayed(){
        final WebElement landingLogo = driver.findElement(sNLdnPgLogoLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logo Image").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(landingLogo));
        highlightElement(landingLogo);
        return landingLogo.isDisplayed();
    }

    @Step("Close Discount modal")
    public void closeDiscountModal() {
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
    @Step("Check: Verify the Watch Video Link Is Displayed")
    public void verifyWatchVideoLinkIsDisplayed() {
        assertTrue(isWatchVideoLinkDisplayed(), "Watch Video Link NOT Displayed");
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
        if (isLandingLogoDisplayed()) {
            System.out.println("Landing Page Logo IS Displayed");
        } else {
            throw new InterruptedException("Landing Page Logo NOT Displayed");
        }
    }

}
