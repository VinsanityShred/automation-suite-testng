package web.pages.sculptnation;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnSalesFunnelPage extends BasePage {

    //// Constructor ////
    public BurnSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By burnCross2PgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By burnCross2AddToCartLocator = By.xpath("//a[text()='Add To Cart']");
    private By burnCs118PgImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/burn-evolved/img/be-1.png?v=1622581155']");
    private By burnUpsellPgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By burnUs109Pg6BoxImageLocator = By.xpath("//*[@alt='Burn Evolved 6 Bottle']");
    private By burnCs103PgBurnEvolvedImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/burn-evolved/img/be-1.png?v=1621872093']");
    private By burnCs103PgOneTimePriceLocator = By.className("au-a1-1");
    private By burnCs103PgAddToCartLocator = By.xpath("//a[text()='Speed Up My Metabolism']");
    private By burnPm101PgBurnPmImageLocator = By.xpath("//img[@alt='Burn PM 6 Bottle']");
    private By burnPmCs2V4Page70VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By burnLgCs1V5Pg69VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By burnDownsellPgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By burnDownsellPgYesUpgradeButtonLocator = By.xpath("//*[@class='site-btn scroll']");

    //// Methods ////
    @Step("Click Yes Upgrade button")
    public void clickYesUpgradeButton() {
        WebElement yesUpgradeButton = driver.findElement(burnDownsellPgYesUpgradeButtonLocator);
        highlightElement(yesUpgradeButton);
        yesUpgradeButton.click();
    }

    @Step("Is Burn Video Displayed")
    private boolean isBurnDownsellVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnDownsellPgVideoLocator));
        WebElement burnVideo = driver.findElement(burnDownsellPgVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }

    @Step("Is Burn LG CS1 V5 Page 69 Video Displayed")
    private boolean isBurnLgCs1V5Pg69VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnLgCs1V5Pg69VideoLocator));
        WebElement burnLgCs1V5Pg69Video = driver.findElement(burnLgCs1V5Pg69VideoLocator);
        highlightElement(burnLgCs1V5Pg69Video);
        return burnLgCs1V5Pg69Video.isDisplayed();
    }

    @Step("Is Burn PM CS2 V4 Page 70 Video Displayed")
    private boolean isBurnPmCs2V4Page70VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnPmCs2V4Page70VideoLocator));
        WebElement burnPmCs2V4Page70Video = driver.findElement(burnPmCs2V4Page70VideoLocator);
        highlightElement(burnPmCs2V4Page70Video);
        return burnPmCs2V4Page70Video.isDisplayed();
    }

    @Step("Is Burn PM Image Displayed")
    private boolean isBurnPmImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnPm101PgBurnPmImageLocator));
        WebElement burnPmImage = driver.findElement(burnPm101PgBurnPmImageLocator);
        highlightElement(burnPmImage);
        return burnPmImage.isDisplayed();
    }

    @Step("Click on the Speed Up My Metabolism link")
    public void clickSpeedUpMyMetabolismLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement speedUpMyMetabolismLink = driver.findElements(burnCs103PgAddToCartLocator).get(index);
        highlightElement(speedUpMyMetabolismLink);
        scrollToBottom(speedUpMyMetabolismLink);
        speedUpMyMetabolismLink.click();
        wait.until(ExpectedConditions.invisibilityOf(speedUpMyMetabolismLink));
    }

    @Step("Click on the One Time Delivery Price option")
    public void clickOneTimeDeliveryPriceLabel(){
        Util.waitMilliseconds(1000);
        WebElement oneTimeDeliveryPriceLabel = driver.findElement(burnCs103PgOneTimePriceLocator);
        wait.until(ExpectedConditions.visibilityOf(oneTimeDeliveryPriceLabel));
        highlightElement(oneTimeDeliveryPriceLabel);
        oneTimeDeliveryPriceLabel.click();
    }

    @Step("Is Burn Evolved Image Displayed")
    private boolean isBurnEvolvedImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnCs103PgBurnEvolvedImageLocator));
        WebElement burnEvolvedImage = driver.findElement(burnCs103PgBurnEvolvedImageLocator);
        highlightElement(burnEvolvedImage);
        return burnEvolvedImage.isDisplayed();
    }

    @Step("Is Burn Evolved 6 bottle Image Displayed")
    private boolean isBurnEvolved6BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnUs109Pg6BoxImageLocator));
        WebElement burnPmImage = driver.findElement(burnUs109Pg6BoxImageLocator);
        highlightElement(burnPmImage);
        return burnPmImage.isDisplayed();
    }

    @Step("Is Burn Video Displayed")
    private boolean isBurnUpsellVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnUpsellPgVideoLocator));
        WebElement burnVideo = driver.findElement(burnUpsellPgVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }

    @Step("Is Burn Page 118 Image Displayed")
    private boolean isBurnPg118ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnCs118PgImageLocator));
        WebElement burnPg118Image = driver.findElement(burnCs118PgImageLocator);
        highlightElement(burnPg118Image);
        return burnPg118Image.isDisplayed();
    }

    @Step("Click on the Add To Cart link")
    public void clickAddToCartLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement addToCartLink = driver.findElements(burnCross2AddToCartLocator).get(index);
        highlightElement(addToCartLink);
        scrollToBottom(addToCartLink);
        addToCartLink.click();
        wait.until(ExpectedConditions.invisibilityOf(addToCartLink));
    }

    @Step("Is Burn Video Displayed")
    private boolean isBurnCross2VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnCross2PgVideoLocator));
        WebElement burnVideo = driver.findElement(burnCross2PgVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn Downsell Video Is Displayed")
    public void verifyBurnDownsellVideoIsDisplayed() {
        assertTrue(isBurnDownsellVideoDisplayed(), "Burn Downsell Video NOT Displayed");
    }

    @Step("Verify the Burn LG CS1 V5 Page 69 Video Is Displayed")
    public void verifyBurnLgCs1V5Pg69VideoIsDisplayed() {
        assertTrue(isBurnLgCs1V5Pg69VideoDisplayed(), "Burn LG CS1 V5 Page 69 Video NOT Displayed");
    }

    @Step("Verify the Burn PM CS2 V4 Page 70 Video Is Displayed")
    public void verifyBurnPmCs2V4Page70VideoIsDisplayed() {
        assertTrue(isBurnPmCs2V4Page70VideoDisplayed(), "Burn PM CS2 V4 Page 70 Video NOT Displayed");
    }

    @Step("Verify the Burn PM image Is Displayed")
    public void verifyBurnPmIMageIsDisplayed() {
        assertTrue(isBurnPmImageDisplayed(), "Burn PM Image NOT Displayed");
    }

    @Step("Verify the Burn Evolved Image Is Displayed")
    public void verifyBurnEvolvedImageIsDisplayed() {
        assertTrue(isBurnEvolvedImageDisplayed(), "Burn Evolved Image NOT Displayed");
    }

    @Step("Verify the Burn PM image Is Displayed")
    public void verifyBurnEvolved6BottleImageIsDisplayed() {
        assertTrue(isBurnEvolved6BottleImageDisplayed(), "Burn Evolved 6 Bottle Image NOT Displayed");
    }

    @Step("Verify the Burn Upsell Video Is Displayed")
    public void verifyBurnUpsellVideoIsDisplayed() {
        assertTrue(isBurnUpsellVideoDisplayed(), "Burn Upsell Video NOT Displayed");
    }

    @Step("Verify the Burn Page 118 Image Is Displayed")
    public void verifyBurnPg118ImageIsDisplayed() {
        assertTrue(isBurnPg118ImageDisplayed(), "Burn Page 118 Image NOT Displayed");
    }

    @Step("Verify the Burn Upsell Video Is Displayed")
    public void verifyBurnCross2VideoIsDisplayed() {
        assertTrue(isBurnCross2VideoDisplayed(), "Burn Upsell Video NOT Displayed");
    }
}
