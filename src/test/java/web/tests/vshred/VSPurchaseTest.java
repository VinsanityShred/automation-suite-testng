package web.tests.vshred;

import framework.Auth;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import web.pages.vshred.*;
import web.tests.BaseTest;

@Feature("Purchase")
@Story("Purchase and finance tests")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSPurchaseTest extends BaseTest {

    private WebDriver driver;

    public static final int PLAN_BIG_ARMS = 1;
    public static final int PLAN_FAT_LOSS_EXTREME_HIM = 2;
    // public static final int PLAN_FAT_LOSS_EXTREME_HER = 3; // **NOTE**: post order offer one page different than above programs

    @BeforeMethod
    public void setUp() {
        driver = getDriver();

        VshredLoginPage.createLoginPage(driver);
        VshredHomePage.createVSHomePage(driver);
        VshredMemberHomePage.createVSMemberHomePage(driver);
        VshredProgramsPage.createVSProgramsPage(driver);
        VshredBigArmsProgramPage.createVSBigArmsPage(driver);
        VshredFatLossExtremeHimProgramPage.createVSFatLossExtremeHimPage(driver);
        //VshredFatLossExtremeHerProgramPage.createVSFatLossExtremeHerPage(driver); // **NOTE**: post order offer one page different than above programs
        VshredOrderFormPage.createVSOrderFormPage(driver);
        VshredPostOrderOffer_1.createVSPostOrderOfferOne(driver);
        VshredPostOrderOffer_2.createVSPostOrderOfferTwo(driver);
        VshredOrderConfirmPage.createVSOrderConfirmPage(driver);
        VshredProgramQuestionnairePage.createVSQuestionnairePage(driver);
    }

    public void purchaseNewPlanTest(int aPlan) throws Exception {
        // Test purchase of new plan (TT-46)
        // Expected result: Login and plan purchase successful
        VshredLoginPage.verifyLoginPage();
        VshredLoginPage.loginUserPassword(Auth.validMemberUserEmail(), Auth.validMemberUserPassword());

        VshredMemberHomePage.verifyVSMemberHomePage();
        VshredMemberHomePage.vsMemberHomePage.clickProgramsLink();


        switch (aPlan) {
            case PLAN_BIG_ARMS:
                VshredProgramsPage.vsProgramsPage.verifyBigArmsProgramIsDisplayed();
                VshredProgramsPage.vsProgramsPage.clickBigArmsProgram();
                VshredBigArmsProgramPage.verifyVSBigArmsPage();
                VshredBigArmsProgramPage.vsBigArmsPage.clickPurchaseButton();
                break;
            case PLAN_FAT_LOSS_EXTREME_HIM:
                VshredProgramsPage.vsProgramsPage.verifyFatLossExtremeHimProgramIsDisplayed();
                VshredProgramsPage.vsProgramsPage.clickFatLossExtremeHimProgram();
                VshredFatLossExtremeHimProgramPage.verifyVSFatLossExtremeHimPage();
                VshredFatLossExtremeHimProgramPage.vsFatLossExtremeHimPage.clickPurchaseButton();
                break;
            /*case PLAN_FAT_LOSS_EXTREME_HER:  // **NOTE**: post order offer one page different than above programs
                VshredProgramsPage.vsProgramsPage.verifyFatLossExtremeHerProgramIsDisplayed();
                VshredProgramsPage.vsProgramsPage.clickFatLossExtremeHerProgram();
                VshredFatLossExtremeHerProgramPage.verifyVSFatLossExtremeHerPage();
                VshredFatLossExtremeHerProgramPage.vsFatLossExtremeHerPage.clickPurchaseButton();
                break;*/
            default:
                System.out.println("VSPurchaseTest.java: purchaseNewPlanTest: Invalid plan case value " + aPlan);
        }

        VshredOrderFormPage.verifyVSOrderFormPage();
        VshredOrderFormPage.vsOrderFormPage.completeContactInfoAndNext();
        VshredOrderFormPage.vsOrderFormPage.completePaymentDetailsAndNext();
        VshredOrderFormPage.vsOrderFormPage.submitOrder();

        VshredPostOrderOffer_1.verifyVSPostOrderOfferOnePage();
        VshredPostOrderOffer_1.vsPostOrderOfferOne.clickNoThanks();

        VshredPostOrderOffer_2.verifyVSPostOrderOfferTwoPage();
        VshredPostOrderOffer_2.vsPostOrderOfferTwo.clickNoThanks();

        VshredOrderConfirmPage.verifyVSOrderConfirmPage();

        /* // **NOTE**: Questionnaire complex, so to be executed as a separate test
        VshredOrderConfirmPage.vsOrderConfirmPage.clickQuestionnaireButton();

        VshredProgramQuestionnairePage.verifyVSQuestionnairePage();
        VshredProgramQuestionnairePage.vsQuestionnairePage.fillInRequiredData();
        VshredProgramQuestionnairePage.vsQuestionnairePage.agreeToTermsConditions();
        VshredProgramQuestionnairePage.vsQuestionnairePage.clickSubmitButton();
        */
    }

    @Description("Verify Purchase New Big Arms Plan")
    @Test(priority = 0)
    public void purchaseNewBigArmsPlanTest() throws Exception {
        purchaseNewPlanTest(PLAN_BIG_ARMS);
    }

    @Test(priority = 1)
    public void purchaseNewFatLossHimPlanTest() throws Exception {
        purchaseNewPlanTest(PLAN_FAT_LOSS_EXTREME_HIM);
    }

    /*@Test(priority = 2) // **NOTE**: post order offer one page different than above programs
    public void purchaseNewFatLossHerPlanTest() throws Exception {
        purchaseNewPlanTest(PLAN_FAT_LOSS_EXTREME_HER);
    }*/
}
