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
    BurnPmUsF101Page burnPm101Pg;
    BurnCsF103Page burnCs103Pg;
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
        burnPm101Pg = new BurnPmUsF101Page(driver);
        burnCs103Pg = new BurnCsF103Page(driver);
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
        bcaasPg.clickBuyNowButton();
        bcaasPg.clickOneTimeDeliveryPriceLabel();
        bcaasPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=burn-pm-us-burnPMFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        burnPm101Pg.verifyCurrentPageURLEndsWith("/burn-pm-us?f=101");
        burnPm101Pg.verifyBurnPmIMageIsDisplayed();
        burnPm101Pg.scrollToBottomOfPageByKeys();
        burnPm101Pg.clickYesUpgradeButton();
        burnCs103Pg.verifyCurrentPageURLEndsWith("/burn-cs?f=103");
        burnCs103Pg.verifyBurnEvolvedImageIsDisplayed();
        burnCs103Pg.scrollToBottomOfPageByKeys();
        burnCs103Pg.clickOneTimeDeliveryPriceLabel();
        burnCs103Pg.clickSpeedUpMyMetabolismLinkByIndex(0);
        burnCs103Pg.verifyCurrentPageURLEndsWith("/turmeric-cs?f=104");
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
