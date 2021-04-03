package web.tests.sculptnation.headerTests;

import framework.Auth;
import framework.utility.Util;
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

@Feature("Landing Page")
@Story("Header test")
@Listeners( framework.testng.AllureScreenshots.class )
public class HeaderTests extends BaseTest {

    SNLandingPage sNLndPg;
    SNLoginPage sNlp;
    SNHomePage sNhp;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
    }

    @Description("Verify Header links")
    @Test()//UUID=
    public void headerLinksTests() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModalDisplayed();
        sNLndPg.clickCartIcon();
        sNLndPg.verifyCartPageURL();

        Util.waitMilliseconds(5000000);
    }


}
