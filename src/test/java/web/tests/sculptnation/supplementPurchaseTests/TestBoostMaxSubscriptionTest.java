package web.tests.sculptnation.supplementPurchaseTests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.sculptnation.*;
import web.tests.BaseTest;

public class TestBoostMaxSubscriptionTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    TestBoostSalesFunnelPage tstBstUs81Pg;
    HghSalesFunnelPage hghSlsFunlPg;
    CreatineSalesFunnelPage crtnSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        tstBstUs81Pg = new TestBoostSalesFunnelPage(driver);
        hghSlsFunlPg = new HghSalesFunnelPage(driver);
        crtnSlsFunlPg = new CreatineSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Test Boost Max supplement purchase")
    @Test()//UUID=3B3639C4-045D-4792-A9E7-ACC50BBB17DE
    public void purchaseTestBoostMaxSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("testboost-max");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/testboost-max");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickSubscribeNowButton();
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=hgh-vsl-cs-testboostFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        hghSlsFunlPg.verifyCurrentPageURLEndsWith("/hgh-vsl-cs?f=83");
        hghSlsFunlPg.verifyHghVslCsPg83VideoIsDisplayed();
        hghSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        hghSlsFunlPg.pageDownByKeys();
        hghSlsFunlPg.clickSubscribeNowButton();
        crtnSlsFunlPg.verifyCurrentPageURLEndsWith("/creatine-vsl-cs-v2?f=84");
        crtnSlsFunlPg.verifyCreatineVslCsV2Pg84VideoIsDisplayed();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        crtnSlsFunlPg.pageUpByKeys();
        crtnSlsFunlPg.clickSubscribeNowButton();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$162.95");
    }
}