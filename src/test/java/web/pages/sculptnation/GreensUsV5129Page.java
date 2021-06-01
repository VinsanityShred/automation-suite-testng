package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class GreensUsV5129Page extends BasePage {

    //// Constructor ////
    public GreensUsV5129Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By greensPgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By greensPgFlavorDropDownLocator = By.xpath("//*[@id='__BVID__13']");
    private By greensPgYesUpgradeButtonLocator = By.xpath("//*[contains(@class,'site-btn scroll') and contains(text(),'Yes! Upgrade My Order!')]");

    //// Methods ////
    @Step("Click Yes Upgrade button")
    public void clickYesUpgradeButton() {
        WebElement yesUpgradeButton = driver.findElement(greensPgYesUpgradeButtonLocator);
        highlightElement(yesUpgradeButton);
        yesUpgradeButton.click();
    }

    @Step("Select flavor from drop down")
    public void selectFlavorFromDropDown(String selector){
        wait.until(ExpectedConditions.visibilityOfElementLocated(greensPgFlavorDropDownLocator));
        WebElement flavorDropDown = driver.findElement(greensPgFlavorDropDownLocator);
        Select flavorOption = new Select (flavorDropDown);
        flavorOption.selectByVisibleText(selector);
    }

    @Step("Is Greens Video Displayed")
    private boolean isGreensVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(greensPgVideoLocator));
        WebElement greensVideo = driver.findElement(greensPgVideoLocator);
        highlightElement(greensVideo);
        return greensVideo.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Greens Video Is Displayed")
    public void verifyGreensVideoIsDisplayed() {
        assertTrue(isGreensVideoDisplayed(), "Greens Video NOT Displayed");
    }
}
