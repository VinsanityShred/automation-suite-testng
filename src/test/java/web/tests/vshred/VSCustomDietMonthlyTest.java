package web.tests.vshred;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.vshred.*;
import web.tests.PurchaseTestBase;

@Feature("Purchase")
@Story("Special custom diet plan monthly test")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSCustomDietMonthlyTest extends PurchaseTestBase {
    @Description("Verify Purchase New Custom Diet Plan Monthly")
    @Test(priority = 0)
    public void purchaseNewCustomDietPlanMonthlyTest() throws Exception {
        // Going directly to custom plan page, so don't need to call loginMember();

        purchaseVSPlan(Plan.CUSTOM_DIET_MONTHLY);

        completeCustomDietPlanMonthlyOrderForm();

        processPostSubmissionPages(Plan.CUSTOM_DIET_MONTHLY);

        VshredOrderConfirmPage.verifyVSOrderConfirmPage();
    }
}
