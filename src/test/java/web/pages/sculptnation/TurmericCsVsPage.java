package web.pages.sculptnation;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class TurmericCsVsPage extends BasePage {

    //// Constructor ////
    public TurmericCsVsPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By TurmericCsVsPgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By TurmericCsVsPgOneTimePriceLocator = By.className("au-a1-1");
    private By TurmericCsVsPgAddToCartLocator = By.xpath("//a[text()='Add To Cart']");

    //// Methods ////
    @Step("Click on the Add To Cart link")
    public void clickAddToCartLinkByIndex(int index) {
        Util.waitMilliseconds(1500);
        WebElement addToCartLink = driver.findElements(TurmericCsVsPgAddToCartLocator).get(index);
        highlightElement(addToCartLink);
        scrollToBottom(addToCartLink);
        addToCartLink.click();
        wait.until(ExpectedConditions.invisibilityOf(addToCartLink));
    }

    @Step("Click on the One Time Delivery Price option")
    public void clickOneTimeDeliveryPriceLabel() {
        Util.waitMilliseconds(1000);
        WebElement oneTimeDeliveryPriceLabel = driver.findElement(TurmericCsVsPgOneTimePriceLocator);
        wait.until(ExpectedConditions.visibilityOf(oneTimeDeliveryPriceLabel));
        highlightElement(oneTimeDeliveryPriceLabel);
        oneTimeDeliveryPriceLabel.click();
    }

    @Step("Is Burn Video Displayed")
    private boolean isTurmericCsVsPgVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TurmericCsVsPgVideoLocator));
        WebElement burnVideo = driver.findElement(TurmericCsVsPgVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }


    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn Upsell Video Is Displayed")
    public void verifyTurmericCsVsPgVideoIsDisplayed() {
    assertTrue(isTurmericCsVsPgVideoDisplayed(),"Turmeric Video NOT Displayed");
    }
}
