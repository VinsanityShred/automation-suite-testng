package web.tests.sculptnation.homePageTests.PurchaseTests;

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
@Story("Supplement Purchase Bcaas Subscription Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseBcaasSubscriptionTest extends BaseTest {

    SNLandingPage sNLndPg;
    BcaasProductPage bcaasPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    CreatineSalesFunnelPage crtnSlsFunlPg;
    ProteinSalesFunnelPage prtnSlsFunlPg;
    CouponSalesFunnelPage couponPg218;
    ReceiptPage RcptPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        bcaasPg = new BcaasProductPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        crtnSlsFunlPg = new CreatineSalesFunnelPage(driver);
        prtnSlsFunlPg = new ProteinSalesFunnelPage(driver);
        couponPg218 = new CouponSalesFunnelPage(driver);
        RcptPg = new ReceiptPage(driver);
    }

    @Description("Verify BCAAs supplement Subscription purchase")
    @Test()//UUID=6BBCDFF0-1683-4CE0-AA32-749615489FF5
    public void purchaseBCAAsSupplementSubscription() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("bcaas");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/bcaas");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickSubscribeNowButton();
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=creatine-cs-bcaaFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        crtnSlsFunlPg.verifyCurrentPageURLEndsWith("/creatine-cs?f=122");
        crtnSlsFunlPg.verifyCreatine122Pg3BottleImageIsDisplayed();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        crtnSlsFunlPg.clickSubscribeNowButton();
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=123");
        prtnSlsFunlPg.verifyProteinMulti123Pg3BottleImageIsDisplayed();
        prtnSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnSlsFunlPg.clickSubscribeNowButton();
        couponPg218.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        couponPg218.verifyEvolvedPgCouponIsDisplayed();
        couponPg218.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$152.95");
    }
}
