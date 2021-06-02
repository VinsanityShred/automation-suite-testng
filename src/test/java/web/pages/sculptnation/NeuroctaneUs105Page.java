package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class NeuroctaneUs105Page extends BasePage {

    //// Constructor ////
    public NeuroctaneUs105Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By neuroctanePg105ImageLocator = By.xpath("//*[@class='Neuroctane 6 Bottles']");

    //// Methods ////
    @Step("Is Neuroctane Page 105 Image Displayed")
    private boolean isNeuroctanePg105ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(neuroctanePg105ImageLocator));
        WebElement neuroctanePg105Image = driver.findElement(neuroctanePg105ImageLocator);
        highlightElement(neuroctanePg105Image);
        return neuroctanePg105Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Neuroctane Page 105 Image Is Displayed")
    public void verifyNeuroctanePg105ImageIsDisplayed() {
        assertTrue(isNeuroctanePg105ImageDisplayed(), "Neuroctane Page 105 Image NOT Displayed");
    }
}
