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
@Story("Supplement Purchase Fat Loss Stack No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class FatLossStackNoUpsellTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    BurnSalesFunnelPage burnSlsFunlPg;
    HghSalesFunnelPage hghSlsFunlPg;
    GreensSalesFunnelPage grnsSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        burnSlsFunlPg = new BurnSalesFunnelPage(driver);
        hghSlsFunlPg = new HghSalesFunnelPage(driver);
        grnsSlsFunlPg = new GreensSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Fat Loss Stack supplement purchase no upsell")
    @Test()//UUID=8805B3D5-8785-45A0-B785-F4066B04CAD5
    public void purchaseFatLossStackSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
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
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-us?f=109");
        burnSlsFunlPg.verifyBurnEvolved6BottleImageIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.pageUpByKeys();
        burnSlsFunlPg.clickNoThanksRedLink();
        hghSlsFunlPg.verifyCurrentPageURLEndsWith("/hgh-cs?f=111");
        hghSlsFunlPg.verifyHghBoost6BottleImageIsDisplayed();
        hghSlsFunlPg.scrollToBottomOfPageByKeys();
        hghSlsFunlPg.clickNoThanksRedLink2();
        grnsSlsFunlPg.verifyCurrentPageURLEndsWith("/greens-multi-cs?f=110");
        grnsSlsFunlPg.verifyGreenMultiImageIsDisplayed();
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        grnsSlsFunlPg.clickNoThanksRedLink();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-testboost?f=219");
        cupnSlsFunlPg.verifyTestBoostPgCouponIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickNoThanksRedLink2();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$119.95");
    }
}