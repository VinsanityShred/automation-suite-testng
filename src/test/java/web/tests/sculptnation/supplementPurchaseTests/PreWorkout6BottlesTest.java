package web.tests.sculptnation.supplementPurchaseTests;

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
@Story("Supplement Purchase Pre-Workout 6 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class PreWorkout6BottlesTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    PreWorkoutSalesFunnelPage prWrktSlsFunlPg;
    BcaasSalesFunnelPage bcaaCsSlsFunlPg;
    ProteinSalesFunnelPage prtnSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        prWrktSlsFunlPg = new PreWorkoutSalesFunnelPage(driver);
        bcaaCsSlsFunlPg = new BcaasSalesFunnelPage(driver);
        prtnSlsFunlPg = new ProteinSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Pre-Workout supplement 6 Bottles purchase")
    @Test()//UUID=8CAACA73-60BA-4174-A0E5-0EA917D60412
    public void purchasePreWorkoutSupplement6Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("pre-workout");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/pre-workout");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(1);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=bcaa-cs-preWorkoutFruitPunchFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        bcaaCsSlsFunlPg.verifyCurrentPageURLEndsWith("/bcaa-cs?f=99");
        bcaaCsSlsFunlPg.verifyBcaas99Pg3BottleImageIsDisplayed();
        bcaaCsSlsFunlPg.scrollToBottomOfPageByKeys();
        bcaaCsSlsFunlPg.pageUpByKeys();
        bcaaCsSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        bcaaCsSlsFunlPg.clickAddToCartLinkByIndex(1);
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=100");
        prtnSlsFunlPg.verifyProteinMultiCs100Pg3BottleImageIsDisplayed();
        prtnSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnSlsFunlPg.pageUpByKeys();
        prtnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prtnSlsFunlPg.clickAddToCartLinkByIndex(1);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$642.95");
    }
}