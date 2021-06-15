package web.tests.vshred;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.vshred.*;
import web.tests.PurchaseTestBase;

@Feature("Purchase")
@Story("Special custom diet plan test")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSCustomDietTest extends PurchaseTestBase {
    @Description("Verify Purchase New Custom Diet Plan")
    @Test(priority = 0)
    public void purchaseNewCustomDietPlanTest() throws Exception {
        // Going directly to custom plan page, so don't need to call loginMember();

        purchaseVSPlan(PurchaseTestBase.Plan.CUSTOM_DIET_PLAN);

        completeCustomDietPlanOrderForm();

        processPostSubmissionPages(PurchaseTestBase.Plan.CUSTOM_DIET_PLAN);

        VshredOrderConfirmPage.verifyVSOrderConfirmPage();
    }
}
