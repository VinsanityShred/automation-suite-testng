package web.tests.vshred;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import web.pages.vshred.VshredHomePage;
import web.pages.vshred.VshredLoginPage;
import framework.Auth;
import framework.utility.Util;
import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import web.tests.BaseTest;

@Feature("Login")
@Story("Login and out tests")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSLoginTest extends BaseTest {

    private WebDriver driver;
    VshredLoginPage vlp;
    VshredHomePage vhp;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
    }

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

}
