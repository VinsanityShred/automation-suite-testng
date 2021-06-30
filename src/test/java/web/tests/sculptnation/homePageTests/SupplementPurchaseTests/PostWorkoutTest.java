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
@Story("Supplement Purchase Post Workout Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class PostWorkoutTest extends BaseTest {

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

    @Description("Verify Post Workout Fruit Punch supplement purchase")
    @Test()//UUID=6BFB2B3F-6F83-4C86-AFB6-B3C7DD45115A
    public void purchasePostWorkFruitPunchSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
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
        pstWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/post-workout-us?f=78");
        pstWrktSlsFunlPg.verifyPostWorkout78Pg6BottleImageIsDisplayed();
        pstWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        pstWrktSlsFunlPg.clickYesUpgradeButton();
        pstWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=77");
        prWrktSlsFunlPg.verifyPreWorkout77Pg3BottleImageIsDisplayed();
        prWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        prWrktSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prWrktSlsFunlPg.clickAddToCartLinkByIndex(0);
        prtnMultSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=80");
        prtnMultSlsFunlPg.verifyProteinMultiCs80Pg3BottleImageIsDisplayed();
        prtnMultSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnMultSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prtnMultSlsFunlPg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$274.95");
    }
}