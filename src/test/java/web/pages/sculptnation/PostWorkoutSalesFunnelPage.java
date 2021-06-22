package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class PostWorkoutSalesFunnelPage extends BasePage {

    //// Constructor ///
    public PostWorkoutSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By postWorkoutCsPg76ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/post-workout-cs/img/pw_six.png?v=1622589211']");
    private By  postWorkoutUs78Pg6BottleImageLocator = By.xpath("//*[@alt='Post Workout 6 Bottles']");
    private By  postWorkoutUs79Pg3BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/post-workout-ds/img/b-2.png?')]");

    //// Methods ////
    @Step("Is Post Workout Page 79 3 Bottle Image Displayed")
    private boolean isPostWorkout79Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postWorkoutUs79Pg3BottleImageLocator));
        WebElement postWorkout79Pg3BottleImage = driver.findElement(postWorkoutUs79Pg3BottleImageLocator);
        highlightElement(postWorkout79Pg3BottleImage);
        return postWorkout79Pg3BottleImage.isDisplayed();
    }

    @Step("Is Post Workout Page 78 6 Bottle Image Displayed")
    private boolean isPostWorkout78Pg6BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postWorkoutUs78Pg6BottleImageLocator));
        WebElement postWorkout78Pg6BottleImage = driver.findElement(postWorkoutUs78Pg6BottleImageLocator);
        highlightElement(postWorkout78Pg6BottleImage);
        return postWorkout78Pg6BottleImage.isDisplayed();
    }

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
    @Step("Verify the Post Workout Page 79 3 Bottle Image Is Displayed")
    public void verifyPostWorkout79Pp3BottleImageIsDisplayed() {
        assertTrue(isPostWorkout79Pg3BottleImageDisplayed(), "Post Workout Page 79 3 Bottle Image NOT Displayed");
    }

    @Step("Verify the Post Workout Page 78 6 Bottle Image Is Displayed")
    public void verifyPostWorkout78Pg6BottleImageIsDisplayed() {
        assertTrue(isPostWorkout78Pg6BottleImageDisplayed(), "Post Workout Page 78 6 Bottle Image NOT Displayed");
    }

    @Step("Verify the Post Workout CS Page 76 Image Is Displayed")
    public void verifyPostWorkoutCsPg76ImageIsDisplayed() {
        assertTrue(isPostWorkoutCsPg76ImageDisplayed(), "Post Workout CS Page 76 Image NOT Displayed");
    }
}
