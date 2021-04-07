package web.tests.sculptnation.socialMediaTests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.SNLandingPage;
import web.tests.BaseTest;

@Feature("Header Tests")
@Story("Social media links test")
@Listeners( framework.testng.AllureScreenshots.class )
public class SNSocialMediaLinksTest extends BaseTest {

    SNLandingPage sNLndPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
    }

    @Description("Verify Facebook social media link")
    @Test()//UUID=EB5572AC-C76A-49C4-BE80-010C2B1632BE
    public void facebookLinkTest() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickFBMediaLink();
        sNLndPg.verifyFBLogoIsDisplayed();
        sNLndPg.driverNavigateBack();
    }

    @Description("Verify Instagram social media link")
    @Test()//UUID=98971DB7-E3AE-490B-8595-40F3A4C83A77
    public void instagramLinkTest() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickInstagramMediaLink();
        sNLndPg.verifyInstagramLogoIsDisplayed();
        sNLndPg.driverNavigateBack();
    }
}
