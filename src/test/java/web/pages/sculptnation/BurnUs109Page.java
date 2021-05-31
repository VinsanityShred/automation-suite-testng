package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnUs109Page extends BasePage {

    //// Constructor ////
    public BurnUs109Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By burnUs109Pg6BoxImageLocator = By.xpath("//*[@alt='Burn Evolved 6 Bottle']");

    //// Methods ////
    @Step("Is Burn Evolved 6 bottle Image Displayed")
    private boolean isBurnEvolved6BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnUs109Pg6BoxImageLocator));
        WebElement burnPmImage = driver.findElement(burnUs109Pg6BoxImageLocator);
        highlightElement(burnPmImage);
        return burnPmImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn PM image Is Displayed")
    public void verifyBurnEvolved6BottleImageIsDisplayed() {
        assertTrue(isBurnEvolved6BottleImageDisplayed(), "Burn Evolved 6 Bottle Image NOT Displayed");
    }
}
