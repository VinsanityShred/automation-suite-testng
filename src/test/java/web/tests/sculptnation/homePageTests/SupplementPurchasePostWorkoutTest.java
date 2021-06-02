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
@Story("Supplement Purchase Post Workout Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchasePostWorkoutTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    PostWorkoutUs78Page pstWrktUs78Pg;
    PreWorkoutMultiCs77Page preWrktMultCs77Pg;
    ProteinMultiCs80Page prtnMultCs80Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        pstWrktUs78Pg = new PostWorkoutUs78Page(driver);
        preWrktMultCs77Pg = new PreWorkoutMultiCs77Page(driver);
        prtnMultCs80Pg = new ProteinMultiCs80Page(driver);
    }

    @Description("Verify Post Workout Fruit Punch supplement purchase")
    @Test()//UUID=6BFB2B3F-6F83-4C86-AFB6-B3C7DD45115A
    public void purchasePostWorkFruitPunchSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("post-workout-fruit-punch");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/post-workout-fruit-punch");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=post-workout-us-postWorkoutFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        pstWrktUs78Pg.verifyCurrentPageURLEndsWith("/post-workout-us?f=78");
        pstWrktUs78Pg.verifyPostWorkoutPg78ImageIsDisplayed();
        pstWrktUs78Pg.scrollToBottomOfPageByKeys();
        pstWrktUs78Pg.clickYesUpgradeButton();
        pstWrktUs78Pg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=77");
        preWrktMultCs77Pg.verifyPreWorkoutPg77ImageIsDisplayed();
        preWrktMultCs77Pg.scrollToBottomOfPageByKeys();
        preWrktMultCs77Pg.clickOneTimeDeliveryPriceLabel();
        preWrktMultCs77Pg.clickAddToCartLinkByIndex(0);
        prtnMultCs80Pg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=80");
        prtnMultCs80Pg.verifyProteinMultiCsPg80ImageIsDisplayed();
        prtnMultCs80Pg.scrollToBottomOfPageByKeys();
        prtnMultCs80Pg.clickOneTimeDeliveryPriceLabel();
        prtnMultCs80Pg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$274.95");
    }
}
