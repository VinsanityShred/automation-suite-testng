package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnDownsellLifetime201908Page extends BasePage {

    //// Constructor ////
    public BurnDownsellLifetime201908Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By burnDownsellPgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    By burnDownsellPgYesUpgradeButtonLocator = By.xpath("//*[@class='site-btn scroll']");

    //// Methods ////
    @Step("Click Yes Upgrade button")
    public void clickYesUpgradeButton() {
        WebElement yesUpgradeButton = driver.findElement(burnDownsellPgYesUpgradeButtonLocator);
        highlightElement(yesUpgradeButton);
        yesUpgradeButton.click();
    }

    @Step("Is Burn Video Displayed")
    private boolean isBurnDownsellVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnDownsellPgVideoLocator));
        WebElement burnVideo = driver.findElement(burnDownsellPgVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn Downsell Video Is Displayed")
    public void verifyBurnDownsellVideoIsDisplayed() {
        assertTrue(isBurnDownsellVideoDisplayed(), "Burn Downsell Video NOT Displayed");
    }
}
