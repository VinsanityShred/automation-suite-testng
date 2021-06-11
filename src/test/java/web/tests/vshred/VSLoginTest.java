package web.tests.vshred;

import framework.Auth;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import web.pages.vshred.VshredAdminDashPage;
import web.pages.vshred.VshredHomePage;
import web.pages.vshred.VshredLoginPage;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import web.tests.BaseTest;

@Feature("Login")
@Story("Login and out tests")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSLoginTest extends BaseTest {

    private WebDriver driver;
    Boolean isLoggedIn;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        isLoggedIn = false;
        VshredLoginPage.createLoginPage(driver);
        VshredAdminDashPage.createAdminDashPage(driver);
        VshredHomePage.createVSHomePage(driver);
    }

    @Description("Verify Invalid User Login Error")
    @Test(priority = 0)
    public void usernameInvalidTest() throws Exception {
        // Test of invalid user with valid password (TT-32)
        // Expected result: Login Unsuccessful, appropriate error message shows.
        VshredLoginPage.verifyLoginPage();
        VshredLoginPage.loginUserPassword(Auth.invalidUserEmail(), Auth.validAdminUserPassword());
        VshredLoginPage.verifyErrorDlgAndHelpText(VshredLoginPage.INVALID_EMAIL_PASS_MSG);
    }

    @Description("Verify Invalid Password Login Error")
    @Test(priority = 1)
    public void passwordInvalidTest() throws Exception {
        // Test of valid user with invalid password (TT-32)
        // Expected result: Login Unsuccessful, appropriate error message shows.
        VshredLoginPage.verifyLoginPage();
        VshredLoginPage.loginUserPassword(Auth.validAdminUserEmail(), Auth.invalidUserPassword());
        VshredLoginPage.verifyErrorDlgAndHelpText(VshredLoginPage.INVALID_EMAIL_PASS_MSG);
    }

    @Description("Verify Invalid User and Invalid Password Login Error")
    @Test(priority = 2)
    public void loginInvalidTest() throws Exception {
        // Test of invalid user with invalid password (TT-32, and TT-45)
        // Expected result: Login Unsuccessful, appropriate error message shows.
        VshredLoginPage.verifyLoginPage();
        VshredLoginPage.loginUserPassword(Auth.invalidUserEmail(), Auth.invalidUserPassword());
        VshredLoginPage.verifyErrorDlgAndHelpText(VshredLoginPage.INVALID_EMAIL_PASS_MSG);
    }

    @Description("Verify Valid User and Valid Password Login Successful")
    @Test(priority = 3)
    public void loginValidTest() throws Exception {
        // Test of valid user with valid password, see admin dash, logout, try to access admin dash directly while logged out (TT-32)
        // Expected result: Login successful, admin dashboard landing page loads normally
        VshredLoginPage.verifyLoginPage();
        VshredLoginPage.loginUserPassword(Auth.validAdminUserEmail(), Auth.validAdminUserPassword());
        VshredAdminDashPage.verifyAdminDashPage();
        isLoggedIn = VshredAdminDashPage.vsAdminPage.isLoggedIn();
        if (isLoggedIn) {
            //logoutUser();
            VshredAdminDashPage.vsAdminPage.userLogOut();
            // Confirm after logout that the VShred homepage displays
            VshredHomePage.verifyVSHomePage();
        }
    }

    @Description("Verify Logged-out User Cannot Access Dashboard Directly")
    @Test(priority = 4)
    public void directToDashboardTest() throws Exception {
        // Attempt to directly go to the admin dashboard page
        // Expected result: User still logged out, not able to access page and redirected to login.
        if (!isLoggedIn) {
            try {
                VshredAdminDashPage.verifyAdminDashPage();
            } catch (Exception e) {
                System.out.println("PASS: Could not open admin dash page directly with no user logged in");
            }
            VshredLoginPage.verifyLoginPage();
        } else {
            // Raise exception as user is still logged in
            throw new Exception("** Could NOT verify logged-out access due to user being logged in **");
        }
    }
/*
    @Description("Verify Login Logout")
    @Test(priority = 0)
    public void loginLogoutTest() throws Exception{

        //// Create Login/Home Page objects to test ////
        vlp = new VshredLoginPage(driver);
        vhp = new VshredHomePage(driver);

        //// Verify login page logo ////
        vlp.verifyLoginLogoIsDisplayed();

        //// login to application ////
        vlp.setEmailAddress(Auth.mainUserEmail());
        vlp.setUserPassword(Auth.mainUserPassword());
        vlp.clickLoginButton();

        //// Verify home page logo ////
        vhp.verifyHomepageLogoIsDisplayed();

        //// Verify home page header text ////
        System.out.println("Header Text: " + vhp.getHomepageHeaderText());
        vhp.verifyHomepageHeaderTextIsAMatch();

        //// Click Avatar Circle ////
        vhp.clickAvatarCircle();

        //// Click Logout Link ////
        vhp.clickLogoutLink();
    }

    @Description("Verify header text expected failure")
    @Test(priority = 1)
    public void headerTextTestFail() throws Exception{

        //// Create Login/Home Page objects ////
        vlp = new VshredLoginPage(driver);
        vhp = new VshredHomePage(driver);

        //// Verify login page logo ////
        vlp.verifyLoginLogoIsDisplayed();

        //// login to application ////
        vlp.setEmailAddress(Auth.mainUserEmail());
        vlp.setUserPassword(Auth.mainUserPassword());
        vlp.clickLoginButton();

        //// Verify home page logo ////
        vhp.verifyHomepageLogoIsDisplayed();

        //// Verify home page header text ////
        System.out.println("Header Text: " + vhp.getHomepageHeaderText());
        vhp.verifyHomepageHeaderTextIsAMatchFail();

        //// Click Avatar Circle ////
        vhp.clickAvatarCircle();

        //// Click Logout Link ////
        vhp.clickLogoutLink();

    }

    @Description("Click on day two of Gym workout calendar using javascript code")
    @Test(priority = 2)
    public void clickDayTwoGymWorkCalendar() throws Exception{

        //// Create Login/Home Page objects ////
        vlp = new VshredLoginPage(driver);
        vhp = new VshredHomePage(driver);

        //// Verify login page logo ////
        vlp.verifyLoginLogoIsDisplayed();

        //// login to application ////
        vlp.setEmailAddress(Auth.mainUserEmail());
        vlp.setUserPassword(Auth.mainUserPassword());
        vlp.clickLoginButton();

        //// Verify home page logo ////
        vhp.verifyHomepageLogoIsDisplayed();

        //// Verify home page header text ////
        System.out.println("Header Text: " + vhp.getHomepageHeaderText());
        vhp.verifyHomepageHeaderTextIsAMatch();

        driver.get("https://vshred.com/training-plan/fat-loss-extreme-m?ref=member%2Ffat-loss-extreme");

        //// Click on day two of calendar ////
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("document.getElementsByClassName('col-7ths text-center')[1].click();");

        //// Verify Gym Workout Player is Displayed ////
        vhp.verifyGymWorkoutPlayerIsDisplayed();

        //// Click on the completed workout button ////
        Util.waitMilliseconds(1000);
        je.executeScript("document.getElementsByClassName('btn btn--xl btn--warning type--uppercase')[0].click();");
        Util.waitMilliseconds(3000);
        driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
        Util.waitMilliseconds(3000);

    }
*/
}
