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
@Story("Supplement Purchase Post Workout 3 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class PostWorkout3BottlesTest extends BaseTest {

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

    @Description("Verify Post Workout Fruit Punch 3 Bottles supplement purchase")
    @Test()//UUID=DB0C8C3D-0E1D-4B85-8F10-335198DDB5A6
    public void purchasePostWorkFruitPunchSupplement3Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("post-workout-fruit-punch");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/post-workout-fruit-punch");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(2);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=post-workout-us-postWorkoutFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        pstWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/post-workout-us?f=78");
        pstWrktSlsFunlPg.verifyPostWorkout78Pg6BottleImageIsDisplayed();
        pstWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        pstWrktSlsFunlPg.pageUpByKeys();
        pstWrktSlsFunlPg.clickYesUpgradeButton();
        pstWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=77");
        prWrktSlsFunlPg.verifyPreWorkout77Pg3BottleImageIsDisplayed();
        prWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        prWrktSlsFunlPg.pageUpByKeys();
        prWrktSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prWrktSlsFunlPg.clickAddToCartLinkByIndex(2);
        prtnMultSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=80");
        prtnMultSlsFunlPg.verifyProteinMultiCs80Pg3BottleImageIsDisplayed();
        prtnMultSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnMultSlsFunlPg.pageUpByKeys();
        prtnMultSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prtnMultSlsFunlPg.clickAddToCartLinkByIndex(2);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$471.95");
    }
}