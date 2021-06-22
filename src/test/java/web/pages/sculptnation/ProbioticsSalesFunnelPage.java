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
    private By probioticsUs159Pg6BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/probiotics-us/img/probiotic-6-v2.png?')]");
    private By probioticsUs160Pg3BottleImageLocator = By.xpath("//*[contains(@alt,'Probiotic 3 Bottles')]");

    //// Methods ////
    @Step("Is Probiotics US Page 160 3 Bottle Image Displayed")
    private boolean isProbioticsUs160Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(probioticsUs160Pg3BottleImageLocator));
        WebElement probioticsUs160Pg3BottleImage = driver.findElement(probioticsUs160Pg3BottleImageLocator);
        highlightElement(probioticsUs160Pg3BottleImage);
        return probioticsUs160Pg3BottleImage.isDisplayed();
    }

    @Step("Is Probiotics US Page 159 6 Bottle Image Displayed")
    private boolean isProbioticsUs159Pg6BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(probioticsUs159Pg6BottleImageLocator));
        WebElement probioticsUs159Pg6BottleImage = driver.findElement(probioticsUs159Pg6BottleImageLocator);
        highlightElement(probioticsUs159Pg6BottleImage);
        return probioticsUs159Pg6BottleImage.isDisplayed();
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
    @Step("Verify the Probiotics US Page 160 3 Bottle Image Is Displayed")
    public void verifyProbioticsUs160Pg3BottleImageIsDisplayed() {
        assertTrue(isProbioticsUs160Pg3BottleImageDisplayed(), "Probiotics US Page 160 3 Bottle Image NOT Displayed");
    }

    @Step("Verify the Probiotics US Page 159 6 Bottle Image Is Displayed")
    public void verifyProbioticsUs159Pg6BottleImageIsDisplayed() {
        assertTrue(isProbioticsUs159Pg6BottleImageDisplayed(), "Probiotics US Page 159 6 Bottle Image NOT Displayed");
    }

    @Step("Verify the Probiotics Enzymes Video Is Displayed")
    public void verifyProbioticsEnzymesVideoIsDisplayed() {
        assertTrue(isProbioticsEnzymesVideoDisplayed(), "Probiotics Enzymes Video NOT Displayed");
    }
}

