package web.tests;

import framework.Auth;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import web.pages.vshred.*;
import web.tests.vshred.VSPurchaseTest;
import web.tests.*;

public class PurchaseTestBase extends BaseTest {
    private WebDriver driver;

    public enum Plan {
        BIG_ARMS,
        FAT_LOSS_EXTREME_HIM,
        FAT_LOSS_EXTREME_HER, // **NOTE**: post order offer one page different than above programs
        CUSTOM_DIET_PLAN,
        CUSTOM_DIET_MONTHLY,
        PLATINUM_COACHING,
        GOLD_COACHING,
        DIET_MULTI_WEEK,
    }

    @BeforeMethod
    public void setUp() {
        driver = getDriver();

        VshredLoginPage.createLoginPage(driver);
        VshredHomePage.createVSHomePage(driver);
        VshredMemberHomePage.createVSMemberHomePage(driver);
        VshredMemberProfilePage.createVSMemberProfilePage(driver);
        VshredProgramsPage.createVSProgramsPage(driver);
        VshredBigArmsProgramPage.createVSBigArmsPage(driver);
        VshredFatLossExtremeHimProgramPage.createVSFatLossExtremeHimPage(driver);
        VshredFatLossExtremeHerProgramPage.createVSFatLossExtremeHerPage(driver); // **NOTE**: post order offer one page different than above programs
        VshredOrderFormPage.createVSOrderFormPage(driver);
        VshredPostOrderOffer_1.createVSPostOrderOfferOne(driver);
        VshredPostOrderOffer_2.createVSPostOrderOfferTwo(driver);
        VshredPostOrderOffer_3.createVSPostOrderOfferThree(driver);
        VshredOrderConfirmPage.createVSOrderConfirmPage(driver);
        VshredProgramQuestionnairePage.createVSQuestionnairePage(driver);
        VshredOrderFormPlatinumCoachingPage.createVSPlatinumCoachingOrderFormPage(driver);
        VshredOrderFormGoldCoachingPage.createVSGoldCoachingOrderFormPage(driver);
    }

    //// Methods ////
    public void loginMember() throws Exception {
        VshredLoginPage.verifyLoginPage();
        VshredLoginPage.loginUserPassword(Auth.validMemberUserEmail(), Auth.validMemberUserPassword());
        VshredMemberHomePage.verifyVSMemberHomePage();
    }

    public void purchaseVSPlan(PurchaseTestBase.Plan aPlan) throws Exception {
        switch (aPlan) {
            case BIG_ARMS:
                VshredProgramsPage.vsProgramsPage.verifyBigArmsProgramIsDisplayed();
                VshredProgramsPage.vsProgramsPage.clickBigArmsProgram();
                VshredBigArmsProgramPage.verifyVSBigArmsPage();
                VshredBigArmsProgramPage.vsBigArmsPage.clickPurchaseButton();
                break;
            case FAT_LOSS_EXTREME_HIM:
                VshredProgramsPage.vsProgramsPage.verifyFatLossExtremeHimProgramIsDisplayed();
                VshredProgramsPage.vsProgramsPage.clickFatLossExtremeHimProgram();
                VshredFatLossExtremeHimProgramPage.verifyVSFatLossExtremeHimPage();
                VshredFatLossExtremeHimProgramPage.vsFatLossExtremeHimPage.clickPurchaseButton();
                break;
            case FAT_LOSS_EXTREME_HER:
                VshredProgramsPage.vsProgramsPage.verifyFatLossExtremeHerProgramIsDisplayed();
                VshredProgramsPage.vsProgramsPage.clickFatLossExtremeHerProgram();
                VshredFatLossExtremeHerProgramPage.verifyVSFatLossExtremeHerPage();
                VshredFatLossExtremeHerProgramPage.vsFatLossExtremeHerPage.clickPurchaseButton();
                break;
            case CUSTOM_DIET_PLAN:
            case CUSTOM_DIET_MONTHLY:
            case PLATINUM_COACHING:
            case GOLD_COACHING:
            case DIET_MULTI_WEEK:
                // NOTE: Going direct to URL that is the order form, so no verify of program page or click of purchase button
                break;
            default:
                System.out.println("VSPurchaseTest.java: purchaseVSPlan: Invalid plan case value " + aPlan);
        }
    }

    public void completeOrderForm() throws Exception {
        VshredOrderFormPage.verifyVSOrderFormPage();
        VshredOrderFormPage.vsOrderFormPage.completeContactInfoAndNext();
        VshredOrderFormPage.vsOrderFormPage.completePaymentDetailsAndNext();
        VshredOrderFormPage.vsOrderFormPage.submitOrder();
    }

