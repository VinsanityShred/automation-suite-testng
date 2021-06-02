package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class PostWorkoutCs76Page extends BasePage {

    //// Constructor ///
    public PostWorkoutCs76Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By postWorkoutCsPg76ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/post-workout-cs/img/pw_six.png?v=1622589211']");

    //// Methods ////
    @Step("Is Post Workout CS Page 76 Image Displayed")
    private boolean isPostWorkoutCsPg76ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postWorkoutCsPg76ImageLocator));
        WebElement postWorkoutCsPg76Image = driver.findElement(postWorkoutCsPg76ImageLocator);
        highlightElement(postWorkoutCsPg76Image);
        return postWorkoutCsPg76Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Post Workout CS Page 76 Image Is Displayed")
    public void verifyPostWorkoutCsPg76ImageIsDisplayed() {
        assertTrue(isPostWorkoutCsPg76ImageDisplayed(), "Post Workout CS Page 76 Image NOT Displayed");
    }
}
