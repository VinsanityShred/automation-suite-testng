package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class TestBoostUs81Page extends BasePage {

    //// Constructor ////
    public TestBoostUs81Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By testBoostUsPg81VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Test Boost Page 81 Video Displayed")
    private boolean isTestBoostUsPg81VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(testBoostUsPg81VideoLocator));
        WebElement testBoostUsPg81Video = driver.findElement(testBoostUsPg81VideoLocator);
        highlightElement(testBoostUsPg81Video);
        return testBoostUsPg81Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Test Boost Page 81 Video Is Displayed")
    public void verifyTestBoostUsPg81VideoIsDisplayed() {
        assertTrue(isTestBoostUsPg81VideoDisplayed(), "Test Boost Page 81 Video NOT Displayed");
    }


}
