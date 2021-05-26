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
@Story("Supplement Purchase No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseNoUpsellTest extends BaseTest {

    SNLandingPage sNLndPg;
    BcaasProductPage bcaasPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    BcaaUs120Page bcaaPg120;
    BcaaUs121Page bcaaPg121;
    CreatineCs122Page crtnPg122;
    ProtienMulti123Page protnPg123;
    Coupon218Page couponPg218;
    ReceiptPage RcptPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        bcaasPg = new BcaasProductPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        bcaaPg120 = new BcaaUs120Page(driver);
        bcaaPg121 = new BcaaUs121Page(driver);
        crtnPg122 = new CreatineCs122Page(driver);
        protnPg123 = new ProtienMulti123Page(driver);
        couponPg218 = new Coupon218Page(driver);
        RcptPg = new ReceiptPage(driver);
    }

    @Description("Verify BCAAs -supplement purchase no upsell")
    @Test()//UUID=03E0CE50-C719-463C-B2AF-E0A53F356C78
    public void purchaseBCAAsSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("bcaas");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/bcaas");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=bcaa-us-bcaaFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        bcaaPg120.verifyBcaaImageIsDisplayed();
        bcaaPg120.scrollToBottomOfPageByKeys();
        bcaaPg120.clickNoThanksLink();
        bcaaPg121.verifyCurrentPageURLEndsWith("/bcaa-ds?f=121");
        bcaaPg121.scrollToBottomOfPageByKeys();
        bcaaPg121.clickNoThanksLink();
        crtnPg122.verifyCurrentPageURLEndsWith("/creatine-cs?f=122");
        crtnPg122.scrollToBottomOfPageByKeys();
        crtnPg122.clickNoThanksLink();
        protnPg123.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=123");
        protnPg123.scrollToBottomOfPageByKeys();
        protnPg123.clickNoThanksLink();
        couponPg218.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        couponPg218.scrollToBottomOfPageByKeys();
        couponPg218.clickNoThanksLink();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$46.95");
    }
}
