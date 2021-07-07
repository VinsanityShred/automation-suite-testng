package web.tests.sculptnation.homePageTests;

import framework.utility.Util;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.*;
import web.tests.BaseTest;

@Feature("Home Page Tests")
@Story("Footer links test")
@Listeners( framework.testng.AllureScreenshots.class )
public class FooterTests extends BaseTest {

    SNLandingPage sNLndPg;
    ContactUsPage cUsPg;
    ShippingAndReturnsPage shpgRtrnPg;
    PrivacyPolicyPage prvcyPg;
    SupplementsPage sPg;
    AboutUsPage aUPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cUsPg = new ContactUsPage(driver);
        shpgRtrnPg = new ShippingAndReturnsPage(driver);
        prvcyPg = new PrivacyPolicyPage(driver);
        sPg = new SupplementsPage(driver);
        aUPg = new AboutUsPage(driver);

    }

    @Description("Verify the footer links are working as expected")
    @Test()//UUID=A26CFF22-44C7-4301-8B71-070ED80AD298
    public void footerTests() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickFooterContactUsLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/contact-us");
        cUsPg.verifyContactUsPgTextIsDisplayed();
        cUsPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickFooterShippingReturnsLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/shipping-and-returns");
        shpgRtrnPg.verifyShippingReturnHeaderDisplayed();
        shpgRtrnPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickFooterPrivacyCookiePolicyLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/privacy-policy");
        prvcyPg.verifyPrivacyPolicyHeaderDisplayed();
        prvcyPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickFooterTopSellingItemsLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/products");
        sPg.verifyProductCardIsDisplayed();
        sPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickFooterAboutUsLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/about-us");
        aUPg.verifyAboutUsHeaderIsDisplayed();
        aUPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickFooterShopLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/products");
        sPg.verifyProductCardIsDisplayed();
        sPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickFooterHomeLink();
        sNLndPg.verifyCurrentPageURL("https://sculptnation.com/");
        sNLndPg.verifyWatchVideoLinkIsDisplayed();
    }


}
