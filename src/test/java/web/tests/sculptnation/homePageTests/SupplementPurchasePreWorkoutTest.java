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
    PreWorkoutMultiUs97Page prWrktMultUs97Pg;
    BcaaCs99Page bcaaCs99Pg;
    ProteinMultiCs100Page prtnMultCs100Pg;
    CouponBurn218Page cupnBrn218Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        prWrktMultUs97Pg = new PreWorkoutMultiUs97Page(driver);
        bcaaCs99Pg = new BcaaCs99Page(driver);
        prtnMultCs100Pg = new ProteinMultiCs100Page(driver);
        cupnBrn218Pg = new CouponBurn218Page(driver);
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
        prWrktMultUs97Pg.verifyCurrentPageURLEndsWith("/pre-workout-multi-us?f=97");
        prWrktMultUs97Pg.verifyPreWorkoutMultiUSPg97ImageIsDisplayed();
        prWrktMultUs97Pg.scrollToBottomOfPageByKeys();
        prWrktMultUs97Pg.selectFlavorFromDropDown("Peach");
        prWrktMultUs97Pg.clickYesUpgradeButton();
        bcaaCs99Pg.verifyCurrentPageURLEndsWith("/bcaa-cs?f=99");
        bcaaCs99Pg.verifyBcaasPg99ImageIsDisplayed();
        bcaaCs99Pg.scrollToBottomOfPageByKeys();
        bcaaCs99Pg.clickOneTimeDeliveryPriceLabel();
        bcaaCs99Pg.clickAddToCartLinkByIndex(0);
        prtnMultCs100Pg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=100");
        prtnMultCs100Pg.verifyProteinMultiCsPg100ImageIsDisplayed();
        prtnMultCs100Pg.scrollToBottomOfPageByKeys();
        prtnMultCs100Pg.clickOneTimeDeliveryPriceLabel();
        prtnMultCs100Pg.clickAddToCartLinkByIndex(0);
        cupnBrn218Pg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnBrn218Pg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnBrn218Pg.scrollToBottomOfPageByKeys();
        cupnBrn218Pg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$313.95");
    }
}
