package web.tests.sculptnation.socialMediaTests;

import framework.utility.Util;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.SNLandingPage;
import web.tests.BaseTest;

@Feature("Social Media Tests")
@Story("Social media links test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SNSocialMediaLinksTest extends BaseTest {

    SNLandingPage sNLndPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
    }

    @Description("Verify Facebook and Instagram social media links test")
    @Test()//UUID=EB5572AC-C76A-49C4-BE80-010C2B1632BE
    public void facebookAndInstagramLinksTest() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickFBMediaLink();
        sNLndPg.verifyCurrentPageURL("https://www.facebook.com/sculptnation/");
        sNLndPg.verifyFBLogoIsDisplayed();
        sNLndPg.driverNavigateBack();
        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.clickInstagramMediaLink();
        sNLndPg.verifyCurrentPageURL("https://www.instagram.com/accounts/login/");
        sNLndPg.driverNavigateBack();
    }
}
