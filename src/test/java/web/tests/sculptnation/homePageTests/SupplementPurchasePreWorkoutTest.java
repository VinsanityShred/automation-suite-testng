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
@Story("Supplement Purchase Pre-Workout Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchasePreWorkoutTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    PreWorkoutSalesFunnelPage prWrktSlsFunlPg;
    BcaasSalesFunnelPage bcaaCs99Pg;
    ProteinSalesFunnelPage prtnSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        prWrktSlsFunlPg = new PreWorkoutSalesFunnelPage(driver);
        bcaaCs99Pg = new BcaasSalesFunnelPage(driver);
        prtnSlsFunlPg = new ProteinSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Pre-Workout supplement purchase")
    @Test()//UUID=D5808666-AD1B-4B1C-BCC9-0A2AD3F4EB29
    public void purchasePreWorkoutSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("pre-workout");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/pre-workout");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=pre-workout-fruit-punch-us-preWorkoutFruitPunchFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        prWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/pre-workout-multi-us?f=97");
        prWrktSlsFunlPg.verifyPreWorkoutMultiUSPg97ImageIsDisplayed();
        prWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        prWrktSlsFunlPg.selectFlavorFromDropDown("Peach");
        prWrktSlsFunlPg.clickYesUpgradeButton();
        bcaaCs99Pg.verifyCurrentPageURLEndsWith("/bcaa-cs?f=99");
        bcaaCs99Pg.verifyBcaasPg99ImageIsDisplayed();
        bcaaCs99Pg.scrollToBottomOfPageByKeys();
        bcaaCs99Pg.clickOneTimeDeliveryPriceLabel();
        bcaaCs99Pg.clickAddToCartLinkByIndex(0);
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=100");
        prtnSlsFunlPg.verifyProteinMultiCsPg100ImageIsDisplayed();
        prtnSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prtnSlsFunlPg.clickAddToCartLinkByIndex(0);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnSlsFunlPg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnSlsFunlPg.scrollToBottomOfPageByKeys();
        cupnSlsFunlPg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$313.95");
    }
}
