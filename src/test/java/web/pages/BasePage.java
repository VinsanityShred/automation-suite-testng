package web.pages;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    //// Constructor ////
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    //// Locators ////
    private By signInButton = By.linkText("Sign in");
    By homePageUserName = By.xpath("//table//tr[@class='heading3']");

    //// Methods ////
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
        wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInvisibilityOfElement(WebElement element) {
        wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void scrollToMiddle(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String javascript = "arguments[0].scrollIntoView({behavior: \"smooth\", block: \"center\", inline: \"nearest\"})";
        js.executeScript(javascript, element);
    }

    public void scrollToTop(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String javascript = "arguments[0].scrollIntoView(true);";
        js.executeScript(javascript, element);
    }

    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style','background: Lime; border: 2px solid pink;');", element);
    }

    public String getPageUrl() {
        String currentPageUrl = driver.getCurrentUrl();
        return currentPageUrl;
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
        assertTrue(getPageUrl().endsWith(urlEnd));
    }

}
