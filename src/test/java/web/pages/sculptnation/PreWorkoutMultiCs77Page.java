package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class PreWorkoutMultiCs77Page extends BasePage {

    //// Constructor ////
    public PreWorkoutMultiCs77Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By preWorkoutMultiCs77PgImageLocator = By.xpath("//*[@alt='Pre Workout']");

    //// Methods ////
    @Step("Is Pre-Workout Page 77 Image Displayed")
    private boolean isPreWorkoutPg77ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiCs77PgImageLocator));
        WebElement preWorkoutPg77Image = driver.findElement(preWorkoutMultiCs77PgImageLocator);
        highlightElement(preWorkoutPg77Image);
        return preWorkoutPg77Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Pre-Workout Page 77 Image Is Displayed")
    public void verifyPreWorkoutPg77ImageIsDisplayed() {
        assertTrue(isPreWorkoutPg77ImageDisplayed(), "Pre-Workout Page 77 Image NOT Displayed");
    }

}
