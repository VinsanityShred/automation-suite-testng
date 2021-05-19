package web.tests.vshred;

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

    public static final String VALID_MEMBER_USER = "kduerksen+vshred001@betabreakersbugs.com";
    public static final String VALID_MEMBER_PASSWORD = "Password1!";

    private WebDriver driver;
    VshredLoginPage vlp;
    VshredHomePage vhp;
    VshredMemberHomePage vmhp;
    VshredProgramsPage vprogpg;
    VshredBigArmsPage vbigarmspg;
    VshredOrderFormPage vorderpg;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
    }

    @Description("Verify Purchase New Plan")
    @Test(priority = 1)
    public void purchaseNewPlanTest() throws Exception {
        // Test purchase of new plan (TT-46)
        // Expected result: Login and plan purchase successful
        createAndVerifyLoginPage();
        loginUserPassword(VALID_MEMBER_USER, VALID_MEMBER_PASSWORD);
        createAndVerifyMemberHomePage();
        vmhp.clickProgramsLink();
        createAndVerifyProgramsPage();
        vprogpg.clickBigArmsProgram();
        createAndVerifyBigArmsPage();
        vbigarmspg.clickPurchaseButton();
        createAndVerifyOrderFormPage();
        //vorderpg.verifyProductDetailsIsDisplayed();
        vorderpg.setContactDefaults();
        vorderpg.clickContactNextStep();
        vorderpg.setPaymentDefaults();
        vorderpg.clickPaymentNextStep();
        vorderpg.verifyOrderSummaryIsDisplayed();
        //vorderpg.clickSubmitOrder();
    }



    private void createAndVerifyVSHomePage() throws Exception {
        //// Create Login Page objects to test ////
        vhp = new VshredHomePage(driver);

        //// Verify login page logo ////
        vhp.verifyHomepageLogoIsDisplayed();
    }

    private void createAndVerifyLoginPage() throws Exception {
        //// Create Login Page objects to test ////
        vlp = new VshredLoginPage(driver);

        //// Verify login page logo ////
        vlp.verifyLoginLogoIsDisplayed();
    }

    private void createAndVerifyMemberHomePage() throws Exception {
        //// Create Member Home Page objects to test ////
        vmhp = new VshredMemberHomePage(driver);

        //// Verify member edit profile button ////
        vmhp.verifyEditProfileIsDisplayed();
    }

    private void createAndVerifyProgramsPage() throws Exception {
        //// Create Programs Page objects to test ////
        vprogpg = new VshredProgramsPage(driver);

        //// Verify programs page big arms option ////
        vprogpg.verifyBigArmsProgramIsDisplayed();
    }

    private void createAndVerifyBigArmsPage() throws Exception {
        //// Create big arms page to test ////
        vbigarmspg = new VshredBigArmsPage(driver);

        //// Verify big arms program page ////
        vbigarmspg.verifyPurchaseButtonIsDisplayed();
    }

    private void createAndVerifyOrderFormPage() throws Exception {
        //// Create order form page to test ////
        vorderpg = new VshredOrderFormPage(driver);

        //// Verify order form program page ////
        vorderpg.verifyProductDetailsIsDisplayed();
    }

    private void loginUserPassword(String aUser, String aPassword) throws  Exception {
        //// login to application ////
        vlp.setEmailAddress(aUser);
        vlp.setUserPassword(aPassword);
        vlp.clickLoginButton();
    }

}
