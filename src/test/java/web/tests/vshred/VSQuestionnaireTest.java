package web.tests.vshred;

import framework.Auth;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.vshred.*;
import web.tests.BaseTest;

@Feature("Assigned Clients")
@Story("Questionnaire responses viewable and expected values")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSQuestionnaireTest extends BaseTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        VshredLoginPage.createLoginPage(driver);
        VshredAdminDashPage.createAdminDashPage(driver);
        VshredHomePage.createVSHomePage(driver);
        VshredMemberHomePage.createVSMemberHomePage(driver);
        VshredMemberProfilePage.createVSMemberProfilePage(driver);
        VshredQuestionnaireGoldPage.createVSQuestionnaireGoldPage(driver);
        VshredTrainerDashPage.createTrainerDashPage(driver);
        VshredTrainingMgrDashPage.createTrainingMgrDashPage(driver);
        VshredUserPage.createUserPage(driver);
    }

    //// Methods ////
    public void fillInQuestionnaireRequiredData() {
        VshredQuestionnaireGoldPage qGold;
        qGold = VshredQuestionnaireGoldPage.vsQuestionnaireGoldPage;

        // Fill in required fields with some arbitrary default values
        qGold.setFieldValue(qGold.vsGoldFirstNameFieldSelector, "First name", "Firstname");
        qGold.setFieldValue(qGold.vsGoldLastNameFieldSelector, "Last name", "Lastname");
        qGold.setFieldValue(qGold.vsGoldEmailFieldSelector, "E-mail", "email@email.com");
        qGold.setFieldValue(qGold.vsGoldDOBFieldSelector, "Date of birth", "01011970");
        qGold.setFieldValue(qGold.vsGoldCountryFieldSelector, "Country", "United States");
        qGold.setFieldValue(qGold.vsGoldPhoneNumFieldSelector, "Phone number", "7075551111");
        qGold.setDropdownValue(qGold.vsGoldHeightFeetFieldSelector, "Height feet", "5");
        qGold.setDropdownValue(qGold.vsGoldHeightInchFieldSelector, "Height inch", "11");
        qGold.setFieldValue(qGold.vsGoldWeightFieldSelector, "Weight value", "155");
        qGold.setCheckboxValue(qGold.vsGoldWeightLBCheckboxSelector, "Weight LB checkbox", true);
        qGold.setFieldValue(qGold.vsGoldMostFavFoodsFieldSelector, "Most Favorite foods", "Chocolate");
        qGold.setFieldValue(qGold.vsGoldLeastFavFoodsFieldSelector, "Least Favorite foods", "Brussels sprouts");
        qGold.setFieldValue(qGold.vsGoldFoodsNotEatFieldSelector, "Not To Be Eaten Foods", "Broccoli");
        qGold.setCheckboxValue(qGold.vsGoldFoodAllergiesYesFieldSelector, "Yes Food Allergies checkbox", true);
        qGold.setFieldValue(qGold.vsGoldFoodAllergiesListFieldSelector, "Foods allergic to", "Shellfish");
        qGold.setFieldValue(qGold.vsGoldMostImportantHelpToGoalsFieldSelector, "Help to achieve goals", "Keep me accountable");
        qGold.setFieldValue(qGold.vsGoldHoursSleepPerNightFieldSelector, "Hours sleep per night", "6");
        qGold.setFieldValue(qGold.vsGoldBiggestStressFactorsFieldSelector, "Biggest stress factors", "finances, time");
        //qGold.setFieldValue(qGold.vsInjuryListFieldSelector, "Injury list", "low back, left knee");
        qGold.setFieldValue(qGold.vsGoldHealthConditionsFieldSelector, "Health conditions", "high blood pressure");
        qGold.setFieldValue(qGold.vsGoldHowHearAboutUsFieldSelector, "How heard about VShred", "friend recommendation");
        qGold.setFieldValue(qGold.vsGoldDecidingFactorFieldSelector, "Deciding factors", "good reputation, friend success");
    }

    public void fillInChangedRequiredData() {
        VshredQuestionnaireGoldPage qGold;
        qGold = VshredQuestionnaireGoldPage.vsQuestionnaireGoldPage;

        // Fill in required fields with values different than the defaults used in fillInDefaultRequiredData method
        qGold.setFieldValue(qGold.vsGoldFirstNameFieldSelector, "First name", "FirstnameTwo");
        qGold.setFieldValue(qGold.vsGoldLastNameFieldSelector, "Last name", "LastnameTwo");
        qGold.setFieldValue(qGold.vsGoldEmailFieldSelector, "E-mail", "emailTwo@email.com");
        qGold.setFieldValue(qGold.vsGoldDOBFieldSelector, "Date of birth", "01011972");
        qGold.setFieldValue(qGold.vsGoldCountryFieldSelector, "Country", "United States of America");
        qGold.setFieldValue(qGold.vsGoldPhoneNumFieldSelector, "Phone number", "7075552222");
        qGold.setDropdownValue(qGold.vsGoldHeightFeetFieldSelector, "Height feet", "6");
        qGold.setDropdownValue(qGold.vsGoldHeightInchFieldSelector, "Height inch", "2");
        qGold.setFieldValue(qGold.vsGoldWeightFieldSelector, "Weight value", "85");
        // Change pounds to kilograms
        qGold.setCheckboxValue(qGold.vsGoldWeightLBCheckboxSelector, "Weight LB checkbox", false);
        qGold.setCheckboxValue(qGold.vsGoldWeightKGCheckboxSelector, "Weight KB checkbox", true);
        qGold.setFieldValue(qGold.vsGoldMostFavFoodsFieldSelector, "Most Favorite foods", "Beer");
        qGold.setFieldValue(qGold.vsGoldLeastFavFoodsFieldSelector, "Least Favorite foods", "Broccoli");
        qGold.setFieldValue(qGold.vsGoldFoodsNotEatFieldSelector, "Not To Be Eaten Foods", "Brussels Sprouts");
        // Change food allergies from yes to no
        qGold.setCheckboxValue(qGold.vsGoldFoodAllergiesYesFieldSelector, "Yes Food Allergies checkbox", false);
        qGold.setCheckboxValue(qGold.vsGoldFoodAllergiesNoFieldSelector, "No Food Allergies checkbox", true);
        qGold.setFieldValue(qGold.vsGoldFoodAllergiesListFieldSelector, "Foods allergic to", "N/A");
        qGold.setFieldValue(qGold.vsGoldMostImportantHelpToGoalsFieldSelector, "Help to achieve goals", "Keep me healthy");
        qGold.setFieldValue(qGold.vsGoldHoursSleepPerNightFieldSelector, "Hours sleep per night", "8");
        qGold.setFieldValue(qGold.vsGoldBiggestStressFactorsFieldSelector, "Biggest stress factors", "pain, sleep");
        //qGold.setFieldValue(qGold.vsInjuryListFieldSelector, "Injury list", "low back, left knee");
        qGold.setFieldValue(qGold.vsGoldHealthConditionsFieldSelector, "Health conditions", "HBP, CVD");
        qGold.setFieldValue(qGold.vsGoldHowHearAboutUsFieldSelector, "How heard about VShred", "web search");
        qGold.setFieldValue(qGold.vsGoldDecidingFactorFieldSelector, "Deciding factors", "good rep, successes");
    }

    //// Tests ////
    @Description("Enter initial member questionnaire values")
    @Test(priority = 0)
    public void enterMemberInitialQuestionnaireValues() throws Exception {
        // Log in as member, and put in defaults for questionnaire, log out member
        VshredLoginPage.verifyLoginPage();
        VshredLoginPage.loginUserPassword(Auth.validMemberUserEmail(), Auth.validMemberUserPassword());
        VshredMemberHomePage.verifyVSMemberHomePage();
        // Click "Edit Profile", leading to profile screen
        VshredMemberHomePage.vsMemberHomePage.clickEditProfile();
        // On Profile screen, click "Fill Out Gold Coaching Questionnaire"
        VshredMemberProfilePage.vsMemberProfilePage.clickFillQuestionnaire();
        // Put in Questionnaire data
        VshredQuestionnaireGoldPage.verifyVSQuestionnaireGoldPage();
        fillInQuestionnaireRequiredData();
        //VshredQuestionnaireGoldPage.vsQuestionnaireGoldPage.fillInDefaultRequiredData();
        VshredQuestionnaireGoldPage.vsQuestionnaireGoldPage.agreeToTermsConditions();
        VshredQuestionnaireGoldPage.vsQuestionnaireGoldPage.clickSubmitButton();
        // Deal with pop-up confirming questionnaire submission
        VshredMemberProfilePage.vsMemberProfilePage.clearQuestionnaireSubmissionModal();
        // Log out member user
        VshredMemberProfilePage.vsMemberProfilePage.clickLogOut();
    }

    @Description("Verify initial member questionnaire values")
    @Test(priority = 1)
    public void confirmInitialQuestionnaireValues() throws Exception {
        VshredLoginPage.verifyLoginPage();
        VshredLoginPage.loginUserPassword(Auth.validTrainingMgrUserEmail(), Auth.validTrainingMgrUserPassword());

        VshredTrainingMgrDashPage.verifyTrainerDashPage();
        // Navigate to Trainer Tools->Assigned Clients in left menu
        VshredTrainingMgrDashPage.vsTrainingMgrPage.clickTrainerTool();
        VshredTrainingMgrDashPage.vsTrainingMgrPage.clickAssignedClients();
        // Wait for results of assigned clients table to fill in
        VshredTrainingMgrDashPage.vsTrainingMgrPage.waitForAssignedClientsResults();

        // Enter customer name search edit field text and hit Enter
        VshredTrainingMgrDashPage.vsTrainingMgrPage.searchCustomerName(Auth.validMemberUserName());
        // Wait for results of search
        VshredTrainingMgrDashPage.vsTrainingMgrPage.waitForAssignedClientsResults();

        // Click the first questionnaire access icon to open/view it
        VshredTrainingMgrDashPage.vsTrainingMgrPage.clickCustomerQuestionnaireIconLink();
        VshredTrainingMgrDashPage.vsTrainingMgrPage.verifyQuestionnaireModal();
        // Close questionnaire modal dialog window
        VshredTrainingMgrDashPage.vsTrainingMgrPage.clickQuestionnaireClose();

        // Logout trainer or training manager
        VshredTrainingMgrDashPage.vsTrainingMgrPage.userLogOut();
        // Confirm after logout that the VShred homepage displays
        VshredHomePage.verifyVSHomePage();
}

    @Description("Enter changed member questionnaire values")
    // TODO: Enable this test when TT-31 work begins
    //@Test(priority = 2)
    public void enterMemberChangedQuestionnaireValues() throws Exception {
        // Log in as member, and put in changed values for questionnaire, log out member
        VshredLoginPage.verifyLoginPage();
        VshredLoginPage.loginUserPassword(Auth.validMemberUserEmail(), Auth.validMemberUserPassword());
        VshredMemberHomePage.verifyVSMemberHomePage();
        // Click "Edit Profile", leading to profile screen
        VshredMemberHomePage.vsMemberHomePage.clickEditProfile();
        // On Profile screen, click "Fill Out Gold Coaching Questionnaire"
        VshredMemberProfilePage.vsMemberProfilePage.clickFillQuestionnaire();
        // Put in Questionnaire data
        VshredQuestionnaireGoldPage.verifyVSQuestionnaireGoldPage();
        fillInChangedRequiredData();
        //VshredQuestionnaireGoldPage.vsQuestionnaireGoldPage.fillInChangedRequiredData();
        VshredQuestionnaireGoldPage.vsQuestionnaireGoldPage.agreeToTermsConditions();
        VshredQuestionnaireGoldPage.vsQuestionnaireGoldPage.clickSubmitButton();
        // Deal with pop-up confirming questionnaire submission
        VshredMemberProfilePage.vsMemberProfilePage.clearQuestionnaireSubmissionModal();
        // Log out member user
        VshredMemberProfilePage.vsMemberProfilePage.clickLogOut();
    }
}
