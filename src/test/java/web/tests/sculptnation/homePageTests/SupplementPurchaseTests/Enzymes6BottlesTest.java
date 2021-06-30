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
@Story("Supplement Purchase Enzymes 6 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class Enzymes6BottlesTest extends BaseTest {

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

    @Description("Verify Enzymes Fruit Punch 6 Bottles supplement purchase")
    @Test()//UUID=D0872BD5-538F-4EDF-947E-BBE268E89C72
    public void purchaseEnzymesSupplement6Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("enzymes");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/enzymes");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(1);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=probiotics-cs-enzymesMiniVSLFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        prbtcsSlsFunlPg.verifyCurrentPageURLEndsWith("/probiotics-cs-enzymes?f=155");
        prbtcsSlsFunlPg.verifyProbioticsEnzymesVideoIsDisplayed();
        prbtcsSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        prbtcsSlsFunlPg.scrollToBottomOfPageByKeys();
        prbtcsSlsFunlPg.pageUpByKeys();
        prbtcsSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prbtcsSlsFunlPg.clickAddToCartLinkByIndex(1);
        grnsSlsFunlPg.verifyCurrentPageURLEndsWith("/greens-multi-cs-enz?f=156");
        grnsSlsFunlPg.verifyGreensMultiEnzymesHeaderTextIsDisplayed();
        grnsSlsFunlPg.scrollToBottomOfPageByKeys();
        grnsSlsFunlPg.pageUpByKeys();
        grnsSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        grnsSlsFunlPg.clickAddToCartLinkByIndex(1);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-turmeric?f=221");
        cupnSlsFunlPg.verifyTurmericBlackPgCouponIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickTurmericBlackYesButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$633.95");
    }
}