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
    private By testBoostVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is HGH DS Page 82 Video Displayed")
    private boolean isTestBoostDsPg82VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(testBoostVideoLocator));
        WebElement hghVslCsPg82Video = driver.findElement(testBoostVideoLocator);
        highlightElement(hghVslCsPg82Video);
        return hghVslCsPg82Video.isDisplayed();
    }

    @Step("Is HGH DS Page 86 Video Displayed")
    private boolean isTestBoostDsPg86VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(testBoostVideoLocator));
        WebElement hghVslCsPg86Video = driver.findElement(testBoostVideoLocator);
        highlightElement(hghVslCsPg86Video);
        return hghVslCsPg86Video.isDisplayed();
    }

    @Step("Is Test Boost Video Displayed")
    private boolean isTestBoostPg85VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(testBoostVideoLocator));
        WebElement testBoostPg85Video = driver.findElement(testBoostVideoLocator);
        highlightElement(testBoostPg85Video);
        return testBoostPg85Video.isDisplayed();
    }

    @Step("Is Test Boost Page 81 Video Displayed")
    private boolean isTestBoostUsPg81VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(testBoostVideoLocator));
        WebElement testBoostUsPg81Video = driver.findElement(testBoostVideoLocator);
        highlightElement(testBoostUsPg81Video);
        return testBoostUsPg81Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Test Boost DS Page 82 Video Is Displayed")
    public void verifyTestBoostDsPg82VideoIsDisplayed() {
        assertTrue(isTestBoostDsPg82VideoDisplayed(), "Test Boost DS Page 82 Video NOT Displayed");
    }

    @Step("Verify the Test Boost DS Page 86 Video Is Displayed")
    public void verifyHghVslCsPg86VideoIsDisplayed() {
        assertTrue(isTestBoostDsPg86VideoDisplayed(), "Test Boost DS Page 86 Video NOT Displayed");
    }

    @Step("Verify the Test Boost Page 85 Video Is Displayed")
    public void verifyTestBoostPg85VideoIsDisplayed() {
        assertTrue(isTestBoostPg85VideoDisplayed(), "Test Boost Page 85 Video NOT Displayed");
    }

    @Step("Verify the Test Boost Page 81 Video Is Displayed")
    public void verifyTestBoostUsPg81VideoIsDisplayed() {
        assertTrue(isTestBoostUsPg81VideoDisplayed(), "Test Boost Page 81 Video NOT Displayed");
    }


}
