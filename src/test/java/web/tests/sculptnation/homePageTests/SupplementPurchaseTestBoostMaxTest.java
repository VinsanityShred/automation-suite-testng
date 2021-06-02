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
@Story("Supplement Purchase Test Boost Max Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseTestBoostMaxTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    TestBoostUs81Page tstBstUs81Pg;
    HghVslCs83Page hghVslCs83Pg;
    CreatineVslCsV284Page crtnVslCsV284Pg;
    CouponBurn218Page cupnBrn218Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        tstBstUs81Pg = new TestBoostUs81Page(driver);
        hghVslCs83Pg = new HghVslCs83Page(driver);
        crtnVslCsV284Pg = new CreatineVslCsV284Page(driver);
        cupnBrn218Pg = new CouponBurn218Page(driver);
    }

    @Description("Verify Test Boost Max supplement purchase")
    @Test()//UUID=3B3639C4-045D-4792-A9E7-ACC50BBB17DE
    public void purchaseTestBoostMaxSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("testboost-max");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/testboost-max");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickSkyrocketMyManhoodButton(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=testboost-us-testboostFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        tstBstUs81Pg.verifyCurrentPageURLEndsWith("/testboost-us?f=81");
        tstBstUs81Pg.verifyTestBoostUsPg81VideoIsDisplayed();
        tstBstUs81Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        tstBstUs81Pg.pageDownByKeys();
        tstBstUs81Pg.clickYesUpgradeButton();
        hghVslCs83Pg.verifyCurrentPageURLEndsWith("/hgh-vsl-cs?f=83");
        hghVslCs83Pg.verifyHghVslCsPg83VideoIsDisplayed();
        hghVslCs83Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        hghVslCs83Pg.pageDownByKeys();
        hghVslCs83Pg.clickOneTimeDeliveryPriceLabel();
        hghVslCs83Pg.clickAddToCartLinkByIndex(0);
        crtnVslCsV284Pg.verifyCurrentPageURLEndsWith("/creatine-vsl-cs-v2?f=84");
        crtnVslCsV284Pg.verifyCreatineVslCsV2Pg84VideoIsDisplayed();
        crtnVslCsV284Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        crtnVslCsV284Pg.clickOneTimeDeliveryPriceLabel();
        crtnVslCsV284Pg.clickAddToCartLinkByIndex(0);
        cupnBrn218Pg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnBrn218Pg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnBrn218Pg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$327.95");
    }
}
