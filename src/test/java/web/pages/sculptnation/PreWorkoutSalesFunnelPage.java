package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class PreWorkoutSalesFunnelPage extends BasePage {

    //// Constructor ////
    public PreWorkoutSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By preWorkoutMultiCsPg75ImageLocator = By.xpath("//*[@alt='Pre Workout']");
    private By preWorkoutMultiCs77Pg3BottleImageLocator = By.xpath("//*[@alt='Pre Workout']");
    private By preWorkoutMultiPg119PgEnzymesImageLocator = By.xpath("//*[@alt='Pre Workout']");
    private By preWorkoutMultiUs97Pg6BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/pre-workout-multi-us/img/pre-workout-multipack-6-v2.png?')]");
    private By preWorkoutMultiUsPg97FlavorDropDownLocator = By.xpath("//*[@id='__BVID__7']");
    private By preWorkoutMultiUsPg97YesUpgradeButtonLocator = By.xpath("//*[contains(@class,'site-btn scroll') and contains(text(),'Yes! Upgrade My Order!')]");
    private By preWorkoutMultiDs98Pg3BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/pre-workout-multi-ds/img/b-5-3-2-600x457.png?')]");

    //// Methods ////
    @Step("Is Pre-Workout Multi DS Page 98 3 Bottle Image Displayed")
    private boolean isPreWorkoutMultiDs98Page3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiDs98Pg3BottleImageLocator));
        WebElement preWorkoutMultiDs98Page3BottleImage = driver.findElement(preWorkoutMultiDs98Pg3BottleImageLocator);
        highlightElement(preWorkoutMultiDs98Page3BottleImage);
        return preWorkoutMultiDs98Page3BottleImage.isDisplayed();
    }

    @Step("Click Yes Upgrade button")
    public void clickYesUpgradeButton() {
        WebElement yesUpgradeButton = driver.findElement(preWorkoutMultiUsPg97YesUpgradeButtonLocator);
        highlightElement(yesUpgradeButton);
        yesUpgradeButton.click();
    }

    @Step("Select flavor from drop down")
    public void selectFlavorFromDropDown(String selector){
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiUsPg97FlavorDropDownLocator));
        WebElement flavorDropDown = driver.findElement(preWorkoutMultiUsPg97FlavorDropDownLocator);
        Select flavorOption = new Select (flavorDropDown);
        flavorOption.selectByVisibleText(selector);
    }

    @Step("Is Pre-Workout Multi US Page 97 6 Bottle Image Displayed")
    private boolean isPreWorkoutMultiUs97Page6BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiUs97Pg6BottleImageLocator));
        WebElement preWorkoutMultiUs97Page6BottleImage = driver.findElement(preWorkoutMultiUs97Pg6BottleImageLocator);
        highlightElement(preWorkoutMultiUs97Page6BottleImage);
        return preWorkoutMultiUs97Page6BottleImage.isDisplayed();
    }

    @Step("Is Pre-Workout Multi Page 119 Image Displayed")
    private boolean isPreWorkoutMultiPg119ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiPg119PgEnzymesImageLocator));
        WebElement preWorkoutMultiPg119Image = driver.findElement(preWorkoutMultiPg119PgEnzymesImageLocator);
        highlightElement(preWorkoutMultiPg119Image);
        return preWorkoutMultiPg119Image.isDisplayed();
    }

    @Step("Is Pre-Workout Page 77 3 Bottle Image Displayed")
    private boolean isPreWorkout77Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiCs77Pg3BottleImageLocator));
        WebElement preWorkout77Pg3BottleImage = driver.findElement(preWorkoutMultiCs77Pg3BottleImageLocator);
        highlightElement(preWorkout77Pg3BottleImage);
        return preWorkout77Pg3BottleImage.isDisplayed();
    }

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
    @Step("Verify the Pre-Workout Multi US Page 98 3 Bottle Image Is Displayed")
    public void verifyPreWorkoutMultiUS98Pg3BottleImageIsDisplayed() {
        assertTrue(isPreWorkoutMultiDs98Page3BottleImageDisplayed(), "Pre-Workout Multi US Page 98 3 Bottle Image NOT Displayed");
    }

    @Step("Verify the Pre-Workout Multi US Page 97 6 Bottle Image Is Displayed")
    public void verifyPreWorkoutMultiUS97Pg6BottleImageIsDisplayed() {
        assertTrue(isPreWorkoutMultiUs97Page6BottleImageDisplayed(), "Pre-Workout Multi US Page 97 6 Bottle Image NOT Displayed");
    }
    
    @Step("Verify the Pre-Workout Multi Page 119 Image Is Displayed")
    public void verifyPreWorkoutMultiPg119ImageIsDisplayed() {
        assertTrue(isPreWorkoutMultiPg119ImageDisplayed(), "Pre-Workout Multi Page 119 Image NOT Displayed");
    }

    @Step("Verify the Pre-Workout Page 77 3 Bottle Image Is Displayed")
    public void verifyPreWorkout77Pg3BottleImageIsDisplayed() {
        assertTrue(isPreWorkout77Pg3BottleImageDisplayed(), "Pre-Workout Page 77 3 Bottle Image NOT Displayed");
    }

    @Step("Verify the Pre-Workout Multi CS Page 75 Image Is Displayed")
    public void verifyPreWorkoutPg75ImageIsDisplayed() {
        assertTrue(isPreWorkoutPg75ImageDisplayed(), "Pre-Workout Multi CS Page 75 Image NOT Displayed");
    }
}
