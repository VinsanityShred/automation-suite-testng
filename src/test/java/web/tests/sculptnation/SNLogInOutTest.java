package web.tests.sculptnation;

import framework.Auth;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.SNHomePage;
import web.pages.sculptnation.SNLandingPage;
import web.pages.sculptnation.SNLoginPage;
import web.tests.BaseTest;

@Feature("Login Page")
@Story("Login logout test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SNLogInOutTest extends BaseTest {

    private WebDriver driver;
    SNLandingPage sNlndp;
    SNLoginPage sNlp;
    SNHomePage sNhp;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
    }

    @Description("Verify Login Logout")
    @Test(priority = 0)
    public void loginLogoutTest() throws Exception {

        sNlndp = new SNLandingPage(driver);
        sNhp = new SNHomePage(driver);
        sNlp = new SNLoginPage(driver);

        sNlndp.verifyLandingPgLogoIsDisplayed();
        sNlndp.closeDiscountModalDisplayed();
        sNlndp.clickMyAccountLink();
        sNlp.setEmailAddress(Auth.mainUserEmail());
        sNlp.setPassword(Auth.mainUserPassword());
        sNlp.clickLoginButton();
        sNhp.isHomePgAccountContainerDisplayed();
        sNhp.clickLogoutButton();
    }
}
