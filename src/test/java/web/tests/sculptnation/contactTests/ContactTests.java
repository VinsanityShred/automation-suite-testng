package web.tests.sculptnation.contactTests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.ContactUsPage;
import web.pages.sculptnation.SNLandingPage;
import web.tests.BaseTest;

@Feature("Contact Links Tests")
@Story("Contact links tests")
@Listeners( framework.testng.AllureScreenshots.class )
public class ContactTests extends BaseTest {

    SNLandingPage sNLndPg;
    ContactUsPage cUsPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cUsPg = new ContactUsPage(driver);
    }

    @Description("Verify Contact Us link")
    @Test()//UUID=1569D825-D9D4-4AEE-90CB-795571D254BD
    public void contactUsLinkTest() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickEnvelopIcon();
        cUsPg.verifyContactUsPgTextIsDisplayed();
    }

    @Description("Verify Phone Number link")
    @Test()//UUID=450A837E-4DB7-4FD6-92F1-F53BF2CE4B40
    public void PhoneNumberLinkTest() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickPhoneIcon();
    }

}