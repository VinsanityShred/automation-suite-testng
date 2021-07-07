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
@Story("Supplement Purchase Burn Evolved Subscription Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class BurnEvolvedSubscriptionTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    BurnSalesFunnelPage burnSlsFunlPg;
    TurmericSalesFunnelPage trmrcSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        burnSlsFunlPg = new BurnSalesFunnelPage(driver);
        trmrcSlsFunlPg = new TurmericSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Burn Evolved supplement purchase subscription")
    @Test()//UUID=AE85A19E-2893-400E-A825-6F34C238A04A
    public void purchaseBurnEvolvedSubscriptionSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("burn-evolved");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/burn-evolved");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickSubscribeNowButton();
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=burn-pm-cs-burnFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-lg-cs1-v1?f=36");
        burnSlsFunlPg.verifyBurnUpsellVideoIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.pageUpByKeys();
        burnSlsFunlPg.clickSubscribeNowButton();
        trmrcSlsFunlPg.verifyCurrentPageURLEndsWith("/turmeric-cs?f=37");
        trmrcSlsFunlPg.verifyTurmericCsVsPgVideoIsDisplayed();
        trmrcSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrcSlsFunlPg.scrollToBottomOfPageByKeys();
        trmrcSlsFunlPg.clickSubscribeNowButton();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-greens-v2?f=217");
        cupnSlsFunlPg.verifyCouponGreensV2Pg217ImageIsDisplayed();
        cupnSlsFunlPg.scrollToBottomOfPageByKeys();
        cupnSlsFunlPg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$171.95");
    }
}
