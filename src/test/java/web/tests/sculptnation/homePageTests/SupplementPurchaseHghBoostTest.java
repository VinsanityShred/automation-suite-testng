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
@Story("Supplement Purchase Hgh Boost Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseHghBoostTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    HghUs116Page hghUs116Pg;
    BurnSalesFunnelPage burnSlsFunlPg;
    PreWorkoutMultiCs119Page prWrktMltCs119Pg;
    CouponBurnPm220Page cupnBrnPm220Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        hghUs116Pg = new HghUs116Page(driver);
        burnSlsFunlPg = new BurnSalesFunnelPage(driver);
        prWrktMltCs119Pg = new PreWorkoutMultiCs119Page(driver);
        cupnBrnPm220Pg = new CouponBurnPm220Page(driver);
    }

    @Description("Verify HGH Boost supplement purchase")
    @Test()//UUID=BE9BA8CE-40F6-4E9B-95D9-1550161A4BB1
    public void purchaseHghBoostSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("hgh-boost");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/hgh-boost");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=hgh-us-hghFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        hghUs116Pg.verifyCurrentPageURLEndsWith("/hgh-us?f=116");
        hghUs116Pg.verifyHghPg116ImageIsDisplayed();
        hghUs116Pg.scrollToBottomOfPageByKeys();
        hghUs116Pg.clickYesUpgradeButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-cs?f=118");
        burnSlsFunlPg.verifyBurnPg118ImageIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        burnSlsFunlPg.clickSpeedUpMyMetabolismLinkByIndex(0);
        prWrktMltCs119Pg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=119");
        prWrktMltCs119Pg.verifyPreWorkoutMultiPg119ImageIsDisplayed();
        prWrktMltCs119Pg.scrollToBottomOfPageByKeys();
        prWrktMltCs119Pg.clickOneTimeDeliveryPriceLabel();
        prWrktMltCs119Pg.clickAddToCartLinkByIndex(0);
        cupnBrnPm220Pg.verifyCurrentPageURLEndsWith("/coupon-burnpm?f=220");
        cupnBrnPm220Pg.verifyBurnPmCouponPg220ImageIsDisplayed();
        cupnBrnPm220Pg.scrollToBottomOfPageByKeys();
        cupnBrnPm220Pg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$327.95");
    }

}
