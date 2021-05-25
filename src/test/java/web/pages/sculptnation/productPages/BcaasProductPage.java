package web.pages.sculptnation.productPages;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

public class BcaasProductPage extends BasePage {

    //// Constructor ////
    public BcaasProductPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By bcaasBuyNowButtonLocator = By.xpath("//*[text()='BUY NOW']");
    private By bcaasOneTimePriceLocator = By.className("au-a1-1");
    private By bcaasAddToCartLocator = By.xpath("//a[text()='Add To Cart']");
    private By burnEvolvedAddToCartLocator = By.xpath("//a[text()='Speed Up My Metabolism']");

    //// Methods ////
    @Step("Click on the Speed Up My Metabolism link")
    public void clickSpeedUpMyMetabolismLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement speedUpMyMetabolismLink = driver.findElements(burnEvolvedAddToCartLocator).get(index);
        highlightElement(speedUpMyMetabolismLink);
        scrollToBottom(speedUpMyMetabolismLink);
        speedUpMyMetabolismLink.click();
        wait.until(ExpectedConditions.invisibilityOf(speedUpMyMetabolismLink));
    }

    @Step("Click on the Add To Cart link")
    public void clickAddToCartLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement addToCartLink = driver.findElements(bcaasAddToCartLocator).get(index);
        highlightElement(addToCartLink);
        scrollToBottom(addToCartLink);
        addToCartLink.click();
        wait.until(ExpectedConditions.invisibilityOf(addToCartLink));
    }

    @Step("Click on the One Time Delivery Price option")
    public void clickOneTimeDeliveryPriceLabel(){
        Util.waitMilliseconds(1000);
        WebElement oneTimeDeliveryPriceLabel = driver.findElement(bcaasOneTimePriceLocator);
        wait.until(ExpectedConditions.visibilityOf(oneTimeDeliveryPriceLabel));
        highlightElement(oneTimeDeliveryPriceLabel);
        oneTimeDeliveryPriceLabel.click();
    }

    @Step("Click on the Buy Now button")
    public void clickBuyNowButton(){
        WebElement buyNowButton = driver.findElement(bcaasBuyNowButtonLocator);
        highlightElement(buyNowButton);
        buyNowButton.click();
    }

    //// Getters ////

    //// Setters ////

    //// Verifiers ////
}
