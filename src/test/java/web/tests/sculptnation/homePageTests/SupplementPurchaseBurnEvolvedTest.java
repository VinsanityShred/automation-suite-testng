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
@Story("Supplement Purchase Burn Evolved Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseBurnEvolvedTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    BurnUpsellLifetime201908Page burnUpSlPg;
    BurnDownsellLifetime201908Page burnDwnSlPg;
    BurnCross2Lifetime201908Page burnCrss2Pg;
    TurmericCsVsPage trmrcCsVsPg;
    CouponGreensV2F217Page cupnGrnsPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        burnUpSlPg = new BurnUpsellLifetime201908Page(driver);
        burnDwnSlPg = new BurnDownsellLifetime201908Page(driver);
        burnCrss2Pg = new BurnCross2Lifetime201908Page(driver);
        trmrcCsVsPg = new TurmericCsVsPage(driver);
        cupnGrnsPg = new CouponGreensV2F217Page(driver);
    }

    @Description("Verify BCAAs -supplement purchase no upsell")
    @Test()//UUID=6726E6FC-9718-4DDF-BA2F-8A3C17944AB7
    public void purchaseBurnEvolvedSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
//        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("burn-evolved");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/burn-evolved");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickSpeedUpMyMetabolismLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=burn-us-burnFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        burnUpSlPg.verifyCurrentPageURLEndsWith("/fl-burn-burn-lg-us-v2?f=34");
        burnUpSlPg.verifyBurnUpsellVideoIsDisplayed();
        burnUpSlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnUpSlPg.scrollToBottomOfPageByKeys();
        burnUpSlPg.clickYesUpgradeButton();
        burnDwnSlPg.verifyCurrentPageURLEndsWith("/burn-ds?f=35");
        burnDwnSlPg.verifyBurnDownsellVideoIsDisplayed();
        burnDwnSlPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnDwnSlPg.scrollToBottomOfPageByKeys();
        burnDwnSlPg.clickYesUpgradeButton();
        burnCrss2Pg.verifyCurrentPageURLEndsWith("/burn-lg-cs1-v1?f=36");
        burnCrss2Pg.verifyBurnCross2VideoIsDisplayed();
        burnCrss2Pg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        burnCrss2Pg.scrollToBottomOfPageByKeys();
        burnCrss2Pg.clickOneTimeDeliveryPriceLabel();
        burnCrss2Pg.clickAddToCartLinkByIndex(0);
        trmrcCsVsPg.verifyCurrentPageURLEndsWith("/turmeric-cs?f=37");
        trmrcCsVsPg.verifyTurmericCsVsPgVideoIsDisplayed();
        trmrcCsVsPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickCopyRightLogo();
        trmrcCsVsPg.clickOneTimeDeliveryPriceLabel();
        trmrcCsVsPg.clickAddToCartLinkByIndex(0);
        cupnGrnsPg.verifyCurrentPageURLEndsWith("/coupon-greens-v2?f=217");
        cupnGrnsPg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$411.95");
    }
}
