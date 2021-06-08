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
    private By  postWorkoutUs78PgImageLocator = By.xpath("//*[@alt='Post Workout 6 Bottles']");

    //// Methods ////
    @Step("Is Post Workout Page 78 Image Displayed")
    private boolean isPostWorkoutPg78ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postWorkoutUs78PgImageLocator));
        WebElement postWorkoutPg78Image = driver.findElement(postWorkoutUs78PgImageLocator);
        highlightElement(postWorkoutPg78Image);
        return postWorkoutPg78Image.isDisplayed();
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
    @Step("Verify the Post Workout Page 78 Image Is Displayed")
    public void verifyPostWorkoutPg78ImageIsDisplayed() {
        assertTrue(isPostWorkoutPg78ImageDisplayed(), "Post Workout Page 78 Image NOT Displayed");
    }

    @Step("Verify the Post Workout CS Page 76 Image Is Displayed")
    public void verifyPostWorkoutCsPg76ImageIsDisplayed() {
        assertTrue(isPostWorkoutCsPg76ImageDisplayed(), "Post Workout CS Page 76 Image NOT Displayed");
    }
}
