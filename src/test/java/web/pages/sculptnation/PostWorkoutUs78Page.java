package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class PostWorkoutUs78Page extends BasePage {

    //// Constructor ////
    public PostWorkoutUs78Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By  postWorkoutUs78PgImageLocator = By.xpath("//*[@alt='Post Workout 6 Bottles']");

    //// Methods ////
    @Step("Is Post Workout Page 78 Image Displayed")
    private boolean isPostWorkoutPg78ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postWorkoutUs78PgImageLocator));
        WebElement postWorkoutPg78Image = driver.findElement(postWorkoutUs78PgImageLocator);
        highlightElement(postWorkoutPg78Image);
        return postWorkoutPg78Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Post Workout Page 78 Image Is Displayed")
    public void verifyPostWorkoutPg78ImageIsDisplayed() {
        assertTrue(isPostWorkoutPg78ImageDisplayed(), "Post Workout Page 78 Image NOT Displayed");
    }
}
