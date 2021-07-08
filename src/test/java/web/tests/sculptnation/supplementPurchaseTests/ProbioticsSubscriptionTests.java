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
@Story("Supplement Purchase Probiotics Subscription Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class ProbioticsSubscriptionTests extends BaseTest {


    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    ProbioticsSalesFunnelPage prbtcsSlsFunlPg;
    EnzymesSalesFunnelPage enzymsCsPrbtcs152Pg;
    GreensSalesFunnelPage grnsSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        prbtcsSlsFunlPg = new ProbioticsSalesFunnelPage(driver);
        enzymsCsPrbtcs152Pg = new EnzymesSalesFunnelPage(driver);
        grnsSlsFunlPg = new GreensSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Probiotics supplement purchase subscription")
    @Test()//UUID=CBA28486-B6B1-4AE1-9DDE-FA37FD210C2D
    public void purchaseProbioticsSupplementSubscription() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("probiotics");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/probiotics");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickSubscribeNowButton();
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=enzymes-cs-probioticsMiniVSLFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        enzymsCsPrbtcs152Pg.verifyCurrentPageURLEndsWith("/enzymes-cs-probiotics?f=152");
        enzymsCsPrbtcs152Pg.verifyEnzymesCsProbioticsPg152VideoIsDisplayed();
        enzymsCsPrbtcs152Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        enzymsCsPrbtcs152Pg.pageDownByKeys();
        enzymsCsPrbtcs152Pg.clickSubscribeNowButton();
        grnsSlsFunlPg.verifyCurrentPageURLEndsWith("/greens-multi-cs-pro?f=154");
        grnsSlsFunlPg.verifyGreensPg154HeaderTextIsDisplayed();
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        grnsSlsFunlPg.pageUpByKeys();
        grnsSlsFunlPg.clickSubscribeNowButton();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-turmeric?f=221");
        cupnSlsFunlPg.verifyTurmericBlackPgCouponIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$171.95");
    }
}