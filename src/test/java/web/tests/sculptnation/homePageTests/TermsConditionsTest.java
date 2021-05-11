package web.tests.sculptnation.homePageTests;

import framework.utility.Util;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.*;
import web.tests.BaseTest;

@Feature("Home Page Tests")
@Story("Terms and Conditions Page test")
@Listeners( framework.testng.AllureScreenshots.class )
public class TermsConditionsTest extends BaseTest {

    SNLandingPage sNLndPg;
    TermsAndConditionsPage trmsPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        trmsPg = new TermsAndConditionsPage(driver);
    }

    @Description("Verify Terms and Conditions page headers")
    @Test()//UUID=6BC81A7C-2672-4F45-9635-2FD92DCABE5F
    public void TermsConditionsHeadersTests() throws Exception {
        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.gotoUrl( "/terms-and-conditions");
        sNLndPg.verifyCurrentPageURLEndsWith("/terms-and-conditions");
        trmsPg.verifyTermsPgHeaderIsDisplayed();
        trmsPg.verifyTermsPgHeader1To34IsDisplayed();
        Util.waitMilliseconds(5000000);
    }


}
