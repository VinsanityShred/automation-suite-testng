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
@Story("Supplement Purchase Turmeric Black 6 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class Turmeric6BottlesTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    TurmericSalesFunnelPage trmrcSlsFunlPg;
    BurnSalesFunnelPage burnSlsFunlPg;
    CouponSalesFunnelPage cupnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        trmrcSlsFunlPg = new TurmericSalesFunnelPage(driver);
        burnSlsFunlPg = new BurnSalesFunnelPage(driver);
        cupnSlsFunlPg = new CouponSalesFunnelPage(driver);
    }

    @Description("Verify Turmeric Black supplement 6 Bottles purchase")
    @Test()//UUID=C97AA5D2-1156-44D0-AB58-0CE5E998CB5F
    public void purchaseTurmericBlackSupplement6Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickProductSupplement("turmeric-black");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/turmeric-black");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(1);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=burn-lg-cs1-v3-turmericFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-lg-cs1-v5?f=69");
        burnSlsFunlPg.verifyBurnLgCs1V5Pg69VideoIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        burnSlsFunlPg.pageUpByKeys();
        burnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        burnSlsFunlPg.clickSpeedUpMyMetabolismLinkByIndex(1);
        burnSlsFunlPg.verifyCurrentPageURLEndsWith("/burn-pm-cs2-v4?f=70");
        burnSlsFunlPg.verifyBurnPmCs2V4Page70VideoIsDisplayed();
        burnSlsFunlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnSlsFunlPg.pageDownByKeys();
        burnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        burnSlsFunlPg.clickAddToCartLinkByIndex(1);
        cupnSlsFunlPg.verifyCurrentPageURLEndsWith("/coupon-greens-v2?f=217");
        cupnSlsFunlPg.verifyCouponGreensV2Pg217ImageIsDisplayed();
        cupnSlsFunlPg.pageDownByKeys();
        cupnSlsFunlPg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$633.95");
    }
}