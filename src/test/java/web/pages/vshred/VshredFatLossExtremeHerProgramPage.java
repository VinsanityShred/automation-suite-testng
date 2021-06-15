package web.pages.vshred;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.pages.BaseProgramPage;

public class VshredFatLossExtremeHerProgramPage extends BaseProgramPage {
    public static VshredFatLossExtremeHerProgramPage vsFatLossExtremeHerPage;

    public VshredFatLossExtremeHerProgramPage(WebDriver driver) {
        super(driver);
        // Set the purchase button locator specific to this program's page
        vsClickToPurchaseLocator = By.xpath("/html/body/section[31]/div/div/p[1]/a");
    }

    //// Locators ////

    //// Methods ////

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    public static void verifyVSFatLossExtremeHerPage() throws Exception {
        //// Verify purchase button ////
        vsFatLossExtremeHerPage.verifyPurchaseButtonIsDisplayed();
    }
}
