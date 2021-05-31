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
@Story("Privacy Policy test")
@Listeners( framework.testng.AllureScreenshots.class )
public class PrivacyPolicyTest extends BaseTest {

    SNLandingPage sNLndPg;
    PrivacyPolicyPage prvcyPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        prvcyPg = new PrivacyPolicyPage(driver);
    }

    @Description("Verify all the Privacy and Policy page headers")
    @Test()//UUID=41F671E0-AF01-4290-B74D-F82B71D938FF
    public void privacyPolicyHeadersTests() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
//        sNLndPg.closeDiscountModal();
        sNLndPg.scrollToBottomOfPageByKeys();
        sNLndPg.clickFooterPrivacyCookiePolicyLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/privacy-policy");
        prvcyPg.verifyPrivacyPolicyHeaders1To12Displayed();
        Util.waitMilliseconds(2000);
    }

}
