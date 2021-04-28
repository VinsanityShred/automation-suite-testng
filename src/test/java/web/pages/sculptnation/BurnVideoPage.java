package web.pages.sculptnation;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnVideoPage extends BasePage {

    //// Constructor ////
    public BurnVideoPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By burnVideoBannerLocator = By.xpath("//*[@class='video-container']");
    By burnVideoClickToPlayLocator = By.xpath("//*[@class='jw-video jw-reset']");
    By burnVideoPlayingLocator = By.xpath("//*[@class='jwplayer jw-reset jw-state-playing jw-stretch-uniform jw-flag-aspect-mode jw-flag-controls-hidden jw-breakpoint-6']");
    By burnVideoPausedLocator = By.xpath("//*[@class='jwplayer jw-reset jw-state-paused jw-stretch-uniform jw-flag-aspect-mode jw-flag-controls-hidden jw-breakpoint-6']");


    //// Methods ////
    @Step("Is Burn Video Paused")
    private boolean isBurnVideoPaused() {
        Util.waitMilliseconds(1500);
        WebElement burnVideoPaused = driver.findElement(burnVideoPausedLocator);
        wait.until(ExpectedConditions.visibilityOf(burnVideoPaused));
        highlightElement(burnVideoPaused);
        return burnVideoPaused.isDisplayed();
    }

    @Step("Is Burn Video Playing")
    private boolean isBurnVideoPlaying() {
        WebElement burnVideoPlaying = driver.findElement(burnVideoPlayingLocator);
        wait.until(ExpectedConditions.visibilityOf(burnVideoPlaying));
        highlightElement(burnVideoPlaying);
        return burnVideoPlaying.isDisplayed();
    }

    @Step("Click on the Click To Play button")
    public void clickOnClickToPlayButton() {
        WebElement clickToPlayButton = driver.findElement(burnVideoClickToPlayLocator);
        wait.until(ExpectedConditions.visibilityOf(clickToPlayButton));
        highlightElement(clickToPlayButton);
        clickToPlayButton.click();
    }

    @Step("Is Burn Video Displayed")
    private boolean isBurnVideoBannerDisplayed() {
        Util.waitMilliseconds(3000);
        WebElement burnVideoBannerDisplayed = driver.findElement(burnVideoBannerLocator);
        wait.until(ExpectedConditions.visibilityOf(burnVideoBannerDisplayed));
        highlightElement(burnVideoBannerDisplayed);
        return burnVideoBannerDisplayed.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Check: Verify the Burn Video Is Paused")
    public void verifyBurnVideoBannerIsPaused() {
        assertTrue(isBurnVideoPaused(), "Burn Video NOT Paused");
    }

    @Step("Check: Verify the Burn Video Is Playing")
    public void verifyBurnVideoBannerIsPlaying() {
        assertTrue(isBurnVideoPlaying(), "Burn Video NOT Playing");
    }

    @Step("Check: Verify the Burn Video Banner Is Displayed")
    public void verifyBurnVideoBannerIsDisplayed() {
        assertTrue(isBurnVideoBannerDisplayed(), "Burn Video Banner NOT Displayed");
    }
}
