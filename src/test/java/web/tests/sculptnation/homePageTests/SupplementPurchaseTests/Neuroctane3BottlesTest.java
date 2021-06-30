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
@Story("Supplement Purchase Neuroctane 3 bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class Neuroctane3BottlesTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    NeuroctaneSalesFunnelPage nurctnSlsFunlPg;
    GreensSalesFunnelPage grnsMultCs107Pg;
    HghSalesFunnelPage hghCs108Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        nurctnSlsFunlPg = new NeuroctaneSalesFunnelPage(driver);
        grnsMultCs107Pg = new GreensSalesFunnelPage(driver);
        hghCs108Pg = new HghSalesFunnelPage(driver);
    }

    @Description("Verify Neurocatane 3 Bottles supplement purchase")
    @Test()//UUID=9174B610-5E4F-4289-AF92-5CEEC2D6463B
    public void purchaseNeuroctaneSupplement3Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("neuroctane");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/neuroctane");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(2);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=neuroctane-us-neuroctaneFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        nurctnSlsFunlPg.verifyCurrentPageURLEndsWith("/neuroctane-us?f=105");
        nurctnSlsFunlPg.verifyNeuroctane105Pg6BottleImageIsDisplayed();
        nurctnSlsFunlPg.scrollToBottomOfPageByKeys();
        nurctnSlsFunlPg.pageUpByKeys();
        nurctnSlsFunlPg.clickYesUpgradeButton();
        grnsMultCs107Pg.verifyCurrentPageURLEndsWith("/greens-multi-cs?f=107");
        grnsMultCs107Pg.verifyGreensMultiCsPg107ImageIsDisplayed();
        grnsMultCs107Pg.scrollToBottomOfPageByKeys();
        grnsMultCs107Pg.pageUpByKeys();
        grnsMultCs107Pg.clickOneTimeDeliveryPriceLabel();
        grnsMultCs107Pg.clickAddToCartLinkByIndex(2);
        hghCs108Pg.verifyCurrentPageURLEndsWith("/hgh-cs?f=108");
        hghCs108Pg.verifyHghCS108Pg6BottleImageIsDisplayed();
        hghCs108Pg.scrollToBottomOfPageByKeys();
        hghCs108Pg.pageUpByKeys();
        hghCs108Pg.clickOneTimeDeliveryPriceLabel();
        hghCs108Pg.clickAddToCartLinkByIndex(2);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$549.95");
    }
}