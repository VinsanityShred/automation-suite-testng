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
@Story("Supplement Purchase Probiotics Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseProbioticsTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    ProbioticsUs159Page prbtcsUs159Pg;
    EnzymesCsProbiotics152Page enzymsCsPrbtcs152Pg;
    GreensMultiCsPro154Page grnsMultCsPr154Pg;
    CouponTurmeric221Page cupnTrmrc221Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        prbtcsUs159Pg = new ProbioticsUs159Page(driver);
        enzymsCsPrbtcs152Pg = new EnzymesCsProbiotics152Page(driver);
        grnsMultCsPr154Pg = new GreensMultiCsPro154Page(driver);
        cupnTrmrc221Pg = new CouponTurmeric221Page(driver);
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
        prbtcsUs159Pg.verifyCurrentPageURLEndsWith("/probiotics-us?f=159");
        prbtcsUs159Pg.verifyProbioticsUsPg159ImageIsDisplayed();
        prbtcsUs159Pg.clickYesUpgradeButton();
        enzymsCsPrbtcs152Pg.verifyCurrentPageURLEndsWith("/enzymes-cs-probiotics?f=152");
        enzymsCsPrbtcs152Pg.verifyEnzymesCsProbioticsPg152VideoIsDisplayed();
        enzymsCsPrbtcs152Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        enzymsCsPrbtcs152Pg.pageDownByKeys();
        enzymsCsPrbtcs152Pg.clickOneTimeDeliveryPriceLabel();
        enzymsCsPrbtcs152Pg.clickAddToCartLinkByIndex(0);
        grnsMultCsPr154Pg.verifyCurrentPageURLEndsWith("/greens-multi-cs-pro?f=154");
        grnsMultCsPr154Pg.verifyGreensPg154HeaderTextIsDisplayed();
        grnsMultCsPr154Pg.scrollToBottomOfPageByKeys();
        grnsMultCsPr154Pg.clickOneTimeDeliveryPriceLabel();
        grnsMultCsPr154Pg.clickAddToCartLinkByIndex(0);
        cupnTrmrc221Pg.verifyCurrentPageURLEndsWith("/coupon-turmeric?f=221");
        cupnTrmrc221Pg.verifyTurmericBlackPgCouponIsDisplayed();
        cupnTrmrc221Pg.pageDownByKeys();
        cupnTrmrc221Pg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$339.95");
    }
}
