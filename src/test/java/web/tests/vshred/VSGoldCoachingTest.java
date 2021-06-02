package web.tests.vshred;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.vshred.VshredOrderConfirmPage;
import web.tests.PurchaseTestBase;

@Feature("Purchase")
@Story("Special gold coaching plan test")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSGoldCoachingTest extends PurchaseTestBase {
    @Description("Verify Purchase New Gold Coaching Plan")
    @Test(priority = 0)
    public void purchaseNewGoldCoachingPlanTest() throws Exception {
        // Going directly to custom plan page, so don't need to call loginMember();

        purchaseVSPlan(Plan.GOLD_COACHING);

        completeGoldCoachingPlanOrderForm();

        processPostSubmissionPages(Plan.GOLD_COACHING);

        VshredOrderConfirmPage.verifyVSOrderConfirmPage();
    }
}
