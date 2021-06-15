package web.pages.vshred;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.pages.BaseProgramPage;

public class VshredBigArmsProgramPage extends BaseProgramPage {
    public static VshredBigArmsProgramPage vsBigArmsPage;

    public VshredBigArmsProgramPage(WebDriver driver) {
        super(driver);
        //// Locators ////
        // Set the purchase button locator specific to this program's page
        vsClickToPurchaseLocator = By.cssSelector("body > main > section.section-10 > div > div > div > div > a");
    }

    public static void createVSBigArmsPage(WebDriver driver) {
        //// Create Login Page objects to test ////
        vsBigArmsPage = new VshredBigArmsProgramPage(driver);
    }

    //// Methods ////

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    public static void verifyVSBigArmsPage() throws Exception {
        //// Verify purchase button ////
        vsBigArmsPage.verifyPurchaseButtonIsDisplayed();
    }
}
