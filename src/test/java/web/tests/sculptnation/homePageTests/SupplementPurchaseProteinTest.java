package web.tests.sculptnation.homePageTests;

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
@Story("Supplement Purchase Protein Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseProteinTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    ProteinSalesFunnelPage prtnSlsFunlPg;
    PreWorkoutSalesFunnelPage prWrktMultCs75Pg;
    PostWorkoutSalesFunnelPage pstWrktCs76Pg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        prtnSlsFunlPg = new ProteinSalesFunnelPage(driver);
        prWrktMultCs75Pg = new PreWorkoutSalesFunnelPage(driver);
        pstWrktCs76Pg = new PostWorkoutSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Protein supplement purchase")
    @Test()//UUID=F2B0F3B2-BB0F-45B2-831B-71FF7C74ED76
    public void purchaseProteinSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("protein");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/protein");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=protein-chocolate-us-proteinFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-us?f=73");
        prtnSlsFunlPg.verifyProteinMultiUsPg73ImageIsDisplayed();
        prtnSlsFunlPg.pageDownByKeys();
        prtnSlsFunlPg.pageDownByKeys();
        prtnSlsFunlPg.pageDownByKeys();
        prtnSlsFunlPg.pageDownByKeys();
        prtnSlsFunlPg.selectFlavorFromDropDown("Vanilla");
        prtnSlsFunlPg.clickYesUpgradeButton();
        prWrktMultCs75Pg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=75");
        prWrktMultCs75Pg.verifyPreWorkoutPg75ImageIsDisplayed();
        prWrktMultCs75Pg.scrollToBottomOfPageByKeys();
        prWrktMultCs75Pg.clickOneTimeDeliveryPriceLabel();
        prWrktMultCs75Pg.clickAddToCartLinkByIndex(0);
        pstWrktCs76Pg.verifyCurrentPageURLEndsWith("/post-workout-cs?f=76");
        pstWrktCs76Pg.verifyPostWorkoutCsPg76ImageIsDisplayed();
        pstWrktCs76Pg.scrollToBottomOfPageByKeys();
        pstWrktCs76Pg.clickOneTimeDeliveryPriceLabel();
        pstWrktCs76Pg.clickAddToCartLinkByIndex(0);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$349.95");
    }
}
