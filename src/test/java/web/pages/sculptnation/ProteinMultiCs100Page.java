package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ProteinMultiCs100Page extends BasePage {

    //// Constructor ////
    public ProteinMultiCs100Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By proteinMultiCs100PgImageLocator = By.xpath("//*[@alt='protein']");

    //// Methods ////
    @Step("Is Protein Multi CS Page 100 Image Displayed")
    private boolean isProteinMultiCsPg100ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinMultiCs100PgImageLocator));
        WebElement burnPg118Image = driver.findElement(proteinMultiCs100PgImageLocator);
        highlightElement(burnPg118Image);
        return burnPg118Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Protein Multi CS Page 100 Image Is Displayed")
    public void verifyProteinMultiCsPg100ImageIsDisplayed() {
        assertTrue(isProteinMultiCsPg100ImageDisplayed(), "Protein Multi CS Page 100 Image NOT Displayed");
    }
}
