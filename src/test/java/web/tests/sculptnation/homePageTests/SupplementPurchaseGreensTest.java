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
@Story("Supplement Purchase Greens Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseGreensTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    GreensUsV5129Page grnsUsV5129Pg;
    TurmericCs131Page trmrc131Pg;
    Neuroctane132Page nuroctn132Pg;
    CouponBurn218Page cupnBurn218Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        grnsUsV5129Pg = new GreensUsV5129Page(driver);
        trmrc131Pg = new TurmericCs131Page(driver);
        nuroctn132Pg = new Neuroctane132Page(driver);
        cupnBurn218Pg = new CouponBurn218Page(driver);
    }

    @Description("Verify Greens supplement purchase")
    @Test()//UUID=5D347AAB-CF24-47A6-99B2-497F0FF6D18F
    public void purchaseGreensSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
//        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.pageDownByKeys();
        sNLndPg.clickProductSupplement("greens");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/greens");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=green-multi-us-greenMultiFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        grnsUsV5129Pg.verifyCurrentPageURLEndsWith("/greens-us-v5?f=129");
        grnsUsV5129Pg.verifyGreensVideoIsDisplayed();
        grnsUsV5129Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        grnsUsV5129Pg.selectFlavorFromDropDown("Original");
        grnsUsV5129Pg.clickYesUpgradeButton();
        trmrc131Pg.verifyCurrentPageURLEndsWith("/turmeric-cs?f=131");
        trmrc131Pg.verifyTurmericPg131VideoIsDisplayed();
        trmrc131Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrc131Pg.clickOneTimeDeliveryPriceLabel();
        trmrc131Pg.clickAddToCartLinkByIndex(0);
        nuroctn132Pg.verifyCurrentPageURLEndsWith("/neuroctane-cs?f=132");
        nuroctn132Pg.verifyNeuroctaneImageIsDisplayed();
        nuroctn132Pg.scrollToBottomOfPageByKeys();
        nuroctn132Pg.clickOneTimeDeliveryPriceLabel();
        nuroctn132Pg.clickAddToCartLinkByIndex(0);
        cupnBurn218Pg.verifyCurrentPageURLEndsWith("/coupon-burn?f=218");
        cupnBurn218Pg.verifyBurnCouponPg218ImageIsDisplayed();
        cupnBurn218Pg.scrollToBottomOfPageByKeys();
        cupnBurn218Pg.clickYesUpgradeButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$339.95");
    }
}
