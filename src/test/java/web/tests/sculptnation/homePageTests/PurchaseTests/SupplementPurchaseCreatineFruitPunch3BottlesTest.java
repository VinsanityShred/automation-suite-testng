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
@Story("Supplement Purchase Creatine Fruit Punch 3 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseCreatineFruitPunch3BottlesTest extends BaseTest {

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

    @Description("Verify Creatine Fruit Punch supplement 3 Bottles purchase")
    @Test()//UUID=EE2E587F-3C34-40BF-B41A-2A83FAF32F61
    public void purchaseCreatineFruitPunchSupplement3Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("creatine");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/creatine");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(2);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=creatine-us-creatineFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        crtnSlsFunlPg.verifyCurrentPageURLEndsWith("/creatine-us?f=112");
        crtnSlsFunlPg.verifyCreatineHeaderTextIsAMatch();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        crtnSlsFunlPg.pageUpByKeys();
        crtnSlsFunlPg.clickYesUpgradeButton();
        bcaasSlsFunlPg.verifyCurrentPageURLEndsWith("/bcaa-cs?f=114");
        bcaasSlsFunlPg.verifyBcaas114Pg3BottleImageIsDisplayed();
        bcaasSlsFunlPg.scrollToBottomOfPageByKeys();
        bcaasSlsFunlPg.pageUpByKeys();
        bcaasSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        bcaasSlsFunlPg.clickAddToCartLinkByIndex(2);
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=115");
        prtnSlsFunlPg.verifyProtein115Pg3BottleImageIsDisplayed();
        prtnSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnSlsFunlPg.pageUpByKeys();
        prtnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prtnSlsFunlPg.clickAddToCartLinkByIndex(2);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$471.95");
    }
}