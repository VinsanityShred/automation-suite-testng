package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnUpsellLifetime201908Page extends BasePage {

    //// Constructor ////
    public BurnUpsellLifetime201908Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By burnUpsellPgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Burn Video Displayed")
    private boolean isBurnUpsellVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnUpsellPgVideoLocator));
        WebElement burnVideo = driver.findElement(burnUpsellPgVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn Upsell Video Is Displayed")
    public void verifyBurnUpsellVideoIsDisplayed() {
        assertTrue(isBurnUpsellVideoDisplayed(), "Burn Upsell Video NOT Displayed");
    }
}
