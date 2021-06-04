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
@Story("Supplement Purchase Turmeric Black Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseTurmericBlackTest extends BaseTest {

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

    @Description("Verify Turmeric Black supplement purchase")
    @Test()//UUID=E387AEF7-5A2E-4FA1-8894-38AF33D1B07D
    public void purchaseTurmericBlackSupplement() throws Exception {

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
        trmrcSlsFunlPg.clickYesUpgradeButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-lg-cs1-v5?f=69");
        burnSlsFunlPg.verifyBurnLgCs1V5Pg69VideoIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        burnSlsFunlPg.clickSpeedUpMyMetabolismLinkByIndex(0);
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-pm-cs2-v4?f=70");
        burnSlsFunlPg.verifyBurnPmCs2V4Page70VideoIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.pageDownByKeys();
        burnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        burnSlsFunlPg.clickAddToCartLinkByIndex(0);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-greens-v2?f=217");
        cupnSlsFunlPg.verifyCouponGreensV2Pg217ImageIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$339.95");
    }
}
