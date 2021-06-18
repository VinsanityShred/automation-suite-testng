package web.tests.sculptnation.homePageTests.PurchaseTests;

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
@Story("Supplement Purchase Hgh Boost Subscription Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseHghBoostSubscriptionTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    HghSalesFunnelPage hghSlsFunlPg;
    BurnSalesFunnelPage burnSlsFunlPg;
    PreWorkoutSalesFunnelPage prWrktSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        hghSlsFunlPg = new HghSalesFunnelPage(driver);
        burnSlsFunlPg = new BurnSalesFunnelPage(driver);
        prWrktSlsFunlPg = new PreWorkoutSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify HGH Boost supplement purchase")
    @Test()//UUID=1F266F9B-D848-4652-A242-9E3B1F3A8EA0
    public void purchaseHghBoostSupplementSubscription() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("hgh-boost");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/hgh-boost");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickSubscribeNowButton();
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=burn-cs-hghFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-cs?f=118");
        burnSlsFunlPg.verifyBurnPg118ImageIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.pageUpByKeys();
        burnSlsFunlPg.clickSubscribeNowButton();
        prWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=119");
        prWrktSlsFunlPg.verifyPreWorkoutMultiPg119ImageIsDisplayed();
        prWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        prWrktSlsFunlPg.pageUpByKeys();
        prWrktSlsFunlPg.clickSubscribeNowButton();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burnpm?f=220");
        cupnSlsFunlPg.verifyBurnPmCouponPg220ImageIsDisplayed();
        cupnSlsFunlPg.scrollToBottomOfPageByKeys();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$162.95");
    }
}
