package web.tests.sculptnation.homePageTests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.*;
import web.pages.sculptnation.productPages.BcaasProductPage;
import web.tests.BaseTest;

@Feature("Home Page Tests")
@Story("Supplement Purchase Burn PM Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseBurnPmTest extends BaseTest {

    SNLandingPage sNLndPg;
    BcaasProductPage bcaasPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    CouponGreensV2F217Page cupnGrnsPg;
    BurnSalesFunnelPage burnSlsFunlPg;
    TurmericCsF104Page trmrcCs104Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        bcaasPg = new BcaasProductPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        cupnGrnsPg = new CouponGreensV2F217Page(driver);
        burnSlsFunlPg = new BurnSalesFunnelPage(driver);
        trmrcCs104Pg = new TurmericCsF104Page(driver);
    }

    @Description("Verify BCAAs -supplement purchase no upsell")
    @Test()//UUID=5BC1D1F6-06FE-43B8-9417-2A99778F2B63
    public void purchaseBurnPMSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("burn-pm");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/burn-pm");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=burn-pm-us-burnPMFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-pm-us?f=101");
        burnSlsFunlPg.verifyBurnPmIMageIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.clickYesUpgradeButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-cs?f=103");
        burnSlsFunlPg.verifyBurnEvolvedImageIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        burnSlsFunlPg.clickSpeedUpMyMetabolismLinkByIndex(0);
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/turmeric-cs?f=104");
        trmrcCs104Pg.verifyTurmericCs104PgVideoIsDisplayed();
        trmrcCs104Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrcCs104Pg.scrollToBottomOfPageByKeys();
        trmrcCs104Pg.clickOneTimeDeliveryPriceLabel();
        trmrcCs104Pg.clickAddToCartLinkByIndex(0);
        cupnGrnsPg.verifyCurrentPageURLEndsWith("/coupon-greens-v2?f=217");
        cupnGrnsPg.scrollToBottomOfPageByKeys();
        cupnGrnsPg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$339.95");
    }
}
