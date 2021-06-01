package web.tests.vshred;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.vshred.*;
import web.tests.PurchaseTestBase;

@Feature("Purchase")
@Story("Special 5K platinum coaching plan test")
@Listeners( framework.testng.AllureScreenshots.class )
public class VS5KPlatinumCoachingTest extends PurchaseTestBase {
    @Description("Verify Purchase New 5K Platinum Coaching Plan Monthly")
    @Test(priority = 0)
    public void purchaseNew5KPlatinumCoachingPlanTest() throws Exception {
        // Going directly to custom plan page, so don't need to call loginMember();

        purchaseVSPlan(Plan.PLATINUM_COACHING);

        completePlatinumCoachingPlanOrderForm();

        processPostSubmissionPages(Plan.PLATINUM_COACHING);

        VshredOrderConfirmPage.verifyVSOrderConfirmPage();
    }
}
