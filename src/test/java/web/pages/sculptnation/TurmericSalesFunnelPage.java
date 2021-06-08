package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class TurmericSalesFunnelPage extends BasePage {

    //// Constructor ////
    public TurmericSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By turmericPg131VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By turmericCs104PgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By TurmericCsVsPgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By turmericUsPg67VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Turmeric Black Page 67 Video Displayed")
    private boolean isTurmericUsPg67VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmericUsPg67VideoLocator));
        WebElement turmericUsPg67Video = driver.findElement(turmericUsPg67VideoLocator);
        highlightElement(turmericUsPg67Video);
        return turmericUsPg67Video.isDisplayed();
    }

    @Step("Is Burn Video Displayed")
    private boolean isTurmericCsVsPgVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TurmericCsVsPgVideoLocator));
        WebElement burnVideo = driver.findElement(TurmericCsVsPgVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }

    @Step("Is Burn Video Displayed")
    private boolean isTurmericCs104PgVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmericCs104PgVideoLocator));
        WebElement burnVideo = driver.findElement(turmericCs104PgVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }

    @Step("Is Greens Video Displayed")
    private boolean isTurmericPg131VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmericPg131VideoLocator));
        WebElement turmericPg131Video = driver.findElement(turmericPg131VideoLocator);
        highlightElement(turmericPg131Video);
        return turmericPg131Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Turmeric Black Page 67 Video Is Displayed")
    public void verifyTurmericUsPg67VideoVideoIsDisplayed() {
        assertTrue(isTurmericUsPg67VideoDisplayed(), "Turmeric Black Page 67 Video NOT Displayed");
    }

    @Step("Verify the Burn Upsell Video Is Displayed")
    public void verifyTurmericCsVsPgVideoIsDisplayed() {
        assertTrue(isTurmericCsVsPgVideoDisplayed(),"Turmeric Video NOT Displayed");
    }

    @Step("Verify the Turmeric Video Is Displayed")
    public void verifyTurmericCs104PgVideoIsDisplayed() {
        assertTrue(isTurmericCs104PgVideoDisplayed(), "Turmeric Video NOT Displayed");
    }

    @Step("Verify the Greens Video Is Displayed")
    public void verifyTurmericPg131VideoIsDisplayed() {
        assertTrue(isTurmericPg131VideoDisplayed(), "Turmeric Page 131 Video NOT Displayed");
    }
}
