package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ProbioticsCsEnzymes155Page extends BasePage {

    //// Constructor ////
    public ProbioticsCsEnzymes155Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By ProbioticsEnzymesPgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Probiotics Enzymes Video Displayed")
    private boolean isProbioticsEnzymesVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProbioticsEnzymesPgVideoLocator));
        WebElement probioticsEnzymes = driver.findElement(ProbioticsEnzymesPgVideoLocator);
        highlightElement(probioticsEnzymes);
        return probioticsEnzymes.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Probiotics Enzymes Video Is Displayed")
    public void verifyProbioticsEnzymesVideoIsDisplayed() {
        assertTrue(isProbioticsEnzymesVideoDisplayed(), "Probiotics Enzymes Video NOT Displayed");
    }
}

