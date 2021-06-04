package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ProbioticsSalesFunnelPage extends BasePage {

    //// Constructor ////
    public ProbioticsSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By ProbioticsEnzymesPgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By probioticsUsPg159ImageLocator = By.xpath("//*[@alt='Probiotics']");

    //// Methods ////
    @Step("Is Probiotics US Page 159 Image Displayed")
    private boolean isProbioticsUsPg159ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(probioticsUsPg159ImageLocator));
        WebElement probioticsUsPg159Image = driver.findElement(probioticsUsPg159ImageLocator);
        highlightElement(probioticsUsPg159Image);
        return probioticsUsPg159Image.isDisplayed();
    }

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
    @Step("Verify the Probiotics US Page 159 Image Is Displayed")
    public void verifyProbioticsUsPg159ImageIsDisplayed() {
        assertTrue(isProbioticsUsPg159ImageDisplayed(), "Probiotics US Page 159 Image NOT Displayed");
    }

    @Step("Verify the Probiotics Enzymes Video Is Displayed")
    public void verifyProbioticsEnzymesVideoIsDisplayed() {
        assertTrue(isProbioticsEnzymesVideoDisplayed(), "Probiotics Enzymes Video NOT Displayed");
    }
}

