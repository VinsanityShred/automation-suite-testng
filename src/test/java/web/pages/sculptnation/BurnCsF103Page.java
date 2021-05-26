package web.pages.sculptnation;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnCsF103Page extends BasePage {

    //// Constructor ////
    public BurnCsF103Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By burnCs103PgBurnEvolvedImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/burn-evolved/img/be-1.png?v=1621872093']");
    private By burnCs103PgOneTimePriceLocator = By.className("au-a1-1");
    private By burnCs103PgAddToCartLocator = By.xpath("//a[text()='Speed Up My Metabolism']");

    //// Methods ////

    @Step("Click on the Speed Up My Metabolism link")
    public void clickSpeedUpMyMetabolismLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement speedUpMyMetabolismLink = driver.findElements(burnCs103PgAddToCartLocator).get(index);
        highlightElement(speedUpMyMetabolismLink);
        scrollToBottom(speedUpMyMetabolismLink);
        speedUpMyMetabolismLink.click();
        wait.until(ExpectedConditions.invisibilityOf(speedUpMyMetabolismLink));
    }

    @Step("Click on the One Time Delivery Price option")
    public void clickOneTimeDeliveryPriceLabel(){
        Util.waitMilliseconds(1000);
        WebElement oneTimeDeliveryPriceLabel = driver.findElement(burnCs103PgOneTimePriceLocator);
        wait.until(ExpectedConditions.visibilityOf(oneTimeDeliveryPriceLabel));
        highlightElement(oneTimeDeliveryPriceLabel);
        oneTimeDeliveryPriceLabel.click();
    }

    @Step("Is Burn Evolved Image Displayed")
    private boolean isBurnEvolvedImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnCs103PgBurnEvolvedImageLocator));
        WebElement burnEvolvedImage = driver.findElement(burnCs103PgBurnEvolvedImageLocator);
        highlightElement(burnEvolvedImage);
        return burnEvolvedImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn Evolved Image Is Displayed")
    public void verifyBurnEvolvedImageIsDisplayed() {
        assertTrue(isBurnEvolvedImageDisplayed(), "Burn Evolved Image NOT Displayed");
    }
}
