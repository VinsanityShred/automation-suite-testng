package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class SupplementGuideForMenPage extends BasePage {

    //// Constructor ////
    public SupplementGuideForMenPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By menHeaderLocator = By.xpath("//h2[text()='SUPPLEMENT GUIDE FOR MEN']");

    //// Methods ////
    @Step("Is the Men Header Displayed")
    private boolean isMenHeaderDisplayed() {
        WebElement menHeader = driver.findElement(menHeaderLocator);
        highlightElement(menHeader);
        return menHeader.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Check: Verify the Men Header Is Displayed")
    public void verifyMenHeaderIsDisplayed() {
        assertTrue(isMenHeaderDisplayed(), "Men Header NOT Displayed");
    }
}
