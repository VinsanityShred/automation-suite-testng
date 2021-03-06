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
@Story("Supplement Purchase Muscle Building Stack Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class MuscleBuildingStackTest extends BaseTest {

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

    @Description("Verify Muscle Building Stack supplement purchase")
    @Test()//UUID=4B01E24F-6BE1-4FCE-B988-9E55218E72F9
    public void purchaseMuscleBuildingStackSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("muscle-building-stack");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/muscle-building-stack");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=testboost-us-muscleStackFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        tstBstSlsFunlPg.verifyCurrentPageURLEndsWith("/testboost-us?f=85");
        tstBstSlsFunlPg.verifyTestBoostPg85VideoIsDisplayed();
        tstBstSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        tstBstSlsFunlPg.scrollToBottomOfPageByKeys();
        tstBstSlsFunlPg.clickYesUpgradeButton();
        tstBstSlsFunlPg.verifyCurrentPageURLEndsWith("/hgh-vsl-cs?f=87");
        hghSlsFunlPg.verifyHghVslCsPg87VideoIsDisplayed();
        hghSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        hghSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        hghSlsFunlPg.clickAddToCartLinkByIndex(0);
        crtnSlsFunlPg.verifyCurrentPageURLEndsWith("/creatine-cs?f=88");
        crtnSlsFunlPg.verifyCreatine88Pg3BottleImageIsDisplayed();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        crtnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        crtnSlsFunlPg.clickAddToCartLinkByIndex(0);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$388.95");
    }
}