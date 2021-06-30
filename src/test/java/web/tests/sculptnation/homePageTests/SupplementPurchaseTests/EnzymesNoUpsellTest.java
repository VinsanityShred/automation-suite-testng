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
@Story("Supplement Purchase Enzymes No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class EnzymesNoUpsellTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    EnzymesSalesFunnelPage enzymsSlsFunlPg;
    ProbioticsSalesFunnelPage prbtcsSlsFunlPg;
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
        prbtcsSlsFunlPg = new ProbioticsSalesFunnelPage(driver);
        grnsSlsFunlPg = new GreensSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Enzymes supplement No Upsell purchase")
    @Test()//UUID=BF943BC5-B352-4BAB-99EC-44267AB1C536
    public void purchaseEnzymesSupplementNoUpsell() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
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
        enzymsSlsFunlPg.verifyEnzymes157Pg6BottleImageIsDisplayed();
        enzymsSlsFunlPg.scrollToBottomOfPageByKeys();
        enzymsSlsFunlPg.clickNoThanksRedLink();
        enzymsSlsFunlPg.verifyCurrentPageURLEndsWith("/enzymes-ds?f=158");
        enzymsSlsFunlPg.verifyEnzymes3BottleImageIsDisplayed();
        enzymsSlsFunlPg.scrollToBottomOfPageByKeys();
        enzymsSlsFunlPg.clickNoThanksRedLink();
        prbtcsSlsFunlPg.verifyCurrentPageURLEndsWith("/probiotics-cs-enzymes?f=155");
        prbtcsSlsFunlPg.verifyProbioticsEnzymesVideoIsDisplayed();
        prbtcsSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        prbtcsSlsFunlPg.clickNoThanksRedLink();
        grnsSlsFunlPg.verifyCurrentPageURLEndsWith("/greens-multi-cs-enz?f=156");
        grnsSlsFunlPg.verifyGreensMultiEnzymesHeaderTextIsDisplayed();
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        grnsSlsFunlPg.clickNoThanksRedLink();
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-turmeric?f=221");
        cupnSlsFunlPg.verifyTurmericBlackPgCouponIsDisplayed();
        cupnSlsFunlPg.scrollToBottomOfPageByKeys();
        cupnSlsFunlPg.pageUpByKeys();
        cupnSlsFunlPg.clickNoThanksRedLink();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$58.95");
    }
}