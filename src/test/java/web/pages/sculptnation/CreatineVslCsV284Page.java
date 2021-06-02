package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CreatineVslCsV284Page extends BasePage {

    //// Constructor ////
    public CreatineVslCsV284Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By creatineVslCsV2Pg84VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Creatine VSL CS V2 Page 84 Video Displayed")
    private boolean isCreatineVslCsV2Pg84VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(creatineVslCsV2Pg84VideoLocator));
        WebElement creatineVslCsV2Pg84Video = driver.findElement(creatineVslCsV2Pg84VideoLocator);
        highlightElement(creatineVslCsV2Pg84Video);
        return creatineVslCsV2Pg84Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Creatine VSL CS V2 Page 84 Video Is Displayed")
    public void verifyCreatineVslCsV2Pg84VideoIsDisplayed() {
        assertTrue(isCreatineVslCsV2Pg84VideoDisplayed(), "Creatine VSL CS V2 Page 84 Video NOT Displayed");
    }
}
