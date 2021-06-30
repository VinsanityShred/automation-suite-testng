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
@Story("Supplement Purchase Greens Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class GreensTest extends BaseTest {

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

    @Description("Verify Greens supplement purchase")
    @Test()//UUID=5D347AAB-CF24-47A6-99B2-497F0FF6D18F
    public void purchaseGreensSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("greens");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/greens");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
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
        grnsSlsFunlPg.selectFlavorFromDropDown("Original");
        grnsSlsFunlPg.clickYesUpgradeButton();
        trmrc131Pg.verifyCurrentPageURLEndsWith("/turmeric-cs?f=131");
        trmrc131Pg.verifyTurmericPg131VideoIsDisplayed();
        trmrc131Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrc131Pg.clickOneTimeDeliveryPriceLabel();
        trmrc131Pg.clickAddToCartLinkByIndex(0);
        nuroctn132Pg.verifyCurrentPageURLEndsWith("/neuroctane-cs?f=132");
        nuroctn132Pg.verifyNeuroctaneImageIsDisplayed();
        nuroctn132Pg.scrollToBottomOfPageByKeys();
        nuroctn132Pg.clickOneTimeDeliveryPriceLabel();
        nuroctn132Pg.clickAddToCartLinkByIndex(0);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.scrollToBottomOfPageByKeys();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$339.95");
    }
}
