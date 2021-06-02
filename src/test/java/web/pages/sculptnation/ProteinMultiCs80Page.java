package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ProteinMultiCs80Page extends BasePage {

    //// Constructor ////
    public ProteinMultiCs80Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By proteinMultiCs80PgImageLocator = By.xpath("//*[@alt='protein']");

    //// Methods ////
    @Step("Is Protein Multi CS Page 80 Image Displayed")
    private boolean isProteinMultiCsPg80ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinMultiCs80PgImageLocator));
        WebElement proteinMultiCsPg80Image = driver.findElement(proteinMultiCs80PgImageLocator);
        highlightElement(proteinMultiCsPg80Image);
        return proteinMultiCsPg80Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Protein Multi CS Page 80 Image Is Displayed")
    public void verifyProteinMultiCsPg80ImageIsDisplayed() {
        assertTrue(isProteinMultiCsPg80ImageDisplayed(), "Protein Multi CS Page 80 Image NOT Displayed");
    }
}
