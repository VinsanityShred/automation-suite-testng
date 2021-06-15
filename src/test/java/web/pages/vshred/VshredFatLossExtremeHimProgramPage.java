package web.pages.vshred;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.pages.BaseProgramPage;

public class VshredFatLossExtremeHimProgramPage extends BaseProgramPage {
    public static VshredFatLossExtremeHimProgramPage vsFatLossExtremeHimPage;

    public VshredFatLossExtremeHimProgramPage(WebDriver driver) {
        super(driver);
        //// Locators ////
        // Set the purchase button locator specific to this program's page
        vsClickToPurchaseLocator = By.xpath("/html/body/div[4]/section[29]/div/div/div[2]/div/a");
    }
    public static void createVSFatLossExtremeHimPage(WebDriver driver) {
        //// Create Login Page objects to test ////
        vsFatLossExtremeHimPage = new VshredFatLossExtremeHimProgramPage(driver);
    }

    //// Methods ////

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    public static void verifyVSFatLossExtremeHimPage() throws Exception {
        //// Verify purchase button ////
        vsFatLossExtremeHimPage.verifyPurchaseButtonIsDisplayed();
    }
}
