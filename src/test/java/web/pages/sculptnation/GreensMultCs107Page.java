package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class GreensMultCs107Page extends BasePage {

    //// Constructor ////
    public GreensMultCs107Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By GreensMultiCSPg107ImageLocator = By.xpath("//*[@class='Neuroctane 6 Bottles']");

    //// Methods ////
    @Step("Is Greens Multi CS Page 107 Image Displayed")
    private boolean isGreensMultiCsPg107ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(GreensMultiCSPg107ImageLocator));
        WebElement greensMultiCsPg107Image = driver.findElement(GreensMultiCSPg107ImageLocator);
        highlightElement(greensMultiCsPg107Image);
        return greensMultiCsPg107Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Greens Multi CS Page 107 Image Is Displayed")
    public void verifyGreensMultiCsPg107ImageIsDisplayed() {
        assertTrue(isGreensMultiCsPg107ImageDisplayed(), "Greens Multi CS Page 107 Image NOT Displayed");
    }


}
