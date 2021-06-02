package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class PreWorkoutMultiUs97Page extends BasePage {

    //// Constructor ////
    public PreWorkoutMultiUs97Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
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

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Pre-Workout Multi US Page 97 Image Is Displayed")
    public void verifyPreWorkoutMultiUSPg97ImageIsDisplayed() {
        assertTrue(isPreWorkoutMultiUsPage97ImageDisplayed(), "Pre-Workout Multi US Page 97 Image NOT Displayed");
    }
}
