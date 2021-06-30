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
@Story("Supplement Purchase Protein Subscription Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class ProteinSubscriptionTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    ProteinSalesFunnelPage prtnSlsFunlPg;
    PreWorkoutSalesFunnelPage prWrktSlsFunlPg;
    PostWorkoutSalesFunnelPage pstWrktSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        prtnSlsFunlPg = new ProteinSalesFunnelPage(driver);
        prWrktSlsFunlPg = new PreWorkoutSalesFunnelPage(driver);
        pstWrktSlsFunlPg = new PostWorkoutSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Protein supplement purchase")
    @Test()//UUID=CA93B6F8-F856-481D-B6A1-2DA8B30368CF
    public void purchaseProteinSupplementSubscription() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("protein");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/protein");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickSubscribeNowButton();
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=pre-workout-multi-cs-proteinFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        prWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=75");
        prWrktSlsFunlPg.verifyPreWorkout75Pg3BottleImageIsDisplayed();
        prWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        prWrktSlsFunlPg.pageUpByKeys();
        prWrktSlsFunlPg.clickSubscribeNowButton();
        pstWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/post-workout-cs?f=76");
        pstWrktSlsFunlPg.verifyPostWorkoutCs76Pg6BottleImageIsDisplayed();
        pstWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        pstWrktSlsFunlPg.pageUpByKeys();
        pstWrktSlsFunlPg.clickSubscribeNowButton();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$152.95");
    }
}