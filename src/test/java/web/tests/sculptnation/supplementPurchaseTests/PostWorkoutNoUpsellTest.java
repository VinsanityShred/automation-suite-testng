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
@Story("Supplement Purchase Post Workout No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class PostWorkoutNoUpsellTest extends BaseTest {

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

    @Description("Verify Post Workout Fruit Punch supplement purchase no upsell")
    @Test()//UUID=99677ADD-4B7F-4F93-AB7A-1D90E30BFD6A
    public void purchasePostWorkFruitPunchSupplementNoUpsell() throws Exception {

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
        pstWrktSlsFunlPg.pageDownByKeys();
        pstWrktSlsFunlPg.clickNoThanksRedLink();
        pstWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/post-workout-ds?f=79");
        pstWrktSlsFunlPg.verifyPostWorkout79Pp3BottleImageIsDisplayed();
        pstWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        pstWrktSlsFunlPg.pageUpByKeys();
        pstWrktSlsFunlPg.clickNoThanksRedLink();
        pstWrktSlsFunlPg.verifyCurrentPageURLEndsWith("/pre-workout-multi-cs?f=77");
        prWrktSlsFunlPg.verifyPreWorkout77Pg3BottleImageIsDisplayed();
        prWrktSlsFunlPg.scrollToBottomOfPageByKeys();
        prWrktSlsFunlPg.pageUpByKeys();
        prWrktSlsFunlPg.clickNoThanksRedLink2();
        prtnMultSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=80");
        prtnMultSlsFunlPg.verifyProteinMultiCs80Pg3BottleImageIsDisplayed();
        prtnMultSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnMultSlsFunlPg.pageUpByKeys();
        prtnMultSlsFunlPg.clickNoThanksRedLink2();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$46.95");
    }
}