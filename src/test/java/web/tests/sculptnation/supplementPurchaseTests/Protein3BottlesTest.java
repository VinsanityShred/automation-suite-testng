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
@Story("Supplement Purchase Protein 3 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class Protein3BottlesTest extends BaseTest {

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

    @Description("Verify Protein supplement 3 Bottles purchase")
    @Test()//UUID=34FF945A-64EA-4653-B9FE-362BCE9C4E5E
    public void purchaseProteinSupplement3Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("protein");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/protein");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(2);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=protein-chocolate-us-proteinFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-us?f=73");
        prtnSlsFunlPg.verifyProteinMultiUs73Pg6BottleImageIsDisplayed();
        prtnSlsFunlPg.pageDownByKeys();
        prtnSlsFunlPg.pageDownByKeys();
        prtnSlsFunlPg.pageDownByKeys();
        prtnSlsFunlPg.pageDownByKeys();
        prtnSlsFunlPg.selectFlavorFromDropDown("Vanilla");
        prtnSlsFunlPg.clickYesUpgradeButton();
        prWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=75");
        prWrktSlsFunlPg.verifyPreWorkout75Pg3BottleImageIsDisplayed();
        prWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        prWrktSlsFunlPg.pageUpByKeys();
        prWrktSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prWrktSlsFunlPg.clickAddToCartLinkByIndex(2);
        pstWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/post-workout-cs?f=76");
        pstWrktSlsFunlPg.verifyPostWorkoutCs76Pg6BottleImageIsDisplayed();
        pstWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        pstWrktSlsFunlPg.pageUpByKeys();
        pstWrktSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        pstWrktSlsFunlPg.clickAddToCartLinkByIndex(2);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$546.95");
    }
}