package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class TurmericCs131Page extends BasePage {

    //// Constructor ////
    public TurmericCs131Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By turmericPg131VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Greens Video Displayed")
    private boolean isTurmericPg131VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmericPg131VideoLocator));
        WebElement turmericPg131Video = driver.findElement(turmericPg131VideoLocator);
        highlightElement(turmericPg131Video);
        return turmericPg131Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Greens Video Is Displayed")
    public void verifyTurmericPg131VideoIsDisplayed() {
        assertTrue(isTurmericPg131VideoDisplayed(), "Turmeric Page 131 Video NOT Displayed");
    }
}
