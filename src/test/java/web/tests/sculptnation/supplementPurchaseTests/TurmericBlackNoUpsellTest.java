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
@Story("Supplement Purchase Turmeric Black No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class TurmericBlackNoUpsellTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    TurmericSalesFunnelPage trmrcSlsFunlPg;
    BurnSalesFunnelPage burnSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        trmrcSlsFunlPg = new TurmericSalesFunnelPage(driver);
        burnSlsFunlPg = new BurnSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Turmeric Black supplement purchase no upsell")
    @Test()//UUID=50E53F72-ADA2-440E-80E5-96BBA920380E
    public void purchaseTurmericBlackSupplementNoUpsell() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("turmeric-black");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/turmeric-black");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=turmeric-us-turmericFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        trmrcSlsFunlPg.verifyCurrentPageURLEndsWith("/turmeric-us?f=67");
        trmrcSlsFunlPg.verifyTurmericUsPg67VideoVideoIsDisplayed();
        trmrcSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrcSlsFunlPg.scrollToBottomOfPageByKeys();
        trmrcSlsFunlPg.pageUpByKeys();
        trmrcSlsFunlPg.clickNoThanksRedLink();
        trmrcSlsFunlPg.verifyCurrentPageURLEndsWith("/turmeric-ds?f=68");
        trmrcSlsFunlPg.verifyTurmericUs68Pg3BottleImageIsDisplayed();
        trmrcSlsFunlPg.scrollToBottomOfPageByKeys();
        trmrcSlsFunlPg.pageUpByKeys();
        trmrcSlsFunlPg.clickNoThanksRedLink();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-lg-cs1-v5?f=69");
        burnSlsFunlPg.verifyBurnLgCs1V5Pg69VideoIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.pageUpByKeys();
        burnSlsFunlPg.clickNoThanksRedLink2();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-pm-cs2-v4?f=70");
        burnSlsFunlPg.verifyBurnPmCs2V4Page70VideoIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.pageDownByKeys();
        burnSlsFunlPg.clickNoThanksRedLink2();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-greens-v2?f=217");
        cupnSlsFunlPg.verifyCouponGreensV2Pg217ImageIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickNoThanksRedLink();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$58.95");
    }
}