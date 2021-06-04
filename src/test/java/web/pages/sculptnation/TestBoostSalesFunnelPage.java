package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class TestBoostSalesFunnelPage extends BasePage {

    //// Constructor ////
    public TestBoostSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By testBoostUsPg81VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By TestBoostUsPg85PgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Test Boost Video Displayed")
    private boolean isTestBoostPg85VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TestBoostUsPg85PgVideoLocator));
        WebElement testBoostPg85Video = driver.findElement(TestBoostUsPg85PgVideoLocator);
        highlightElement(testBoostPg85Video);
        return testBoostPg85Video.isDisplayed();
    }

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
    @Step("Verify the Test Boost Page 85 Video Is Displayed")
    public void verifyTestBoostPg85VideoIsDisplayed() {
        assertTrue(isTestBoostPg85VideoDisplayed(), "Test Boost Page 85 Video NOT Displayed");
    }

    @Step("Verify the Test Boost Page 81 Video Is Displayed")
    public void verifyTestBoostUsPg81VideoIsDisplayed() {
        assertTrue(isTestBoostUsPg81VideoDisplayed(), "Test Boost Page 81 Video NOT Displayed");
    }


}
