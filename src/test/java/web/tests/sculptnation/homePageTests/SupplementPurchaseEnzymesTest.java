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
    CreatineUsF112Page crtnUs112Pg;
    EnzymesUsF157Page enzymsUs157Pg;
    ProbioticsCsEnzymes155Page prbtcsEnzyms155Pg;
    GreensMultiCsEnz156Page GrnsMultiEnz156Pg;
    CouponTurmeric221Page CupnTrmc221Page;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        crtnUs112Pg = new CreatineUsF112Page(driver);
        enzymsUs157Pg = new EnzymesUsF157Page(driver);
        prbtcsEnzyms155Pg = new ProbioticsCsEnzymes155Page(driver);
        GrnsMultiEnz156Pg = new GreensMultiCsEnz156Page(driver);
        CupnTrmc221Page = new CouponTurmeric221Page(driver);
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
        enzymsUs157Pg.verifyCurrentPageURLEndsWith("/enzymes-us?f=157");
        enzymsUs157Pg.verifyEnzymesImageIsDisplayed();
        crtnUs112Pg.clickYesUpgradeButton();
        prbtcsEnzyms155Pg.verifyCurrentPageURLEndsWith("/probiotics-cs-enzymes?f=155");
        prbtcsEnzyms155Pg.verifyProbioticsEnzymesVideoIsDisplayed();
        prbtcsEnzyms155Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        prbtcsEnzyms155Pg.scrollToBottomOfPageByKeys();
        prbtcsEnzyms155Pg.clickOneTimeDeliveryPriceLabel();
        prbtcsEnzyms155Pg.clickAddToCartLinkByIndex(0);
        GrnsMultiEnz156Pg.verifyCurrentPageURLEndsWith("/greens-multi-cs-enz?f=156");
        GrnsMultiEnz156Pg.verifyGreensMultiEnzymesHeaderTextIsDisplayed();
        GrnsMultiEnz156Pg.scrollToBottomOfPageByKeys();
        GrnsMultiEnz156Pg.clickOneTimeDeliveryPriceLabel();
        GrnsMultiEnz156Pg.clickAddToCartLinkByIndex(0);
        CupnTrmc221Page.verifyCurrentPageURLEndsWith("/coupon-turmeric?f=221");
        CupnTrmc221Page.verifyTurmericBlackPgCouponIsDisplayed();
        CupnTrmc221Page.scrollToBottomOfPageByKeys();
        CupnTrmc221Page.clickTurmericBlackYesButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$339.95");
    }
}
