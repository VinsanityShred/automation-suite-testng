package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class GreensSalesFunnelPage extends BasePage {

    //// Constructor ////
    public GreensSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By greensMultiCSPg107ImageLocator = By.xpath("//*[@class='Neuroctane 6 Bottles']");
    private By greensPgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By greensPgFlavorDropDownLocator = By.xpath("//*[@id='__BVID__13']");
    private By greensPgYesUpgradeButtonLocator = By.xpath("//*[contains(@class,'site-btn scroll') and contains(text(),'Yes! Upgrade My Order!')]");
    private By greensMultiCsPro154PgHeaderTextLocator = By.xpath("//*[text()='Congratulations! You’ve Just Upgraded Your Microbiome.']");
    private By grnMultEnz156PgHeaderTextLocator = By.xpath("//b[text()='Congratulations On Leveling Up Your Digestive System!']");
    private By greenMulti110PgImageLocator = By.xpath("//*[@class='col-12 col-md-4 col-lg-4 offset-lg-1']");
    private By greens3BottlePg130ImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/greens-ds/img/b-2.png?')]");



    //// Methods ////
    @Step("Is Green 3 Bottle Image Page 130 Displayed")
    private boolean isGreens130Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(greens3BottlePg130ImageLocator));
        WebElement greens130Pg3BottleImage = driver.findElement(greens3BottlePg130ImageLocator);
        highlightElement(greens130Pg3BottleImage);
        return greens130Pg3BottleImage.isDisplayed();
    }

    @Step("Is Green Multi Image Displayed")
    private boolean isGreenMultiImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(greenMulti110PgImageLocator));
        WebElement greenMultiImage = driver.findElement(greenMulti110PgImageLocator);
        highlightElement(greenMultiImage);
        return greenMultiImage.isDisplayed();
    }

    @Step("Is Greens Multi Enzymes Header Text Displayed")
    private boolean isGreensMultiEnzymesHeaderTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(grnMultEnz156PgHeaderTextLocator));
        WebElement greensMultiEnzymesHeaderText = driver.findElement(grnMultEnz156PgHeaderTextLocator);
        highlightElement(greensMultiEnzymesHeaderText);
        return greensMultiEnzymesHeaderText.isDisplayed();
    }

    @Step("Is Greens Page 154 Header Text Displayed")
    private boolean isGreensPg154HeaderTextDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(greensMultiCsPro154PgHeaderTextLocator));
        WebElement greensPg154HeaderText = driver.findElement(greensMultiCsPro154PgHeaderTextLocator);
        highlightElement(greensPg154HeaderText);
        return greensPg154HeaderText.isDisplayed();
    }

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

    @Step("Is Greens Multi CS Page 107 Image Displayed")
    private boolean isGreensMultiCsPg107ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(greensMultiCSPg107ImageLocator));
        WebElement greensMultiCsPg107Image = driver.findElement(greensMultiCSPg107ImageLocator);
        highlightElement(greensMultiCsPg107Image);
        return greensMultiCsPg107Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Green Multi image Is Displayed")
    public void verifyGreens130Pg3BottleImageIsDisplayed() {
        assertTrue(isGreens130Pg3BottleImageDisplayed(), "Greens 3 Bottle Image Page 130 NOT Displayed");
    }

    @Step("Verify the Green Multi image Is Displayed")
    public void verifyGreenMultiImageIsDisplayed() {
        assertTrue(isGreenMultiImageDisplayed(), "Green Multi Image NOT Displayed");
    }

    @Step("Verify the Greens Multi Enzymes Header Text Is Displayed")
    public void verifyGreensMultiEnzymesHeaderTextIsDisplayed() {
        assertTrue(isGreensMultiEnzymesHeaderTextDisplayed(), "Greens Multi Enzymes Header Text NOT Displayed");
    }

    @Step("Verify the Greens Page 154 Header Text Is Displayed")
    public void verifyGreensPg154HeaderTextIsDisplayed() {
        assertTrue(isGreensPg154HeaderTextDisplayed(), "Greens Page 154 Header Text NOT Displayed");
    }

    @Step("Verify the Greens Video Is Displayed")
    public void verifyGreensVideoIsDisplayed() {
        assertTrue(isGreensVideoDisplayed(), "Greens Video NOT Displayed");
    }

    @Step("Verify the Greens Multi CS Page 107 Image Is Displayed")
    public void verifyGreensMultiCsPg107ImageIsDisplayed() {
        assertTrue(isGreensMultiCsPg107ImageDisplayed(), "Greens Multi CS Page 107 Image NOT Displayed");
    }


}
