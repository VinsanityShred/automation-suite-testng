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
@Story("Supplement Purchase Creatine Fruit Punch Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseCreatineFruitPunchTest extends BaseTest {

    SNLandingPage sNLndPg;
    CartPage cartPg;
    CheckoutPage chckPg;
    ReceiptPage RcptPg;
    CreatineSalesFunnelPage crtnSlsFunlPg;
    BcaasSalesFunnelPage bcaasSlsFunlPg;
    ProteinSalesFunnelPage prtnSlsFunlPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        crtnSlsFunlPg = new CreatineSalesFunnelPage(driver);
        bcaasSlsFunlPg = new BcaasSalesFunnelPage(driver);
        prtnSlsFunlPg = new ProteinSalesFunnelPage(driver);
    }

    @Description("Verify Creatine Fruit Punch supplement purchase")
    @Test()//UUID=17E9586F-D713-4E91-ADEF-FE24D7297987
    public void purchaseCreatineFruitPunchSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("creatine");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/creatine");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(0);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=creatine-us-creatineFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        crtnSlsFunlPg.verifyCurrentPageURLEndsWith("/creatine-us?f=112");
        crtnSlsFunlPg.verifyCreatineHeaderTextIsAMatch();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        crtnSlsFunlPg.clickYesUpgradeButton();
        bcaasSlsFunlPg.verifyBcaasImageIsDisplayed();
        bcaasSlsFunlPg.scrollToBottomOfPageByKeys();
        bcaasSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        bcaasSlsFunlPg.clickAddToCartLinkByIndex(0);
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=115");
        prtnSlsFunlPg.verifyProteinChocolateImageIsDisplayed();
        prtnSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prtnSlsFunlPg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$274.95");
    }
}