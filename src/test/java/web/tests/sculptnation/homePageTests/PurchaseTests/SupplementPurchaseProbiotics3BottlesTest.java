package web.tests.sculptnation.homePageTests.PurchaseTests;

import framework.utility.Util;
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
@Story("Supplement Purchase Probiotics 3 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseProbiotics3BottlesTest extends BaseTest {

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

    @Description("Verify Probiotics supplement 3 Bottles purchase")
    @Test()//UUID=BF97E2AE-5452-4A14-8E47-7FB97FEA5360
    public void purchaseProbioticsSupplement3Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("probiotics");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/probiotics");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(2);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=probiotics-us-probioticsMiniVSLFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        Util.waitMilliseconds(5000000);
        prbtcsSlsFunlPg.verifyCurrentPageURLEndsWith("/probiotics-us?f=159");
        prbtcsSlsFunlPg.verifyProbioticsUs159Pg6BottleImageIsDisplayed();
        prbtcsSlsFunlPg.clickYesUpgradeButton();
        enzymsCsPrbtcs152Pg.verifyCurrentPageURLEndsWith("/enzymes-cs-probiotics?f=152");
        enzymsCsPrbtcs152Pg.verifyEnzymesCsProbioticsPg152VideoIsDisplayed();
        enzymsCsPrbtcs152Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        enzymsCsPrbtcs152Pg.pageDownByKeys();
        enzymsCsPrbtcs152Pg.clickOneTimeDeliveryPriceLabel();
        enzymsCsPrbtcs152Pg.clickAddToCartLinkByIndex(2);
        grnsSlsFunlPg.verifyCurrentPageURLEndsWith("/greens-multi-cs-pro?f=154");
        grnsSlsFunlPg.verifyGreensPg154HeaderTextIsDisplayed();
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        grnsSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        grnsSlsFunlPg.clickAddToCartLinkByIndex(2);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-turmeric?f=221");
        cupnSlsFunlPg.verifyTurmericBlackPgCouponIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$339.95");
    }
}