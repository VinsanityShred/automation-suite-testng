package web.tests.sculptnation.supplementPurchaseTests;

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
@Story("Supplement Purchase Post Workout 6 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class PostWorkout6BottlesTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    PostWorkoutSalesFunnelPage pstWrktSlsFunlPg;
    PreWorkoutSalesFunnelPage prWrktSlsFunlPg;
    ProteinSalesFunnelPage prtnMultSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        pstWrktSlsFunlPg = new PostWorkoutSalesFunnelPage(driver);
        prWrktSlsFunlPg = new PreWorkoutSalesFunnelPage(driver);
        prtnMultSlsFunlPg = new ProteinSalesFunnelPage(driver);
    }

    @Description("Verify Post Workout Fruit Punch 6 Bottles supplement purchase")
    @Test()//UUID=2D2AF5BD-3367-4EEB-BEB4-F340B0C59B4B
    public void purchasePostWorkFruitPunchSupplement6Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("post-workout-fruit-punch");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/post-workout-fruit-punch");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(1);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=pre-workout-multi-cs-postWorkoutFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        pstWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=77");
        prWrktSlsFunlPg.verifyPreWorkout77Pg3BottleImageIsDisplayed();
        prWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        prWrktSlsFunlPg.pageUpByKeys();
        prWrktSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prWrktSlsFunlPg.clickAddToCartLinkByIndex(1);
        prtnMultSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=80");
        prtnMultSlsFunlPg.verifyProteinMultiCs80Pg3BottleImageIsDisplayed();
        prtnMultSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnMultSlsFunlPg.pageUpByKeys();
        prtnMultSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prtnMultSlsFunlPg.clickAddToCartLinkByIndex(1);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$603.95");
    }
}