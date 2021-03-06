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
@Story("Supplement Purchase Creatine Fruit Punch No Upsell Test")
@Listeners( framework.testng.AllureScreenshots.class )
public class CreatineFruitPunchNoUpsellTest extends BaseTest {

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

    @Description("Verify Creatine Fruit Punch supplement No Upsell purchase")
    @Test()//UUID=AFFB0D9D-2E3C-4809-95DE-2FB9C7880BA6
    public void purchaseCreatineFruitPunchSupplementNoUpsell() throws Exception {

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
        crtnSlsFunlPg.pageDownByKeys();
        crtnSlsFunlPg.clickNoThanksRedLink();
        crtnSlsFunlPg.verifyCurrentPageURLEndsWith("/creatine-ds?f=113");
        crtnSlsFunlPg.verifyCreatine113Pg3BottleImageIsDisplayed();
        crtnSlsFunlPg.scrollToBottomOfPageByKeys();
        crtnSlsFunlPg.pageUpByKeys();
        crtnSlsFunlPg.clickNoThanksRedLink();
        bcaasSlsFunlPg.verifyCurrentPageURLEndsWith("/bcaa-cs?f=114");
        bcaasSlsFunlPg.verifyBcaas114Pg3BottleImageIsDisplayed();
        bcaasSlsFunlPg.scrollToBottomOfPageByKeys();
        bcaasSlsFunlPg.pageUpByKeys();
        bcaasSlsFunlPg.clickNoThanksRedLink2();
        prtnSlsFunlPg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=115");
        prtnSlsFunlPg.verifyProtein115Pg3BottleImageIsDisplayed();
        prtnSlsFunlPg.scrollToBottomOfPageByKeys();
        prtnSlsFunlPg.pageUpByKeys();
        prtnSlsFunlPg.clickNoThanksRedLink2();
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$46.95");
    }
}