    public void completeCustomDietPlanOrderForm() throws Exception {
        VShredOrderFormCustomDietPage.verifyVSOrderFormPage();
        VShredOrderFormCustomDietPage.vsOrderFormPage.completeContactInfoAndNext();
        VShredOrderFormCustomDietPage.vsOrderFormPage.completeCustomDietPaymentDetailsAndNext();
        VShredOrderFormCustomDietPage.vsOrderFormPage.submitOrder();
    }

    public void completeCustomDietPlanMonthlyOrderForm() throws Exception {
        VShredOrderFormCustomDietMonthlyPage.verifyVSOrderFormPage();
        VShredOrderFormCustomDietMonthlyPage.vsOrderFormPage.completeCustomDietMonthlyContactInfoAndNext();
        VShredOrderFormCustomDietMonthlyPage.vsOrderFormPage.completeCustomDietMonthlyPaymentDetailsAndNext();
        VShredOrderFormCustomDietMonthlyPage.vsOrderFormPage.submitOrder();
    }

    public void completePlatinumCoachingPlanOrderForm() throws Exception {
        VshredOrderFormPlatinumCoachingPage.verifyVSOrderFormPage();
        VshredOrderFormPlatinumCoachingPage.vsOrderFormPage.completeContactInfoAndNext();
        VshredOrderFormPlatinumCoachingPage.vsOrderFormPage.completePlatinumCoachingPaymentDetailsAndNext();
        // Check box to agree to terms
        VshredOrderFormPlatinumCoachingPage.vsPlatinumCoachingOrderFormPage.clickAgreeToTermsAndConditions();
        VshredOrderFormPlatinumCoachingPage.vsOrderFormPage.submitOrder();
    }

    public void completeGoldCoachingPlanOrderForm() throws Exception {
        VshredOrderFormGoldCoachingPage.verifyVSOrderFormPage();
        VshredOrderFormGoldCoachingPage.vsOrderFormPage.completeContactInfoAndNext();
        VshredOrderFormGoldCoachingPage.vsOrderFormPage.completeGoldCoachingPaymentDetailsAndNext();
        // Check box to agree to terms
        VshredOrderFormGoldCoachingPage.vsGoldCoachingOrderFormPage.clickAgreeToTermsAndConditions();
        VshredOrderFormGoldCoachingPage.vsOrderFormPage.submitOrder();
    }

    public void processPostSubmissionPages(PurchaseTestBase.Plan aPlan) throws Exception {
        switch (aPlan) {
            case BIG_ARMS:
            case FAT_LOSS_EXTREME_HIM:
                VshredPostOrderOffer_1.verifyVSPostOrderOfferOnePage();
                VshredPostOrderOffer_1.vsPostOrderOfferOne.clickNoThanks();
                break;
            case FAT_LOSS_EXTREME_HER: // TODO: Need to create method to specify unique offer 1 locators for this plan to work
                VshredPostOrderOffer_1.verifyVSPostOrderOfferOnePage();
                VshredPostOrderOffer_1.vsPostOrderOfferOne.clickNoThanks();
                break;
            case CUSTOM_DIET_PLAN:
            case CUSTOM_DIET_MONTHLY:
            case PLATINUM_COACHING:
            case GOLD_COACHING:
            case DIET_MULTI_WEEK:
                break; // Post order offer 1 does not appear for this plan
            default:
                System.out.println("VSPurchaseTest.java: processPostSubmissionPages: Invalid plan case value " + aPlan);
        }


        //VshredPostOrderOffer_2.verifyVSPostOrderOfferTwoPage();
        //VshredPostOrderOffer_2.vsPostOrderOfferTwo.clickNoThanks();

        switch (aPlan) {
            case BIG_ARMS:
            case FAT_LOSS_EXTREME_HIM:
                VshredPostOrderOffer_3.verifyVSPostOrderOfferThreePage();
                VshredPostOrderOffer_3.vsPostOrderOfferThree.clickNoThanks();
                break;
            case CUSTOM_DIET_PLAN:
            case CUSTOM_DIET_MONTHLY:
            case PLATINUM_COACHING:
            case GOLD_COACHING:
            case DIET_MULTI_WEEK:
                break; // Post order offer 3 does not appear for this plan
            default:
                System.out.println("VSPurchaseTest.java: processPostSubmissionPages: Invalid plan case value " + aPlan);
        }
    }

    public void purchaseNewPlanTest(PurchaseTestBase.Plan aPlan) throws Exception {
        // Test purchase of new plan (TT-46)
        // Expected result: Login and plan purchase successful
        loginMember();

        VshredMemberHomePage.vsMemberHomePage.clickProgramsLink();

        purchaseVSPlan(aPlan);

        completeOrderForm();

        processPostSubmissionPages(aPlan);

        VshredOrderConfirmPage.verifyVSOrderConfirmPage();
    }
}
