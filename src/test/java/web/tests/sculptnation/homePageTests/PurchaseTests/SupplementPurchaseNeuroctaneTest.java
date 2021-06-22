package web.tests.sculptnation.homePageTests.PurchaseTests;

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
@Story("Supplement Purchase Neuroctane Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseNeuroctaneTest extends BaseTest {

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

    @Description("Verify Neurocatane supplement purchase")
    @Test()//UUID=AB3EF306-BFEC-4EAE-AC34-E43BD9ED30CE
    public void purchaseNeuroctaneSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("neuroctane");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/neuroctane");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=neuroctane-us-neuroctaneFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        nurctnSlsFunlPg.verifyCurrentPageURLEndsWith("/neuroctane-us?f=105");
        nurctnSlsFunlPg.verifyNeuroctanePg105ImageIsDisplayed();
        nurctnSlsFunlPg.scrollToBottomOfPageByKeys();
        nurctnSlsFunlPg.clickYesUpgradeButton();
        grnsMultCs107Pg.verifyCurrentPageURLEndsWith("/greens-multi-cs?f=107");
        grnsMultCs107Pg.verifyGreensMultiCsPg107ImageIsDisplayed();
        grnsMultCs107Pg.scrollToBottomOfPageByKeys();
        grnsMultCs107Pg.clickOneTimeDeliveryPriceLabel();
        grnsMultCs107Pg.clickAddToCartLinkByIndex(0);
        hghCs108Pg.verifyCurrentPageURLEndsWith("/hgh-cs?f=108");
        hghCs108Pg.verifyHghCS108Pg6BottleImageIsDisplayed();
        hghCs108Pg.scrollToBottomOfPageByKeys();
        hghCs108Pg.clickOneTimeDeliveryPriceLabel();
        hghCs108Pg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$300.95");
    }
}
