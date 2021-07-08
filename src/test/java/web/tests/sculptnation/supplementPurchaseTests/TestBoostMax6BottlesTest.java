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
@Story("Supplement Purchase Test Boost Max 6 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class TestBoostMax6BottlesTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    TestBoostSalesFunnelPage tstBstUs81Pg;
    HghSalesFunnelPage hghSlsFunlPg;
    CreatineSalesFunnelPage crtnSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        tstBstUs81Pg = new TestBoostSalesFunnelPage(driver);
        hghSlsFunlPg = new HghSalesFunnelPage(driver);
        crtnSlsFunlPg = new CreatineSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Test Boost Max supplement 6 Bottles purchase")
    @Test()//UUID=56CC0373-1D77-4DF5-B4A2-9AA0601BF5E5
    public void purchaseTestBoostMaxSupplement6Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("testboost-max");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/testboost-max");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickSkyrocketMyManhoodButton(1);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=hgh-vsl-cs-testboostFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        hghSlsFunlPg.verifyCurrentPageURLEndsWith("/hgh-vsl-cs?f=83");
        hghSlsFunlPg.verifyHghVslCsPg83VideoIsDisplayed();
        hghSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        hghSlsFunlPg.pageDownByKeys();
        hghSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        hghSlsFunlPg.clickAddToCartLinkByIndex(1);
        crtnSlsFunlPg.verifyCurrentPageURLEndsWith("/creatine-vsl-cs-v2?f=84");
        crtnSlsFunlPg.verifyCreatineVslCsV2Pg84VideoIsDisplayed();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        crtnSlsFunlPg.pageUpByKeys();
        crtnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        crtnSlsFunlPg.clickAddToCartLinkByIndex(1);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$621.95");
    }
}