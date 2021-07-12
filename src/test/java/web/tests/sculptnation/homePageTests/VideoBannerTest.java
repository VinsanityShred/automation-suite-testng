package web.tests.sculptnation.homePageTests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pages.sculptnation.BurnVideoPage;
import web.pages.sculptnation.SNLandingPage;
import web.tests.BaseTest;

@Feature("Video Tests")
@Story("Video Banner test")
@Listeners( framework.testng.AllureScreenshots.class )
public class VideoBannerTest extends BaseTest {

    SNLandingPage sNLndPg;
    BurnVideoPage bVPg;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = getDriver();
        sNLndPg = new SNLandingPage(driver);
        bVPg = new BurnVideoPage(driver);
    }

    @Description("Verify the video banner is working as expected")
    @Test()//UUID=CDF67D4A-DF93-4034-ADCF-FA41C49A5363
    public void contactUsLinkTest() throws Exception {

        sNLndPg.verifyLandingPgLogoIsDisplayed();
        sNLndPg.closeDiscountModal();
        sNLndPg.clickWatchVideoLink();
        sNLndPg.driverSwitchToNewTab(1);
        bVPg.verifyBurnVideoBannerIsDisplayed();
        bVPg.clickOnClickToPlayButton();
        bVPg.verifyBurnVideoBannerIsPlaying();
        bVPg.clickOnClickToPlayButton();
        bVPg.verifyBurnVideoBannerIsPaused();
    }

}
