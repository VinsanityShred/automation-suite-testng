package web.pages.sculptnation;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnCross2Lifetime201908Page extends BasePage {

    //// Constructor ////
    public BurnCross2Lifetime201908Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By burnCross2PgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By burnCross2OneTimePriceLocator = By.className("au-a1-1");
    private By burnCross2AddToCartLocator = By.xpath("//a[text()='Add To Cart']");

    //// Methods ////
    @Step("Click on the Add To Cart link")
    public void clickAddToCartLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement addToCartLink = driver.findElements(burnCross2AddToCartLocator).get(index);
        highlightElement(addToCartLink);
        scrollToBottom(addToCartLink);
        addToCartLink.click();
        wait.until(ExpectedConditions.invisibilityOf(addToCartLink));
    }

    @Step("Click on the One Time Delivery Price option")
    public void clickOneTimeDeliveryPriceLabel(){
        Util.waitMilliseconds(1000);
        WebElement oneTimeDeliveryPriceLabel = driver.findElement(burnCross2OneTimePriceLocator);
        wait.until(ExpectedConditions.visibilityOf(oneTimeDeliveryPriceLabel));
        highlightElement(oneTimeDeliveryPriceLabel);
        oneTimeDeliveryPriceLabel.click();
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

    //// Verifiers ////s
    @Step("Verify the Burn Upsell Video Is Displayed")
    public void verifyBurnCross2VideoIsDisplayed() {
        assertTrue(isBurnCross2VideoDisplayed(), "src/test/java/web/pages/sculptnation/BurnCross2Lifetime201908Page.java");
    }
}
