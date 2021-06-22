package web.tests.sculptnation.homePageTests.PurchaseTests;

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
@Story("Supplement Purchase Post Workout Subscription Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchasePostWorkoutSubscriptionTest extends BaseTest {

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

    @Description("Verify Post Workout Fruit Punch supplement purchase subscription")
    @Test()//UUID=425C0968-AFBA-4FA4-A549-11173CA0D573
    public void purchasePostWorkFruitPunchSupplementSubscription() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("post-workout-fruit-punch");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/post-workout-fruit-punch");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickSubscribeNowButton();
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
        prWrktSlsFunlPg.clickSubscribeNowButton();
        prtnMultSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=80");
        prtnMultSlsFunlPg.verifyProteinMultiCs80Pg3BottleImageIsDisplayed();
        prtnMultSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnMultSlsFunlPg.pageUpByKeys();
        prtnMultSlsFunlPg.clickSubscribeNowButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$113.95");
    }
}