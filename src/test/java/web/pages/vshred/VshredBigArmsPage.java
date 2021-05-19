package web.pages.vshred;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.pages.BaseProgramPage;

public class VshredBigArmsPage extends BaseProgramPage {
    public static final String BIG_ARMS_PAGE_URL = "https://testing-2.vshred.com/sp/big-arms-program/v1?ref=programs";

    public VshredBigArmsPage(WebDriver driver) {
        super(driver);
        // Set the purchase button locator specific to this program's page
        vsClickToPurchaseLocator = By.cssSelector("body > main > section.section-10 > div > div > div > div > a");
    }

    //// Locators ////

    //// Methods ////

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
}
