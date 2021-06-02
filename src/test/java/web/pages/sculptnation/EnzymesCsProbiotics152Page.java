package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class EnzymesCsProbiotics152Page extends BasePage {

    //// Constructor ////
    public EnzymesCsProbiotics152Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By enzymesCsProbioticsPg152VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Enzymes CS Probiotics Page 152 Video Displayed")
    private boolean isEnzymesCsProbioticsPg152VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enzymesCsProbioticsPg152VideoLocator));
        WebElement enzymesCsProbioticsPg152Video = driver.findElement(enzymesCsProbioticsPg152VideoLocator);
        highlightElement(enzymesCsProbioticsPg152Video);
        return enzymesCsProbioticsPg152Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Enzymes CS Probiotics Page 152 Video Is Displayed")
    public void verifyEnzymesCsProbioticsPg152VideoIsDisplayed() {
        assertTrue(isEnzymesCsProbioticsPg152VideoDisplayed(), "Enzymes CS Probiotics Page 152 Video NOT Displayed");
    }

}
