package web.pages.sculptnation;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class TurmericCsF104Page extends BasePage {

    //// Constructor ////
    public TurmericCsF104Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By turmericCs104PgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By turmericCs104PgOneTimePriceLocator = By.className("au-a1-1");
    private By turmericCAddToCartLocator = By.xpath("//a[text()='Add To Cart']");

    //// Methods ////
    @Step("Click on the Add To Cart link")
    public void clickAddToCartLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement addToCartLink = driver.findElements(turmericCAddToCartLocator).get(index);
        highlightElement(addToCartLink);
        scrollToBottom(addToCartLink);
        addToCartLink.click();
        wait.until(ExpectedConditions.invisibilityOf(addToCartLink));
    }

    @Step("Click on the One Time Delivery Price option")
    public void clickOneTimeDeliveryPriceLabel(){
        Util.waitMilliseconds(1000);
        WebElement oneTimeDeliveryPriceLabel = driver.findElement(turmericCs104PgOneTimePriceLocator);
        wait.until(ExpectedConditions.visibilityOf(oneTimeDeliveryPriceLabel));
        highlightElement(oneTimeDeliveryPriceLabel);
        oneTimeDeliveryPriceLabel.click();
    }

    @Step("Is Burn Video Displayed")
    private boolean isTurmericCs104PgVideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmericCs104PgVideoLocator));
        WebElement burnVideo = driver.findElement(turmericCs104PgVideoLocator);
        highlightElement(burnVideo);
        return burnVideo.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Turmeric Video Is Displayed")
    public void verifyTurmericCs104PgVideoIsDisplayed() {
        assertTrue(isTurmericCs104PgVideoDisplayed(), "Turmeric Video NOT Displayed");
    }
}
