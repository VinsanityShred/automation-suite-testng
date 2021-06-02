package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class GreensMultiCsPro154Page extends BasePage {

    //// Constructor ////
    public GreensMultiCsPro154Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By greensMultiCsPro154PgHeaderTextLocator = By.xpath("//*[text()='Congratulations! You’ve Just Upgraded Your Microbiome.']");

    //// Methods ////
    @Step("Is Greens Page 154 Header Text Displayed")
    private boolean isGreensPg154HeaderTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(greensMultiCsPro154PgHeaderTextLocator));
        WebElement greensPg154HeaderText = driver.findElement(greensMultiCsPro154PgHeaderTextLocator);
        highlightElement(greensPg154HeaderText);
        return greensPg154HeaderText.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Greens Page 154 Header Text Is Displayed")
    public void verifyGreensPg154HeaderTextIsDisplayed() {
        assertTrue(isGreensPg154HeaderTextDisplayed(), "Greens Page 154 Header Text NOT Displayed");
    }
}
