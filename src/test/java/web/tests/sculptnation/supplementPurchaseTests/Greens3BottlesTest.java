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
@Story("Supplement Purchase Greens 3 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class Greens3BottlesTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    GreensSalesFunnelPage grnsSlsFunlPg;
    TurmericSalesFunnelPage trmrc131Pg;
    NeuroctaneSalesFunnelPage nuroctn132Pg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        grnsSlsFunlPg = new GreensSalesFunnelPage(driver);
        trmrc131Pg = new TurmericSalesFunnelPage(driver);
        nuroctn132Pg = new NeuroctaneSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Greens 3 Bottles supplement purchase")
    @Test()//UUID=4EDBB0B6-ED5C-4F1C-A881-BFBDBDE86FC7
    public void purchaseGreensSupplement3Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("greens");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/greens");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(2);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=green-multi-us-greenMultiFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        grnsSlsFunlPg.verifyCurrentPageURLEndsWith("/greens-us-v5?f=129");
        grnsSlsFunlPg.verifyGreensVideoIsDisplayed();
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        grnsSlsFunlPg.pageUpByKeys();
        grnsSlsFunlPg.selectFlavorFromDropDown("Original");
        grnsSlsFunlPg.clickYesUpgradeButton();
        trmrc131Pg.verifyCurrentPageURLEndsWith("/turmeric-cs?f=131");
        trmrc131Pg.verifyTurmericPg131VideoIsDisplayed();
        trmrc131Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrc131Pg.scrollToBottomOfPageByKeys();
        trmrc131Pg.pageUpByKeys();
        trmrc131Pg.clickOneTimeDeliveryPriceLabel();
        trmrc131Pg.clickAddToCartLinkByIndex(2);
        nuroctn132Pg.verifyCurrentPageURLEndsWith("/neuroctane-cs?f=132");
        nuroctn132Pg.verifyNeuroctaneImageIsDisplayed();
        nuroctn132Pg.scrollToBottomOfPageByKeys();
        nuroctn132Pg.pageUpByKeys();
        nuroctn132Pg.clickOneTimeDeliveryPriceLabel();
        nuroctn132Pg.clickAddToCartLinkByIndex(2);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$588.95");
    }
}