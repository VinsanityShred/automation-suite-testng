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
    CreatineUsF112Page crtnUs112Pg;
    BcaaCsF114Page bcaaCs114Pg;
    ProteinMultiCsF115Page PrtnMultCs115Pg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        chckPg = new CheckoutPage(driver);
        RcptPg = new ReceiptPage(driver);
        crtnUs112Pg = new CreatineUsF112Page(driver);
        bcaaCs114Pg = new BcaaCsF114Page(driver);
        PrtnMultCs115Pg = new ProteinMultiCsF115Page(driver);
    }

    @Description("Verify Creatine Fruit Punch supplement purchase")
    @Test()//UUID=17E9586F-D713-4E91-ADEF-FE24D7297987
    public void purchaseCreatineFruitPunchSupplement() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
//        sNLndPg.closeDiscountModal();
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
        crtnUs112Pg.verifyCurrentPageURLEndsWith("/creatine-us?f=112");
        crtnUs112Pg.verifyCreatineHeaderTextIsAMatch();
        crtnUs112Pg.scrollToBottomOfPageByKeys();
        crtnUs112Pg.clickYesUpgradeButton();
        bcaaCs114Pg.verifyBcaasImageIsDisplayed();
        bcaaCs114Pg.scrollToBottomOfPageByKeys();
        bcaaCs114Pg.clickOneTimeDeliveryPriceLabel();
        bcaaCs114Pg.clickAddToCartLinkByIndex(0);
        PrtnMultCs115Pg.verifyCurrentPageURLEndsWith("/protein-multi-cs?f=115");
        PrtnMultCs115Pg.verifyProteinChocolateImageIsDisplayed();
        PrtnMultCs115Pg.scrollToBottomOfPageByKeys();
        PrtnMultCs115Pg.clickOneTimeDeliveryPriceLabel();
        PrtnMultCs115Pg.clickAddToCartLinkByIndex(0);
        RcptPg.verifyCurrentPageURLEndsWith("/receipt");
        RcptPg.verifyReceiptPgHeaderIsDisplayed();
        RcptPg.verifyReceiptPgTotalsMatch("$274.95");
    }
}
