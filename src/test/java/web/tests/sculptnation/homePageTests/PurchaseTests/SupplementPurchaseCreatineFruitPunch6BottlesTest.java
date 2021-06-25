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
@Story("Supplement Purchase Creatine Fruit Punch 6 Bottles Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SupplementPurchaseCreatineFruitPunch6BottlesTest extends BaseTest {

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

    @Description("Verify Creatine Fruit Punch supplement 6 Bottles purchase")
    @Test()//UUID=784BD9E5-6C93-407E-B148-8ABD5ECEAF0E
    public void purchaseCreatineFruitPunchSupplement6Bottles() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickOKButton();
        sNLndPg.clickProductSupplement("creatine");
        sNLndPg.verifyCurrentPageURLEndsWith("/products/creatine");
        sNLndPg.clickBuyNowButton();
        sNLndPg.clickOneTimeDeliveryPriceLabel();
        sNLndPg.clickAddToCartLinkByIndex(1);
        cartPg.verifyCurrentPageURLEndsWith("/cart?funnel=bcaa-cs-creatineFunnel");
        cartPg.verifyCartTableIsDisplayed();
        cartPg.clickProceedToCheckoutButton();
        chckPg.verifyCurrentPageURLEndsWith("/checkout");
        chckPg.setCheckoutField();
        chckPg.clickPlaceOrderButton();
        bcaasSlsFunlPg.verifyCurrentPageURLEndsWith("/bcaa-cs?f=114");
        bcaasSlsFunlPg.verifyBcaas114Pg3BottleImageIsDisplayed();
        bcaasSlsFunlPg.scrollToBottomOfPageByKeys();
        bcaasSlsFunlPg.pageUpByKeys();
        bcaasSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        bcaasSlsFunlPg.clickAddToCartLinkByIndex(1);
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=115");
        prtnSlsFunlPg.verifyProtein115Pg3BottleImageIsDisplayed();
        prtnSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnSlsFunlPg.pageUpByKeys();
        prtnSlsFunlPg.clickOneTimeDeliveryPriceLabel();
        prtnSlsFunlPg.clickAddToCartLinkByIndex(1);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$603.95");
    }
}