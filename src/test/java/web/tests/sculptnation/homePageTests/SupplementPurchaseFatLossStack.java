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
@Story("Supplement Purchase Fat Loss Stack Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseFatLossStack extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    CreatineUsF112Page crtnUs112Pg;
    BcaaCsF114Page bcaaCs114Pg;
    ProteinMultiCsF115Page PrtnMultCs115Pg;
    BurnUs109Page burnUs109Pg;
    HghCs111Page hghCs111Pg;
    GreensMultiCs110Page GrnsMulti110Pg;
    CouponTestBoost219Page CupnTstBst219Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        crtnUs112Pg = new CreatineUsF112Page(driver);
        bcaaCs114Pg = new BcaaCsF114Page(driver);
        PrtnMultCs115Pg = new ProteinMultiCsF115Page(driver);
        burnUs109Pg = new BurnUs109Page(driver);
        hghCs111Pg = new HghCs111Page(driver);
        GrnsMulti110Pg = new GreensMultiCs110Page(driver);
        CupnTstBst219Pg = new CouponTestBoost219Page(driver);
    }

    @Description("Verify Fat Loss Stack supplement purchase")
    @Test()//UUID=9D86E3C3-E766-4695-9223-4A16F3ADB9D5
    public void purchaseFatLossStackSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
//        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("fat-loss-stack");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/fat-loss-stack");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=burn-us-fatLossStackFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        burnUs109Pg.verifyCurrentPageURLEndsWith("/burn-us?f=109");
        burnUs109Pg.verifyBurnEvolved6BottleImageIsDisplayed();
        burnUs109Pg.scrollToBottomOfPageByKeys();
        burnUs109Pg.clickYesUpgradeButton();
        hghCs111Pg.verifyCurrentPageURLEndsWith("/hgh-cs?f=111");
        hghCs111Pg.verifyHghBoostImageIsDisplayed();
        hghCs111Pg.scrollToBottomOfPageByKeys();
        hghCs111Pg.clickOneTimeDeliveryPriceLabel();
        hghCs111Pg.clickAddToCartLinkByIndex(0);
        hghCs111Pg.verifyCurrentPageURLEndsWith("/greens-multi-cs?f=110");
        GrnsMulti110Pg.verifyGreenMultiImageIsDisplayed();
        GrnsMulti110Pg.scrollToBottomOfPageByKeys();
        GrnsMulti110Pg.clickOneTimeDeliveryPriceLabel();
        GrnsMulti110Pg.clickAddToCartLinkByIndex(0);
        CupnTstBst219Pg.verifyCurrentPageURLEndsWith("/coupon-testboost?f=219");
        CupnTstBst219Pg.verifyTestBoostPgCouponIsDisplayed();
        CupnTstBst219Pg.scrollToBottomOfPageByKeys();
        CupnTstBst219Pg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$400.95");
    }
}
