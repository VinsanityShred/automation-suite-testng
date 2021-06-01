package web.tests.vshred;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.vshred.*;
import web.tests.PurchaseTestBase;

@Feature("Purchase")
@Story("Special platinum coaching plan test")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSPlatinumCoachingTest extends PurchaseTestBase {
    @Description("Verify Purchase New Platinum Coaching Plan")
    @Test(priority = 0)
    public void purchaseNewPlatinumCoachingPlanTest() throws Exception {
        // Going directly to custom plan page, so don't need to call loginMember();

        purchaseVSPlan(Plan.PLATINUM_COACHING);

        completePlatinumCoachingPlanOrderForm();

        processPostSubmissionPages(Plan.PLATINUM_COACHING);

        VshredOrderConfirmPage.verifyVSOrderConfirmPage();
    }
}
