package web.tests.sculptnation.homePageTests;

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
@Story("Supplement Purchase Burn Evolved No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseBurnEvolvedNoUpsellTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    BurnSalesFunnelPage burnSlsFunlPg;
    TurmericCsVsPage trmrcCsVsPg;
    CouponGreensV2F217Page cupnGrnsPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        burnSlsFunlPg = new BurnSalesFunnelPage(driver);
        trmrcCsVsPg = new TurmericCsVsPage(driver);
        cupnGrnsPg = new CouponGreensV2F217Page(driver);
    }

    @Description("Verify Burn Evolved supplement purchase no upsell")
    @Test()//UUID=4E091222-8B28-4AE0-A322-2B0E440DAEEE
    public void purchaseBurnEvolvedNoUpsellSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("burn-evolved");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/burn-evolved");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickSpeedUpMyMetabolismLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=burn-us-burnFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/fl-burn-burn-lg-us-v2?f=34");
        burnSlsFunlPg.verifyBurnUpsellVideoIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.clickNoThanksRedLink();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-ds?f=35");
        burnSlsFunlPg.verifyBurnDownsellVideoIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.clickNoThanksRedLink();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("burn-lg-cs1-v1?f=36");
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.pageDownByKeys();
        burnSlsFunlPg.pageDownByKeys();
        burnSlsFunlPg.clickNoThanksRedLink();
        //// turmeric ////
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/turmeric-cs?f=37");
        burnSlsFunlPg.verifyBurnDownsellVideoIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.clickNoThanksRedLink();
        //// Coupon ////
        cupnGrnsPg.verifyCurrentPageURLEndsWith("/coupon-greens-v2?f=217");
        cupnGrnsPg.verifyGreensPgCouponIsDisplayed();
        cupnGrnsPg.pageDownByKeys();
        cupnGrnsPg.clickNoThanksRedLink();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$58.95");
    }
}
