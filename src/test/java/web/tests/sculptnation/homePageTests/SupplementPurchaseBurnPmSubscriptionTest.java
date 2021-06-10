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
import web.pages.sculptnation.productPages.BcaasProductPage;
import web.tests.BaseTest;

@Feature("Home Page Tests")
@Story("Supplement Purchase Burn PM Subscription Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseBurnPmSubscriptionTest extends BaseTest {

    SNLandingPage sNLndPg;
    BcaasProductPage bcaasPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    CouponSalesFunnelPage cupnSlsFunlPg;
    BurnSalesFunnelPage burnSlsFunlPg;
    TurmericSalesFunnelPage trmrcSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        bcaasPg = new BcaasProductPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
        burnSlsFunlPg = new BurnSalesFunnelPage(driver);
        trmrcSlsFunlPg = new TurmericSalesFunnelPage(driver);
    }

    @Description("Verify Burn PM supplement purchase")
    @Test()//UUID=07AC4D28-3974-4B97-80EE-9DA70C516243
    public void purchaseBurnPMSupplementSubscription() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("burn-pm");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/burn-pm");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickSubscribeNowButton();
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=burn-cs-burnPMFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-cs?f=103");
        burnSlsFunlPg.verifyBurnEvolved1BottleImageIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.clickSubscribeNowButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/turmeric-cs?f=104");
        trmrcSlsFunlPg.verifyTurmericCs104PgVideoIsDisplayed();
        trmrcSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrcSlsFunlPg.scrollToBottomOfPageByKeys();
        trmrcSlsFunlPg.pageUpByKeys();
        trmrcSlsFunlPg.clickSubscribeNowButton();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-greens-v2?f=217");
        cupnSlsFunlPg.scrollToBottomOfPageByKeys();
        cupnSlsFunlPg.pageUpByKeys();
        cupnSlsFunlPg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$171.95");
    }
}
