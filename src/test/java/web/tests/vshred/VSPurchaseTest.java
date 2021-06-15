package web.tests.vshred;

import framework.Auth;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import web.pages.vshred.*;
import web.tests.BaseTest;
import web.tests.PurchaseTestBase;

@Feature("Purchase")
@Story("Purchase and finance tests")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSPurchaseTest extends PurchaseTestBase {
    @Description("Verify Purchase New Big Arms Plan")
    @Test(priority = 0)
    public void purchaseNewBigArmsPlanTest() throws Exception {
        purchaseNewPlanTest(PurchaseTestBase.Plan.BIG_ARMS);
    }

    @Description("Verify Purchase New Fat Loss Extreme for Him Plan")
    @Test(priority = 1)
    public void purchaseNewFatLossHimPlanTest() throws Exception {
        purchaseNewPlanTest(PurchaseTestBase.Plan.FAT_LOSS_EXTREME_HIM);
    }

    /*@Test(priority = 2) // **NOTE**: post order offer one page different than above programs
    // TODO: Enable this code once offer 1 page locators can be specified by plan
    public void purchaseNewFatLossHerPlanTest() throws Exception {
        purchaseNewPlanTest(Plan.FAT_LOSS_EXTREME_HER);
    }*/
}
