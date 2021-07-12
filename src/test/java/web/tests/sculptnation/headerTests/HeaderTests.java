package web.tests.sculptnation.headerTests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.*;
import web.tests.BaseTest;

@Feature("Header Page Tests")
@Story("Header test")
@Listeners( framework.testng.AllureScreenshots.class )
public class HeaderTests extends BaseTest {

    SNLandingPage sNLndPg;
    SNLoginPage sNlp;
    CartPage cartPg;
    AboutUsPage aUPg;
    SupplementGuideForWomenPage sGWPg;
    SupplementGuideForMenPage sGMPg;
    SupplementsPage sPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        cartPg = new CartPage(driver);
        sNlp = new SNLoginPage(driver);
        aUPg = new AboutUsPage(driver);
        sGWPg = new SupplementGuideForWomenPage(driver);
        sGMPg = new SupplementGuideForMenPage(driver);
        sPg = new SupplementsPage(driver);
    }

    @Description("Verify Header links")
    @Test()//UUID=73F56AFB-D065-4CAA-9C07-5B21EAC1FA95
    public void headerLinksTests() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickCartIcon();
        sNLndPg.verifyCurrentPageURLEndsWith("/cart");
        cartPg.verifyEmptyCartLogoIsDisplayed();
        sNLndPg.clickMyAccountLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/login");
        sNlp.verifyLoginLogoIsDisplayed();
        sNLndPg.clickAboutUsLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/about-us");
        aUPg.verifyAboutUsHeaderIsDisplayed();
        sNLndPg.clickClothingLink();
        sNLndPg.verifyCurrentPageURL("https://vshredthreads.com/");
        sNLndPg.driverNavigateBack();
        sNLndPg.clickSupplementGuideLink();
        sNLndPg.clickFemaleGuideLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/supplement-guide-for-women");
        sGWPg.verifyWomenHeaderIsDisplayed();
        sNLndPg.clickSupplementGuideLink();
        sNLndPg.clickMaleGuideLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/supplement-guide-for-men");
        sGMPg.verifyMenHeaderIsDisplayed();
        sNLndPg.clickSupplementsLink();
        sNLndPg.verifyCurrentPageURLEndsWith("/products");
        sPg.verifyProductCardIsDisplayed();
        sNLndPg.clickHomeLink();
        sNLndPg.verifyCurrentPageURL("https://sculptnation.com/");
        sNLndPg.verifyWatchVideoLinkIsDisplayed();
    }


}
