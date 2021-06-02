package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class PreWorkoutMultiCs75Page extends BasePage {

    //// Constructor ////
    public PreWorkoutMultiCs75Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By preWorkoutMultiCsPg75ImageLocator = By.xpath("//*[@alt='Pre Workout']");

    //// Methods ////
    @Step("Is Pre-Workout Multi CS Page 75 Image Displayed")
    private boolean isPreWorkoutPg75ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiCsPg75ImageLocator));
        WebElement preWorkoutPg75Image = driver.findElement(preWorkoutMultiCsPg75ImageLocator);
        highlightElement(preWorkoutPg75Image);
        return preWorkoutPg75Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Pre-Workout Multi CS Page 75 Image Is Displayed")
    public void verifyPreWorkoutPg75ImageIsDisplayed() {
        assertTrue(isPreWorkoutPg75ImageDisplayed(), "Pre-Workout Multi CS Page 75 Image NOT Displayed");
    }
}
