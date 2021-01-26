package web.pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;

import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

//    @Attachment
//    @Step("Make screen shot of results page")
//    public byte[] makeScreenShot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }

    //// Getters ////

    //// Setters ////

    //// Verifiers ////

}
