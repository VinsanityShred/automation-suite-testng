package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnPmCs2V470Page extends BasePage {

    //// Constructor ////
    public BurnPmCs2V470Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By burnPmCs2V4Page70VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Burn PM CS2 V4 Page 70 Video Displayed")
    private boolean isBurnPmCs2V4Page70VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnPmCs2V4Page70VideoLocator));
        WebElement burnPmCs2V4Page70Video = driver.findElement(burnPmCs2V4Page70VideoLocator);
        highlightElement(burnPmCs2V4Page70Video);
        return burnPmCs2V4Page70Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn PM CS2 V4 Page 70 Video Is Displayed")
    public void verifyBurnPmCs2V4Page70VideoIsDisplayed() {
        assertTrue(isBurnPmCs2V4Page70VideoDisplayed(), "Burn PM CS2 V4 Page 70 Video NOT Displayed");
    }
}
