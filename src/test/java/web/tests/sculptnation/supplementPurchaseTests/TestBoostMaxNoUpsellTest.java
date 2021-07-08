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
@Story("Supplement Purchase Test Boost Max No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class TestBoostMaxNoUpsellTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    TestBoostSalesFunnelPage tstBstSlsFunlPg;
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
        tstBstSlsFunlPg = new TestBoostSalesFunnelPage(driver);
        hghSlsFunlPg = new HghSalesFunnelPage(driver);
        crtnSlsFunlPg = new CreatineSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Test Boost Max supplement purchase no upsell")
    @Test()//UUID=26FF7363-FBFB-4AA6-8B17-EB5D9F6D6B5A
    public void purchaseTestBoostMaxSupplementNoUpsell() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("testboost-max");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/testboost-max");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickSkyrocketMyManhoodButton(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=testboost-us-testboostFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        tstBstSlsFunlPg.verifyCurrentPageURLEndsWith("/testboost-us?f=81");
        tstBstSlsFunlPg.verifyTestBoostUsPg81VideoIsDisplayed();
        tstBstSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        tstBstSlsFunlPg.clickIUnderstandLink();
        tstBstSlsFunlPg.verifyCurrentPageURLEndsWith("/testboost-ds?f=82");
        tstBstSlsFunlPg.verifyTestBoostDsPg82VideoIsDisplayed();
        tstBstSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        tstBstSlsFunlPg.clickNoThanksRedLink();
        hghSlsFunlPg.verifyCurrentPageURLEndsWith("/hgh-vsl-cs?f=83");
        hghSlsFunlPg.verifyHghVslCsPg83VideoIsDisplayed();
        hghSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        hghSlsFunlPg.scrollToBottomOfPageByKeys();
        hghSlsFunlPg.clickNoThanksRedLink();
        crtnSlsFunlPg.verifyCurrentPageURLEndsWith("/creatine-vsl-cs-v2?f=84");
        crtnSlsFunlPg.verifyCreatineVslCsV2Pg84VideoIsDisplayed();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        crtnSlsFunlPg.clickNoThanksRedLink();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.scrollToBottomOfPageByKeys();
        cupnSlsFunlPg.clickNoThanksRedLink();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$58.95");
    }
}