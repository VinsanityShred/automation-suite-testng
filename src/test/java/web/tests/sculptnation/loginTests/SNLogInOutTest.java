package web.tests.sculptnation.loginTests;

import framework.Auth;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import web.pages.sculptnation.SNHomePage;
import web.pages.sculptnation.SNLandingPage;
import web.pages.sculptnation.SNLoginPage;
import web.tests.BaseTest;

@Feature("Login Page")
@Story("Login logout test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SNLogInOutTest extends BaseTest {

    SNLandingPage sNLndPg;
    SNLoginPage sNlp;
    SNHomePage sNhp;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        sNhp = new SNHomePage(driver);
        sNlp = new SNLoginPage(driver);
    }

    @Description("Verify Login Logout")
    @Test()//UUID=86C2680C-C15B-4F4D-9A01-208A3F97054D
    public void loginLogoutTest() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModalDisplayed();
        sNLndPg.clickMyAccountLink();
        sNlp.setEmailAddress(Auth.mainUserEmail());
        sNlp.setPassword(Auth.mainUserPassword());
        sNlp.clickLoginButton();
        sNhp.verifyHomePgAccountContainerIsDisplayed();
        sNhp.clickLogoutButton();
    }
}
