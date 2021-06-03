package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnLgCs1V569Page extends BasePage {

    //// Constructor ////
    public BurnLgCs1V569Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By burnLgCs1V5Pg69VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Burn LG CS1 V5 Page 69 Video Displayed")
    private boolean isBurnLgCs1V5Pg69VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnLgCs1V5Pg69VideoLocator));
        WebElement burnLgCs1V5Pg69Video = driver.findElement(burnLgCs1V5Pg69VideoLocator);
        highlightElement(burnLgCs1V5Pg69Video);
        return burnLgCs1V5Pg69Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn LG CS1 V5 Page 69 Video Is Displayed")
    public void verifyBurnLgCs1V5Pg69VideoIsDisplayed() {
        assertTrue(isBurnLgCs1V5Pg69VideoDisplayed(), "Burn LG CS1 V5 Page 69 Video NOT Displayed");
    }
}
