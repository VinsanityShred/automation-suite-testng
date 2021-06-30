package web.tests.sculptnation.homePageTests.SupplementPurchaseTests;

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
@Story("Supplement Purchase Greens Subscription Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class GreensSubscriptionTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    GreensSalesFunnelPage grnsSlsFunlPg;
    TurmericSalesFunnelPage trmrc131Pg;
    NeuroctaneSalesFunnelPage nuroctn132Pg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        grnsSlsFunlPg = new GreensSalesFunnelPage(driver);
        trmrc131Pg = new TurmericSalesFunnelPage(driver);
        nuroctn132Pg = new NeuroctaneSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Greens supplement purchase subscription")
    @Test()//UUID=974B4987-9DC4-43DE-8B0A-2704EC56EEF0
    public void purchaseGreensSupplementSubscription() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("greens");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/greens");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickSubscribeNowButton();
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=turmeric-cs-greenMultiFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        trmrc131Pg.verifyCurrentPageURLEndsWith("/turmeric-cs?f=131");
        trmrc131Pg.verifyTurmericPg131VideoIsDisplayed();
        trmrc131Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrc131Pg.scrollToBottomOfPageByKeys();
        trmrc131Pg.clickSubscribeNowButton();
        nuroctn132Pg.verifyCurrentPageURLEndsWith("/neuroctane-cs?f=132");
        nuroctn132Pg.verifyNeuroctaneImageIsDisplayed();
        nuroctn132Pg.scrollToBottomOfPageByKeys();
        nuroctn132Pg.pageUpByKeys();
        nuroctn132Pg.clickSubscribeNowButton();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.scrollToBottomOfPageByKeys();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$171.95");
    }
}