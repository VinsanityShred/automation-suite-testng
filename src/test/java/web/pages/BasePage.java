package web.pages;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    //// Constructor ////
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
    }

    //// Locators ////
    private By signInButton = By.linkText("Sign in");
    private By homePageUserName = By.xpath("//table//tr[@class='heading3']");
    private By addToCartLocator = By.xpath("//a[text()='Add To Cart']");
    private By speedUpMetabolismLinkLocator = By.xpath("//a[text()='Speed Up My Metabolism']");
    private By oneTimePriceLocator = By.className("au-a1-1");
    private By buyNowButtonLocator = By.xpath("//*[text()='BUY NOW']");
    private By bodyOfPageLocator = By.tagName("body");
    private By yesUpgradeButtonLocator = By.xpath("//*[@class='site-btn scroll']");

    //// Methods ////
    @Step("Click on the Add To Cart link")
    public void clickAddToCartLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement addToCartLink = driver.findElements(addToCartLocator).get(index);
        highlightElement(addToCartLink);
        scrollToBottom(addToCartLink);
        addToCartLink.click();
        wait.until(ExpectedConditions.invisibilityOf(addToCartLink));
    }

    @Step("Click on the Speed Up My Metabolism link")
    public void clickSpeedUpMyMetabolismLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement speedUpMyMetabolismLink = driver.findElements(speedUpMetabolismLinkLocator).get(index);
        highlightElement(speedUpMyMetabolismLink);
        scrollToBottom(speedUpMyMetabolismLink);
        speedUpMyMetabolismLink.click();
        wait.until(ExpectedConditions.invisibilityOf(speedUpMyMetabolismLink));
    }

    @Step("Click on the One Time Delivery Price option")
    public void clickOneTimeDeliveryPriceLabel(){
        Util.waitMilliseconds(1000);
        WebElement oneTimeDeliveryPriceLabel = driver.findElement(oneTimePriceLocator);
        wait.until(ExpectedConditions.visibilityOf(oneTimeDeliveryPriceLabel));
        highlightElement(oneTimeDeliveryPriceLabel);
        oneTimeDeliveryPriceLabel.click();
    }

    @Step("Click on the Buy Now button")
    public void clickBuyNowButton(){
        WebElement buyNowButton = driver.findElement(buyNowButtonLocator);
        highlightElement(buyNowButton);
        buyNowButton.click();
    }

    @Step("Click Yes Upgrade button")
    public void clickYesUpgradeButton() {
        WebElement yesUpgradeButton = driver.findElement(yesUpgradeButtonLocator);
        highlightElement(yesUpgradeButton);
        yesUpgradeButton.click();
    }

    public void gotoUrl(String endOfUrl){
        driver.navigate().to(getBaseURLByServer("urlProdSN") + endOfUrl);
    }

    public void closeWindow() {
        driver.close();
    }

    public void driverSwitchToNewTab(int index) {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(tabs.get(index));
    }

    public void driverNavigateBack() {
        driver.navigate().back();
        Util.waitMilliseconds(1000);
    }

    public void driverNavigateForward() {
        driver.navigate().forward();
    }

    public void driverRefresh() {
        driver.navigate().refresh();
    }

    public void driverNavigateToUrl(String navigateToUrl) {
        driver.navigate().to(navigateToUrl);
    }

    public void switchToFrame(String id) {
        driver.switchTo().frame(id);
    }

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInvisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void scrollToMiddle(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String javascript = "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"})";
        js.executeScript(javascript, element);
    }

    public void scrollToTop(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String javascript = "window.scrollTo(document.body.scrollHeight, 0)";
        js.executeScript(javascript, element);
    }

    public void scrollToBottom(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String javascript = "window.scrollTo(0, -document.body.scrollHeight)";
        js.executeScript(javascript, element);
    }

    public void scrollToBottomOfPageByKeys() {
        WebElement toTopOfPage = driver.findElement(bodyOfPageLocator);
        toTopOfPage.sendKeys(Keys.END);
        Util.waitMilliseconds(500);
    }

    public void scrollToTopOfPageByKeys() {
        WebElement toTopOfPage = driver.findElement(bodyOfPageLocator);
        toTopOfPage.sendKeys(Keys.HOME);
        Util.waitMilliseconds(500);
    }

    public void tabToElement() {
        WebElement toElement = driver.findElement(bodyOfPageLocator);
        toElement.sendKeys(Keys.TAB);
        Util.waitMilliseconds(500);
    }

    public void enterOnElement() {
        WebElement enterElement = driver.findElement(bodyOfPageLocator);
        enterElement.sendKeys(Keys.ENTER);
        Util.waitMilliseconds(500);
    }

    public void escapeOnElement() {
        WebElement escapeElement = driver.findElement(bodyOfPageLocator);
        escapeElement.sendKeys(Keys.ESCAPE);
        Util.waitMilliseconds(500);
    }

    public void setTextBySendKeys(String textToSet) {
        new Actions(driver).sendKeys(textToSet).perform();
        Util.waitMilliseconds(500);
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style','background: Lime; border: 2px solid pink;');", element);
    }

    public String getPageUrl() {
        String currentPageUrl = driver.getCurrentUrl();
        return currentPageUrl;
    }

    public static String getBaseURLByServer(String strServer) {

        String baseURL;

        switch (strServer) {
            case "urlProdSN":
                return baseURL = "https://sculptnation.com";
            case "urlStageSN":
                return baseURL = "https://staging.sculptnation.com";
            case "urlProdVS":
                return baseURL = "https://vshred.com";
            case "urlStageVS":
                return baseURL = "https://staging.vshred.com";
            default:
                throw new IllegalArgumentException("System property server set but unknown.  Server was: "+ strServer +"  Unable to continue.");
        }
    }

//    @Attachment
//    @Step("Make screen shot of results page")
//    public byte[] makeScreenShot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }

    //// Getters ////

    //// Setters ////

    //// Verifiers ////
    @Step("Check: Verify current Page URL")
    public void verifyCurrentPageURL(String currentURL) {
        assertTrue(getPageUrl().equals(currentURL));
    }

    @Step("Check: Verify current Page URL")
    public void verifyCurrentPageURLEndsWith(String urlEnd) {
        Util.waitMilliseconds(1000);
        new WebDriverWait(driver, 30).
            pollingEvery(Duration.ofMillis(100)).
            withMessage("Current URL Does NOT Contain: " + urlEnd).
            withTimeout(Duration.ofSeconds(30)).
            until(ExpectedConditions.urlContains(urlEnd));
        assertTrue(getPageUrl().endsWith(urlEnd));
    }

}
