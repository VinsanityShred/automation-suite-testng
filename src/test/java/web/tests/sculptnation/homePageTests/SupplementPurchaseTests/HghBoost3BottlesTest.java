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
@Story("Supplement Purchase Hgh Boost 3 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class HghBoost3BottlesTest extends BaseTest {

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

    @Description("Verify HGH Boost supplement 3 bottles purchase")
    @Test()//UUID=9DF5293A-F703-4714-9F53-F02B4E12BD7A
    public void purchaseHghBoostSupplement3Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("hgh-boost");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/hgh-boost");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(2);
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
        hghSlsFunlPg.clickYesUpgradeButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-cs?f=118");
        burnSlsFunlPg.verifyBurnPg118ImageIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.pageUpByKeys();
        burnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        burnSlsFunlPg.clickSpeedUpMyMetabolismLinkByIndex(2);
        prWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=119");
        prWrktSlsFunlPg.verifyPreWorkoutMulti119Pg3BottleImageIsDisplayed();
        prWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        prWrktSlsFunlPg.pageUpByKeys();
        prWrktSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prWrktSlsFunlPg.clickAddToCartLinkByIndex(2);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burnpm?f=220");
        cupnSlsFunlPg.verifyBurnPmCouponPg220ImageIsDisplayed();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$555.95");
    }
}