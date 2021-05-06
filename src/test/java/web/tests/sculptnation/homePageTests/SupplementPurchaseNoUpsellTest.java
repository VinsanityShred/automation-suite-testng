package web.tests.sculptnation.homePageTests;

import framework.utility.Util;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.CartPage;
import web.pages.sculptnation.CheckoutPage;
import web.pages.sculptnation.SNLandingPage;
import web.pages.sculptnation.productPages.BcaasProductPage;
import web.tests.BaseTest;

@Feature("Home Page Tests")
@Story("Supplement Purchase No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseNoUpsellTest extends BaseTest {

    SNLandingPage sNLndPg;
    BcaasProductPage bcaasPg;
    CartPage crtPg;
    CheckoutPage chckPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        bcaasPg = new BcaasProductPage(driver);
        crtPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
    }

    @Description("Verify supplement purchase no upsell")
    @Test()//UUID=03E0CE50-C719-463C-B2AF-E0A53F356C78
    public void purchaseBCAAsSupplement() throws Exception {


        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickProductSupplement("bcaas");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/bcaas");
        bcaasPg.clickBuyNowButton();
        bcaasPg.clickOneTimeDeliveryPriceLabel();
        bcaasPg.clickAddToCartLinkByIndex(0);
        crtPg.verifyCurrentPageURLEndsWith("/cart?funnel=bcaa-us-bcaaFunnel");
        crtPg.verifyCartTableIsDisplayed();
        crtPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        Util.waitMilliseconds(5000000);
    }


}
