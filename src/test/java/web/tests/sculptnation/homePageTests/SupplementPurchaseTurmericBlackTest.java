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
@Story("Supplement Purchase Turmeric Black Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseTurmericBlackTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    TurmericUs67Page trmrcUs67Pg;
    BurnLgCs1V569Page brnLgCs1V569Pg;
    BurnPmCs2V470Page burnPmCs2V470Pg;
    CouponGreensV2217Page cupnGrnsV2217Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        trmrcUs67Pg = new TurmericUs67Page(driver);
        brnLgCs1V569Pg = new BurnLgCs1V569Page(driver);
        burnPmCs2V470Pg = new BurnPmCs2V470Page(driver);
        cupnGrnsV2217Pg = new CouponGreensV2217Page(driver);
    }

    @Description("Verify Turmeric Black supplement purchase")
    @Test()//UUID=E387AEF7-5A2E-4FA1-8894-38AF33D1B07D
    public void purchaseTurmericBlackSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("turmeric-black");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/turmeric-black");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=turmeric-us-turmericFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        trmrcUs67Pg.verifyCurrentPageURLEndsWith("/turmeric-us?f=67");
        trmrcUs67Pg.verifyTurmericUsPg67VideoVideoIsDisplayed();
        trmrcUs67Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrcUs67Pg.scrollToBottomOfPageByKeys();
        trmrcUs67Pg.clickYesUpgradeButton();
        brnLgCs1V569Pg.verifyCurrentPageURLEndsWith("/burn-lg-cs1-v5?f=69");
        brnLgCs1V569Pg.verifyBurnLgCs1V5Pg69VideoIsDisplayed();
        brnLgCs1V569Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        brnLgCs1V569Pg.scrollToBottomOfPageByKeys();
        brnLgCs1V569Pg.clickOneTimeDeliveryPriceLabel();
        brnLgCs1V569Pg.clickSpeedUpMyMetabolismLinkByIndex(0);
        burnPmCs2V470Pg.verifyCurrentPageURLEndsWith("/burn-pm-cs2-v4?f=70");
        burnPmCs2V470Pg.verifyBurnPmCs2V4Page70VideoIsDisplayed();
        burnPmCs2V470Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnPmCs2V470Pg.pageDownByKeys();
        burnPmCs2V470Pg.clickOneTimeDeliveryPriceLabel();
        burnPmCs2V470Pg.clickAddToCartLinkByIndex(0);
        cupnGrnsV2217Pg.verifyCurrentPageURLEndsWith("/coupon-greens-v2?f=217");
        cupnGrnsV2217Pg.verifyCouponGreensV2Pg217ImageIsDisplayed();
        cupnGrnsV2217Pg.pageDownByKeys();
        cupnGrnsV2217Pg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$339.95");
    }
}
