package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnPmUsF101Page extends BasePage {

    //// Constructor ////
    public BurnPmUsF101Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By burnPm101PgBurnPmImageLocator = By.xpath("//img[@alt='Burn PM 6 Bottle']");

    //// Methods ////
    @Step("Is Burn PM Image Displayed")
    private boolean isBurnPmImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnPm101PgBurnPmImageLocator));
        WebElement burnPmImage = driver.findElement(burnPm101PgBurnPmImageLocator);
        highlightElement(burnPmImage);
        return burnPmImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn PM image Is Displayed")
    public void verifyBurnPmIMageIsDisplayed() {
        assertTrue(isBurnPmImageDisplayed(), "Burn PM Image NOT Displayed");
    }
}
