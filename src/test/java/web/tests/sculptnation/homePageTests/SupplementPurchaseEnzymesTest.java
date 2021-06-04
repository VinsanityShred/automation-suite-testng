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
@Story("Supplement Purchase Enzymes Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseEnzymesTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    EnzymesSalesFunnelPage enzymsSlsFunlPg;
    ProbioticsSalesFunnelPage prbtcsEnzyms155Pg;
    GreensSalesFunnelPage grnsSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        enzymsSlsFunlPg = new EnzymesSalesFunnelPage(driver);
        prbtcsEnzyms155Pg = new ProbioticsSalesFunnelPage(driver);
        grnsSlsFunlPg = new GreensSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Enzymes Fruit Punch supplement purchase")
    @Test()//UUID=FC360F50-EC3C-4623-B6B0-2BFF0EDC774C
    public void purchaseEnzymesSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("enzymes");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/enzymes");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=enzymes-us-enzymesMiniVSLFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        enzymsSlsFunlPg.verifyCurrentPageURLEndsWith("/enzymes-us?f=157");
        enzymsSlsFunlPg.verifyEnzymesImageIsDisplayed();
        enzymsSlsFunlPg.clickYesUpgradeButton();
        prbtcsEnzyms155Pg.verifyCurrentPageURLEndsWith("/probiotics-cs-enzymes?f=155");
        prbtcsEnzyms155Pg.verifyProbioticsEnzymesVideoIsDisplayed();
        prbtcsEnzyms155Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        prbtcsEnzyms155Pg.scrollToBottomOfPageByKeys();
        prbtcsEnzyms155Pg.clickOneTimeDeliveryPriceLabel();
        prbtcsEnzyms155Pg.clickAddToCartLinkByIndex(0);
        grnsSlsFunlPg.verifyCurrentPageURLEndsWith("/greens-multi-cs-enz?f=156");
        grnsSlsFunlPg.verifyGreensMultiEnzymesHeaderTextIsDisplayed();
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        grnsSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        grnsSlsFunlPg.clickAddToCartLinkByIndex(0);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-turmeric?f=221");
        cupnSlsFunlPg.verifyTurmericBlackPgCouponIsDisplayed();
        cupnSlsFunlPg.scrollToBottomOfPageByKeys();
        cupnSlsFunlPg.clickTurmericBlackYesButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$339.95");
    }
}
