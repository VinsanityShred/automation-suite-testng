package web.pages.vshred;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.pages.BaseProgramPage;

public class VshredFatLossExtremeHerProgramPage extends BaseProgramPage {
    public static VshredFatLossExtremeHerProgramPage vsFatLossExtremeHerPage;

    public VshredFatLossExtremeHerProgramPage(WebDriver driver) {
        super(driver);
        // Set the purchase button locator specific to this program's page
        //vsClickToPurchaseLocator = By.cssSelector("body > section.section-30 > div > div > p:nth-child(1) > a");
        vsClickToPurchaseLocator = By.xpath("/html/body/section[31]/div/div/p[1]/a");
    }
    public static void createVSFatLossExtremeHerPage(WebDriver driver) {
        //// Create Login Page objects to test ////
        vsFatLossExtremeHerPage = new VshredFatLossExtremeHerProgramPage(driver);
    }

    public static void verifyVSFatLossExtremeHerPage() throws Exception {
        //// Verify purchase button ////
        vsFatLossExtremeHerPage.verifyPurchaseButtonIsDisplayed();
    }

    //// Locators ////

    //// Methods ////

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
}
