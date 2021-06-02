package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class TestBoostUs85Page extends BasePage {

    //// Constructor ////
    public TestBoostUs85Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By TestBoostUsPg85PgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Test Boost Video Displayed")
    private boolean isTestBoostPg85VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestBoostUsPg85PgVideoLocator));
        WebElement testBoostPg85Video = driver.findElement(TestBoostUsPg85PgVideoLocator);
        highlightElement(testBoostPg85Video);
        return testBoostPg85Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Test Boost Page 85 Video Is Displayed")
    public void verifyTestBoostPg85VideoIsDisplayed() {
        assertTrue(isTestBoostPg85VideoDisplayed(), "Test Boost Page 85 Video NOT Displayed");
    }
}
