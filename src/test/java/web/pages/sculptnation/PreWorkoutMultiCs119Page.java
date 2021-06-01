package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class PreWorkoutMultiCs119Page extends BasePage {

    //// Constructor ////
    public PreWorkoutMultiCs119Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By preWorkoutMultiPg119PgEnzymesImageLocator = By.xpath("//*[@alt='Pre Workout']");

    //// Methods ////
    @Step("Is Pre-Workout Multi Page 119 Image Displayed")
    private boolean isPreWorkoutMultiPg119ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiPg119PgEnzymesImageLocator));
        WebElement preWorkoutMultiPg119Image = driver.findElement(preWorkoutMultiPg119PgEnzymesImageLocator);
        highlightElement(preWorkoutMultiPg119Image);
        return preWorkoutMultiPg119Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Pre-Workout Multi Page 119 Image Is Displayed")
    public void verifyPreWorkoutMultiPg119ImageIsDisplayed() {
        assertTrue(isPreWorkoutMultiPg119ImageDisplayed(), "Pre-Workout Multi Page 119 Image NOT Displayed");
    }
}
