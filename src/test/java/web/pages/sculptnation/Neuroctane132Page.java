package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class Neuroctane132Page extends BasePage {

    //// Constructor ////
    public Neuroctane132Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By nuroct132PgImageLocator = By.xpath("//*[@alt='Neuroctane']");

    //// Methods ////
    @Step("Is Neuroctane Image Displayed")
    private boolean isNeuroctaneImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nuroct132PgImageLocator));
        WebElement neuroctaneImage = driver.findElement(nuroct132PgImageLocator);
        highlightElement(neuroctaneImage);
        return neuroctaneImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Neuroctane Image Is Displayed")
    public void verifyNeuroctaneImageIsDisplayed() {
        assertTrue(isNeuroctaneImageDisplayed(), "Neuroctane Image NOT Displayed");
    }
}
