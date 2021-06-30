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
@Story("Supplement Purchase Neuroctane 6 bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class Neuroctane6BottlesTest extends BaseTest {

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

    @Description("Verify Neurocatane 6 Bottles supplement purchase")
    @Test()//UUID=DF22E921-33DD-4C43-A0CA-8C54208D2AD0
    public void purchaseNeuroctaneSupplement6Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("neuroctane");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/neuroctane");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(1);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=greens-multi-cs-neuroctaneFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        grnsMultCs107Pg.verifyCurrentPageURLEndsWith("/greens-multi-cs?f=107");
        grnsMultCs107Pg.verifyGreensMultiCsPg107ImageIsDisplayed();
        grnsMultCs107Pg.scrollToBottomOfPageByKeys();
        grnsMultCs107Pg.pageUpByKeys();
        grnsMultCs107Pg.clickOneTimeDeliveryPriceLabel();
        grnsMultCs107Pg.clickAddToCartLinkByIndex(1);
        hghCs108Pg.verifyCurrentPageURLEndsWith("/hgh-cs?f=108");
        hghCs108Pg.verifyHghCS108Pg6BottleImageIsDisplayed();
        hghCs108Pg.scrollToBottomOfPageByKeys();
        hghCs108Pg.pageUpByKeys();
        hghCs108Pg.clickOneTimeDeliveryPriceLabel();
        hghCs108Pg.clickAddToCartLinkByIndex(1);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$594.95");
    }
}