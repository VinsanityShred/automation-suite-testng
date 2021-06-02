package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ProbioticsUs159Page extends BasePage {

    //// Constructor ////
    public ProbioticsUs159Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By probioticsUsPg159ImageLocator = By.xpath("//*[@alt='Probiotics']");

    //// Methods ////
    @Step("Is Probiotics US Page 159 Image Displayed")
    private boolean isProbioticsUsPg159ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(probioticsUsPg159ImageLocator));
        WebElement probioticsUsPg159Image = driver.findElement(probioticsUsPg159ImageLocator);
        highlightElement(probioticsUsPg159Image);
        return probioticsUsPg159Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Probiotics US Page 159 Image Is Displayed")
    public void verifyProbioticsUsPg159ImageIsDisplayed() {
        assertTrue(isProbioticsUsPg159ImageDisplayed(), "Probiotics US Page 159 Image NOT Displayed");
    }
}
