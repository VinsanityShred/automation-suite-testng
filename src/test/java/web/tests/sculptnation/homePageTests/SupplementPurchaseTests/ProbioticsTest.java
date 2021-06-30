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
@Story("Supplement Purchase Probiotics Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class ProbioticsTest extends BaseTest {

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

    @Description("Verify Probiotics supplement purchase")
    @Test()//UUID=3783AFE5-31D8-480E-B431-112184EFA933
    public void purchaseProbioticsSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("probiotics");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/probiotics");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=probiotics-us-probioticsMiniVSLFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        prbtcsSlsFunlPg.verifyCurrentPageURLEndsWith("/probiotics-us?f=159");
        prbtcsSlsFunlPg.verifyProbioticsUs159Pg6BottleImageIsDisplayed();
        prbtcsSlsFunlPg.clickYesUpgradeButton();
        enzymsCsPrbtcs152Pg.verifyCurrentPageURLEndsWith("/enzymes-cs-probiotics?f=152");
        enzymsCsPrbtcs152Pg.verifyEnzymesCsProbioticsPg152VideoIsDisplayed();
        enzymsCsPrbtcs152Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        enzymsCsPrbtcs152Pg.pageDownByKeys();
        enzymsCsPrbtcs152Pg.clickOneTimeDeliveryPriceLabel();
        enzymsCsPrbtcs152Pg.clickAddToCartLinkByIndex(0);
        grnsSlsFunlPg.verifyCurrentPageURLEndsWith("/greens-multi-cs-pro?f=154");
        grnsSlsFunlPg.verifyGreensPg154HeaderTextIsDisplayed();
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        grnsSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        grnsSlsFunlPg.clickAddToCartLinkByIndex(0);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-turmeric?f=221");
        cupnSlsFunlPg.verifyTurmericBlackPgCouponIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$339.95");
    }
}
