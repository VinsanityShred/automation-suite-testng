package web.tests.sculptnation.homePageTests.PurchaseTests;

import framework.utility.Util;
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
@Story("Supplement Purchase Creatine Fruit Punch Subscription Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseCreatineFruitPunchSubscriptionTest extends BaseTest {

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

    @Description("Verify Creatine Fruit Punch supplement Subscription purchase")
    @Test()//UUID=1E7F6100-2E28-4AE1-A35B-AC420E845D43
    public void purchaseCreatineFruitPunchSupplementSubscription() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("creatine");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/creatine");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickSubscribeNowButton();
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=bcaa-cs-creatineFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        bcaasSlsFunlPg.verifyCurrentPageURLEndsWith("/bcaa-cs?f=114");
        bcaasSlsFunlPg.verifyBcaas114Pg3BottleImageIsDisplayed();
        bcaasSlsFunlPg.scrollToBottomOfPageByKeys();
        bcaasSlsFunlPg.pageDownByKeys();
        bcaasSlsFunlPg.clickSubscribeNowButton();
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=115");
        prtnSlsFunlPg.verifyProtein115Pg3BottleImageIsDisplayed();
        prtnSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnSlsFunlPg.pageUpByKeys();
        prtnSlsFunlPg.clickSubscribeNowButton();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$113.95");
    }
}