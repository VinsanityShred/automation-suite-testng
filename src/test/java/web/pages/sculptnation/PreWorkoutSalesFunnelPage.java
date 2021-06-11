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
    private By preWorkoutMultiCs77PgImageLocator = By.xpath("//*[@alt='Pre Workout']");
    private By preWorkoutMultiPg119PgEnzymesImageLocator = By.xpath("//*[@alt='Pre Workout']");
    private By preWorkoutMultiUsPg97ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/pre-workout-multi-us/img/pre-workout-multipack-6-v2.png?v=1622589211']");
    private By preWorkoutMultiUsPg97FlavorDropDownLocator = By.xpath("//*[@id='__BVID__7']");
    private By preWorkoutMultiUsPg97YesUpgradeButtonLocator = By.xpath("//*[contains(@class,'site-btn scroll') and contains(text(),'Yes! Upgrade My Order!')]");

    //// Methods ////
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

    @Step("Is Pre-Workout Multi US Page 97 Image Displayed")
    private boolean isPreWorkoutMultiUsPage97ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiUsPg97ImageLocator));
        WebElement preWorkoutMultiUsPage97Image = driver.findElement(preWorkoutMultiUsPg97ImageLocator);
        highlightElement(preWorkoutMultiUsPage97Image);
        return preWorkoutMultiUsPage97Image.isDisplayed();
    }

    @Step("Is Pre-Workout Multi Page 119 Image Displayed")
    private boolean isPreWorkoutMultiPg119ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiPg119PgEnzymesImageLocator));
        WebElement preWorkoutMultiPg119Image = driver.findElement(preWorkoutMultiPg119PgEnzymesImageLocator);
        highlightElement(preWorkoutMultiPg119Image);
        return preWorkoutMultiPg119Image.isDisplayed();
    }

    @Step("Is Pre-Workout Page 77 Image Displayed")
    private boolean isPreWorkoutPg77ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(preWorkoutMultiCs77PgImageLocator));
        WebElement preWorkoutPg77Image = driver.findElement(preWorkoutMultiCs77PgImageLocator);
        highlightElement(preWorkoutPg77Image);
        return preWorkoutPg77Image.isDisplayed();
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
    @Step("Verify the Pre-Workout Multi US Page 97 Image Is Displayed")
    public void verifyPreWorkoutMultiUSPg97ImageIsDisplayed() {
        assertTrue(isPreWorkoutMultiUsPage97ImageDisplayed(), "Pre-Workout Multi US Page 97 Image NOT Displayed");
    }
    
    @Step("Verify the Pre-Workout Multi Page 119 Image Is Displayed")
    public void verifyPreWorkoutMultiPg119ImageIsDisplayed() {
        assertTrue(isPreWorkoutMultiPg119ImageDisplayed(), "Pre-Workout Multi Page 119 Image NOT Displayed");
    }

    @Step("Verify the Pre-Workout Page 77 Image Is Displayed")
    public void verifyPreWorkoutPg77ImageIsDisplayed() {
        assertTrue(isPreWorkoutPg77ImageDisplayed(), "Pre-Workout Page 77 Image NOT Displayed");
    }

    @Step("Verify the Pre-Workout Multi CS Page 75 Image Is Displayed")
    public void verifyPreWorkoutPg75ImageIsDisplayed() {
        assertTrue(isPreWorkoutPg75ImageDisplayed(), "Pre-Workout Multi CS Page 75 Image NOT Displayed");
    }
}
