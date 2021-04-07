package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class SupplementGuideForWomenPage extends BasePage {

    //// Constructor ////
    public SupplementGuideForWomenPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By womenHeaderLocator = By.xpath("//h2[text()='SUPPLEMENT GUIDE FOR WOMEN']");

    //// Methods ////
    @Step("Is the Women Header Displayed")
    private boolean isWomenHeaderDisplayed() {
        WebElement womenHeader = driver.findElement(womenHeaderLocator);
        highlightElement(womenHeader);
        return womenHeader.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Check: Verify the Women Header Is Displayed")
    public void verifyWomenHeaderIsDisplayed() {
        assertTrue(isWomenHeaderDisplayed(), "Women Header NOT Displayed");
    }
}
