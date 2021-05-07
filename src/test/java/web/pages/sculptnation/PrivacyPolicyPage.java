package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class PrivacyPolicyPage extends BasePage {

    //// Constructor ////
    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By prvcyPgHeaderLocator = By.xpath("//h3[text()='Privacy Policy']");

    //// Methods ////
    @Step("Is Privacy and Policy header displayed")
    public boolean isPrivacyPolicyHeaderDisplayed() {
        WebElement privacyPolicyHeader = driver.findElement(prvcyPgHeaderLocator);
        highlightElement(privacyPolicyHeader);
        return privacyPolicyHeader.isDisplayed();
    }

    //// Setters ////
    //// Getters ////
    //// Verifiers ////
    @Step("Check: Verify the Privacy and Policy Header Is Displayed")
    public void verifyPrivacyPolicyHeaderDisplayed() {
        assertTrue(isPrivacyPolicyHeaderDisplayed(), "Privacy And Policy Header NOT Displayed");
    }
}
