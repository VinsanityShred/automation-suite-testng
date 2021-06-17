package web.tests.sculptnation.homePageTests.PurchaseTests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.*;
import web.tests.BaseTest;

@Story("Supplement Purchase Hgh Boost No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseHghBoostNoUpsellTest extends BaseTest {

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

    @Description("Verify HGH Boost supplement purchase no upsell")
    @Test()//UUID=0F723EF4-F8BC-40E2-B5D8-21DBB804B80A
    public void purchaseHghBoostSupplementNoUpsell() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("hgh-boost");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/hgh-boost");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=hgh-us-hghFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        hghSlsFunlPg.verifyCurrentPageURLEndsWith("/hgh-us?f=116");
        hghSlsFunlPg.verifyHgh6BottlePg116ImageIsDisplayed();
        hghSlsFunlPg.scrollToBottomOfPageByKeys();
        hghSlsFunlPg.pageUpByKeys();
        hghSlsFunlPg.clickNoThanksRedLink();
        hghSlsFunlPg.verifyCurrentPageURLEndsWith("/hgh-ds?f=117");
        hghSlsFunlPg.verifyHgh3BottlePg117ImageIsDisplayed();
        hghSlsFunlPg.scrollToBottomOfPageByKeys();
        hghSlsFunlPg.pageUpByKeys();
        hghSlsFunlPg.clickNoThanksRedLink();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-cs?f=118");
        burnSlsFunlPg.verifyBurnPg118ImageIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.clickNoThanksRedLink2();
        prWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=119");
        prWrktSlsFunlPg.verifyPreWorkoutMultiPg119ImageIsDisplayed();
        prWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        prWrktSlsFunlPg.pageUpByKeys();
        prWrktSlsFunlPg.clickNoThanksRedLink2();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burnpm?f=220");
        cupnSlsFunlPg.verifyBurnPmCouponPg220ImageIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickNoThanksRedLink();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$58.95");
    }
}
