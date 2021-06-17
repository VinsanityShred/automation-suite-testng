package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class EnzymesSalesFunnelPage extends BasePage {

    //// Constructor ////
    public EnzymesSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By enzymesCsProbioticsPg152VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By enymsUs157PgEnzymesImageLocator = By.xpath("//*[@alt='Enzymes 6 Bottles']");
    private By enymsUs158PgEnzymes3BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/enzymes-ds/img/enzymes-3.png?')]");

    //// Methods ////
    @Step("Is Enzymes 3 Bottle Image Displayed")
    private boolean isEnzymes3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enymsUs158PgEnzymes3BottleImageLocator));
        WebElement bcaas3BottleImage = driver.findElement(enymsUs158PgEnzymes3BottleImageLocator);
        highlightElement(bcaas3BottleImage);
        return bcaas3BottleImage.isDisplayed();
    }

    @Step("Is Enzymes Image Displayed")
    private boolean isEnzymesImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enymsUs157PgEnzymesImageLocator));
        WebElement bcaasImage = driver.findElement(enymsUs157PgEnzymesImageLocator);
        highlightElement(bcaasImage);
        return bcaasImage.isDisplayed();
    }

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
    @Step("Verify the Enzymes 3 Bottle Image Is Displayed")
    public void verifyEnzymes3BottleImageIsDisplayed() {
        assertTrue(isEnzymes3BottleImageDisplayed(), "Enzymes 3 Bottle Image NOT Displayed");
    }

    @Step("Verify the Enzymes Image Is Displayed")
    public void verifyEnzymesImageIsDisplayed() {
        assertTrue(isEnzymesImageDisplayed(), "Enzymes Image NOT Displayed");
    }

    @Step("Verify the Enzymes CS Probiotics Page 152 Video Is Displayed")
    public void verifyEnzymesCsProbioticsPg152VideoIsDisplayed() {
        assertTrue(isEnzymesCsProbioticsPg152VideoDisplayed(), "Enzymes CS Probiotics Page 152 Video NOT Displayed");
    }

}
