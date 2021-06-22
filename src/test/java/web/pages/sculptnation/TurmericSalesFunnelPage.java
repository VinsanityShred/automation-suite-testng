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
    private By turmericVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By turmeric68Pg3BottleImageLocator = By.xpath("//*[@alt='Turmeric Black 3 Bottles']");

    //// Methods ////
    @Step("Is Turmeric Black Page 68 3 Bottle Image Displayed")
    private boolean isTurmericDs68Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmeric68Pg3BottleImageLocator));
        WebElement turmericDs68Pg3BottleImage = driver.findElement(turmeric68Pg3BottleImageLocator);
        highlightElement(turmericDs68Pg3BottleImage);
        return turmericDs68Pg3BottleImage.isDisplayed();
    }

    @Step("Is Turmeric Black Page 67 Video Displayed")
    private boolean isTurmericUsPg67VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmericVideoLocator));
        WebElement turmericUsPg67Video = driver.findElement(turmericVideoLocator);
        highlightElement(turmericUsPg67Video);
        return turmericUsPg67Video.isDisplayed();
    }

    @Step("Is Burn Video Displayed")
    private boolean isTurmericCsVsPgVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmericVideoLocator));
        WebElement burnVideo = driver.findElement(turmericVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }

    @Step("Is Burn Video Displayed")
    private boolean isTurmericCs104PgVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmericVideoLocator));
        WebElement burnVideo = driver.findElement(turmericVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }

    @Step("Is Greens Video Displayed")
    private boolean isTurmericPg131VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmericVideoLocator));
        WebElement turmericPg131Video = driver.findElement(turmericVideoLocator);
        highlightElement(turmericPg131Video);
        return turmericPg131Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Turmeric Black Page 68 3 Bottle Image Is Displayed")
    public void verifyTurmericUs68Pg3BottleImageIsDisplayed() {
        assertTrue(isTurmericDs68Pg3BottleImageDisplayed(), "Turmeric Black Page 68 3 Bottle Image NOT Displayed");
    }

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
