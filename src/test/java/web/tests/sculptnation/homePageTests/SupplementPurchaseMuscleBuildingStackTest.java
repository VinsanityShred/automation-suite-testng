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
@Story("Supplement Purchase Muscle Building Stack Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseMuscleBuildingStackTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    TestBoostUs85Page tstBstUs85Pg;
    HghVslCs87Page hghVslCs87Pg;
    CreatineCs88Page crtnCs88Pg;
    CouponBurn218Page cupnBurn218Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        tstBstUs85Pg = new TestBoostUs85Page(driver);
        hghVslCs87Pg = new HghVslCs87Page(driver);
        crtnCs88Pg = new CreatineCs88Page(driver);
        cupnBurn218Pg = new CouponBurn218Page(driver);
    }

    @Description("Verify Muscle Building Stack supplement purchase")
    @Test()//UUID=4B01E24F-6BE1-4FCE-B988-9E55218E72F9
    public void purchaseMuscleBuildingStackSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
//        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("muscle-building-stack");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/muscle-building-stack");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=testboost-us-muscleStackFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        tstBstUs85Pg.verifyCurrentPageURLEndsWith("/testboost-us?f=85");
        tstBstUs85Pg.verifyTestBoostPg85VideoIsDisplayed();
        tstBstUs85Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        tstBstUs85Pg.scrollToBottomOfPageByKeys();
        tstBstUs85Pg.clickYesUpgradeButton();
        tstBstUs85Pg.verifyCurrentPageURLEndsWith("/hgh-vsl-cs?f=87");
        hghVslCs87Pg.verifyHghVslCsPg87VideoIsDisplayed();
        hghVslCs87Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        hghVslCs87Pg.clickOneTimeDeliveryPriceLabel();
        hghVslCs87Pg.clickAddToCartLinkByIndex(0);
        crtnCs88Pg.verifyCurrentPageURLEndsWith("/creatine-cs?f=88");
        crtnCs88Pg.verifyCreatinePg88ImageIsDisplayed();
        crtnCs88Pg.scrollToBottomOfPageByKeys();
        crtnCs88Pg.clickOneTimeDeliveryPriceLabel();
        crtnCs88Pg.clickAddToCartLinkByIndex(0);
        cupnBurn218Pg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnBurn218Pg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnBurn218Pg.pageDownByKeys();
        cupnBurn218Pg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$388.95");
    }
}
