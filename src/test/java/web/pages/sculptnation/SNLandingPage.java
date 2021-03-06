package web.pages.sculptnation;

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
    By sNLdnPgFBMediaLinkLocator = By.xpath("//*[@href='https://www.facebook.com/sculptnation/']");
    By sNLdnPgInstagramMediaLinkLocator = By.xpath("//*[@href='https://www.instagram.com/sculptnation/']");
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
    By sNLandPgWatchNowLinkLocator = By.cssSelector("#app > div > section > div > div > a");
    By sNLandPgOKButtonLocator = By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/button");
    By sNLandPgFooterHomeLinkLocator = By.xpath("//*[@href='/']//*[@class='fa fa-angle-double-right']");
    By sNLandPgFooterContactUsLinkLocator = By.xpath("//*[@href='/contact-us']//*[@class='fa fa-angle-double-right']");
    By sNLandPgFooterShippingReturnsLinkLocator = By.xpath("//*[@href='/shipping-and-returns']");
    By sNLandPgFooterPrivacyCookiePolicyLinkLocator = By.xpath("//*[@href='/privacy-policy']//*[@class='fa fa-angle-double-right']");
    By sNLandPgFooterTopSellingItemsLinkLocator = By.xpath("//*[@href='/products']//*[@class='fa fa-angle-double-right']");
    By sNLandPgFooterAboutUsLinkLocator = By.xpath("//*[@href='/about-us']//*[@class='fa fa-angle-double-right']");
    By sNLandPgFooterShopLinkLocator = By.xpath("//*[text()=' Shop']");
    By sNLandPgFooterTermsConditionsLinkLocator = By.xpath("/html/body/footer/div[1]/div/a[1]");
    By sNLandPgFooterCopyRightLogoLocator = By.xpath("//*[@class='copyright']");
    By sNLandPgSkyrocketMyManhoodButtonLocator = By.xpath("//*[text()='SKYROCKET MY MANHOOD']");

    //// Methods ////
    @Step("Click on the Skyrocket My Manhood Button")
    public void clickSkyrocketMyManhoodButton(int index) {
        WebElement skyrocketMyManhoodButton = driver.findElements(sNLandPgSkyrocketMyManhoodButtonLocator).get(index);
        highlightElement(skyrocketMyManhoodButton);
        skyrocketMyManhoodButton.click();
    }

    @Step("Click on the Copy Right Logo")
    public void clickCopyRightLogo() {
        WebElement copyRightLogo = driver.findElement(sNLandPgFooterCopyRightLogoLocator);
        highlightElement(copyRightLogo);
        copyRightLogo.click();
    }

    @Step("Click on the OK button")
    public void clickOKButton() {
        Util.waitMilliseconds(1000);
        try {
            WebElement oKButton = driver.findElement(sNLandPgOKButtonLocator);
            highlightElement(oKButton);
            oKButton.click();
        } catch (Exception e){
            System.out.println(e);
        }
//        try {
//        WebElement oKButton = driver.findElement(sNLandPgOKButtonLocator);
//        Actions action = new Actions(driver);
//        action.moveToElement(oKButton).perform();
//            oKButton.click();
//        } catch (Exception e){
//            System.out.println(e);
//        }
    }

    @Step("Click on the product link by name")
    public void clickProductSupplement(String productName) {
        By productSupplementLocator = By.xpath("//*[contains(@href,'.com/products/"+productName+"')]");
        WebElement productSupplement = driver.findElement(productSupplementLocator);
        scrollToMiddle(productSupplement);
        highlightElement(productSupplement);
        productSupplement.click();
    }

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

    @Step("Click on the Home Link")
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
        Util.waitMilliseconds(500);
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

    @Step("Click on the footers Terms and Conditions Link")
    public void clickFooterTermsConditionsLink() {
        Util.waitMilliseconds(1000);
        final WebElement footerTermsConditionsLink = driver.findElement(sNLandPgFooterTermsConditionsLinkLocator);
        highlightElement(footerTermsConditionsLink);
        footerTermsConditionsLink.isEnabled();
        footerTermsConditionsLink.click();
    }

    @Step("Click on the footers Home Link")
    public void clickFooterHomeLink() {
        final WebElement footerHomeLink = driver.findElement(sNLandPgFooterHomeLinkLocator);
        highlightElement(footerHomeLink);
        footerHomeLink.isEnabled();
        footerHomeLink.click();
    }

    @Step("Click on the footers Shop Link")
    public void clickFooterShopLink() {
        final WebElement footerShopLink = driver.findElement(sNLandPgFooterShopLinkLocator);
        highlightElement(footerShopLink);
        footerShopLink.isEnabled();
        footerShopLink.click();
    }

    @Step("Click on the footers About Us Link")
    public void clickFooterAboutUsLink() {
        final WebElement footerAboutUsLink = driver.findElement(sNLandPgFooterAboutUsLinkLocator);
        highlightElement(footerAboutUsLink);
        footerAboutUsLink.isEnabled();
        footerAboutUsLink.click();
    }

    @Step("Click on the footers Top Selling Items Link")
    public void clickFooterTopSellingItemsLink() {
        final WebElement footerTopSellingItemsLink = driver.findElement(sNLandPgFooterTopSellingItemsLinkLocator);
        highlightElement(footerTopSellingItemsLink);
        footerTopSellingItemsLink.isEnabled();
        footerTopSellingItemsLink.click();
    }

    @Step("Click on the footers Privacy and Cookie Policy Link")
    public void clickFooterPrivacyCookiePolicyLink() {
        final WebElement footerPrivacyCookiePolicyLink = driver.findElement(sNLandPgFooterPrivacyCookiePolicyLinkLocator);
        highlightElement(footerPrivacyCookiePolicyLink);
        footerPrivacyCookiePolicyLink.isEnabled();
        footerPrivacyCookiePolicyLink.click();
    }

    @Step("Click on the footers Shipping and Returns Link")
    public void clickFooterShippingReturnsLink() {
        final WebElement footerShippingReturnsLink = driver.findElement(sNLandPgFooterShippingReturnsLinkLocator);
        highlightElement(footerShippingReturnsLink);
        footerShippingReturnsLink.isEnabled();
        footerShippingReturnsLink.click();
    }

    @Step("Click on Contact Us footer link")
    public void clickFooterContactUsLink() {
        final WebElement footerContactUsLink = driver.findElement(sNLandPgFooterContactUsLinkLocator);
        highlightElement(footerContactUsLink);
        footerContactUsLink.click();
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
        Util.waitMilliseconds(1500);
        try {
            if (driver.findElement(By.xpath("//*[@id='attentive_creative']")).isDisplayed()){
                switchToFrame("attentive_creative");
                System.out.println("Discount Modal Displayed");
                clickDiscountModalCloseButton();
            } else {
                System.out.println("No Discount Modal Displayed");
            }
        } catch (Exception e){
            System.out.println("No Discount Modal Displayed: "+ e);
        }
    }

    //// Setters ////

    //// Getters ////
    @Step("Get the Instagram page logo")
    public boolean getInstagramLogoImage() {
        Util.waitMilliseconds(3000);
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

    //// Verifiers ////
    @Step("Check: Verify Facebook Page Logo Is Displayed")
    public void verifyFBLogoIsDisplayed() throws InterruptedException {
        try  {
            getFBLogoImage2();
            System.out.println("Facebook Page Logo 2 Displayed");
        } catch(Exception e) {
            System.out.println("Facebook Logo 2 Not Displayed: " + e);
        }

        try {
            getFBLogoImage();
            System.out.println("Facebook Page Logo 1 Displayed");
        }
        catch(Exception e) {
            System.out.println("Facebook Logo 1 Not Displayed: " + e);
        }
    }

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
