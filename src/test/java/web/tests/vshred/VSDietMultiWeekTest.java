package web.tests.vshred;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.vshred.VshredOrderConfirmPage;
import web.tests.PurchaseTestBase;

@Feature("Purchase")
@Story("Special diet multi-week plan test")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSDietMultiWeekTest extends PurchaseTestBase {
    @Description("Verify Purchase New Diet Multi-week Plan")
    @Test(priority = 0)
    public void purchaseNewDietMultiWeekPlanTest() throws Exception {
        // Going directly to custom plan page, so don't need to call loginMember();

        purchaseVSPlan(Plan.DIET_MULTI_WEEK);

        completeGoldCoachingPlanOrderForm();

        processPostSubmissionPages(Plan.DIET_MULTI_WEEK);

        VshredOrderConfirmPage.verifyVSOrderConfirmPage();
    }
}
