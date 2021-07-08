package web.tests.sculptnation.supplementPurchaseTests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.*;
import web.pages.sculptnation.productPages.BcaasProductPage;
import web.tests.BaseTest;

@Feature("Home Page Tests")
@Story("Supplement Purchase Bcaas Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class BcaasTest extends BaseTest {

    SNLandingPage sNLndPg;
    BcaasProductPage bcaasPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    BcaasSalesFunnelPage bcaasSlsFunlPg;
    CreatineSalesFunnelPage crtnSlsFunlPg;
    ProteinSalesFunnelPage prtnSlsFunlPg;
    CouponSalesFunnelPage couponPg218;
    ReceiptPage RcptPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        bcaasPg = new BcaasProductPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        bcaasSlsFunlPg = new BcaasSalesFunnelPage(driver);
        crtnSlsFunlPg = new CreatineSalesFunnelPage(driver);
        prtnSlsFunlPg = new ProteinSalesFunnelPage(driver);
        couponPg218 = new CouponSalesFunnelPage(driver);
        RcptPg = new ReceiptPage(driver);
    }

    @Description("Verify BCAAs supplement purchase")
    @Test()//UUID=8BA139AE-0473-47A9-B099-C6853AC87D11
    public void purchaseBCAAsSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("bcaas");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/bcaas");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=bcaa-us-bcaaFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        bcaasSlsFunlPg.verifyCurrentPageURLEndsWith("/bcaa-us?f=120");
        bcaasSlsFunlPg.verifyBcaas6BottleImageIsDisplayed();
        bcaasSlsFunlPg.scrollToBottomOfPageByKeys();
        bcaasSlsFunlPg.clickYesUpgradeButton();
        crtnSlsFunlPg.verifyCurrentPageURLEndsWith("/creatine-cs?f=122");
        crtnSlsFunlPg.verifyCreatine122Pg3BottleImageIsDisplayed();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        crtnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        crtnSlsFunlPg.clickAddToCartLinkByIndex(0);
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=123");
        prtnSlsFunlPg.verifyProteinMulti123Pg3BottleImageIsDisplayed();
        prtnSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prtnSlsFunlPg.clickAddToCartLinkByIndex(0);
        couponPg218.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        couponPg218.verifyEvolvedPgCouponIsDisplayed();
        couponPg218.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$313.95");
    }
}
