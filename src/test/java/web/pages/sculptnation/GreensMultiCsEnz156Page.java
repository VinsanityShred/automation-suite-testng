package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class GreensMultiCsEnz156Page extends BasePage {

    //// Constructor ////
    public GreensMultiCsEnz156Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By GrnMultEnz156PgHeaderTextLocator = By.xpath("//b[text()='Congratulations On Leveling Up Your Digestive System!']");

    //// Methods ////
    @Step("Is Greens Multi Enzymes Header Text Displayed")
    private boolean isGreensMultiEnzymesHeaderTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GrnMultEnz156PgHeaderTextLocator));
        WebElement greensMultiEnzymesHeaderText = driver.findElement(GrnMultEnz156PgHeaderTextLocator);
        highlightElement(greensMultiEnzymesHeaderText);
        return greensMultiEnzymesHeaderText.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Greens Multi Enzymes Header Text Is Displayed")
    public void verifyGreensMultiEnzymesHeaderTextIsDisplayed() {
        assertTrue(isGreensMultiEnzymesHeaderTextDisplayed(), "Greens Multi Enzymes Header Text NOT Displayed");
    }
}
