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
@Story("Supplement Purchase Greens No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class GreensNoUpsellTest extends BaseTest {

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

    @Description("Verify Greens supplement purchase no upsell")
    @Test()//UUID=6C39ADDF-B9C3-401F-A249-D6DDDE81A5F7
    public void purchaseGreensSupplementNoUpsell() throws Exception {

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
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        grnsSlsFunlPg.clickNoThanksRedLink();
        grnsSlsFunlPg.verifyCurrentPageURLEndsWith("/greens-ds-v5?f=130");
        grnsSlsFunlPg.verifyGreens130Pg3BottleImageIsDisplayed();
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        grnsSlsFunlPg.clickNoThanksRedLink();
        trmrc131Pg.verifyTurmericPg131VideoIsDisplayed();
        trmrc131Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrc131Pg.scrollToBottomOfPageByKeys();
        trmrc131Pg.clickNoThanksRedLink();
        nuroctn132Pg.verifyCurrentPageURLEndsWith("/neuroctane-cs?f=132");
        nuroctn132Pg.verifyNeuroctaneImageIsDisplayed();
        nuroctn132Pg.scrollToBottomOfPageByKeys();
        nuroctn132Pg.pageUpByKeys();
        nuroctn132Pg.clickNoThanksRedLink2();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.scrollToBottomOfPageByKeys();
        cupnSlsFunlPg.clickNoThanksRedLink();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$58.95");
    }
}
