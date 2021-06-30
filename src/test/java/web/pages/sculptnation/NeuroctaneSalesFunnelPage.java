package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class NeuroctaneSalesFunnelPage extends BasePage {

    //// Constructor ////
    public NeuroctaneSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By nuroct132PgImageLocator = By.xpath("//*[@alt='Neuroctane']");
    private By neuroctane105Pg6BottlesImageLocator = By.xpath("//*[@alt='Neuroctane 6 Bottles']");
    private By neuroctane106Pg3BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/neuroctane-ds/img/b-2.png?')]");


    //// Methods ////
    @Step("Is Neuroctane Page 106 3 Bottle Image Displayed")
    private boolean isNeuroctane106Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(neuroctane106Pg3BottleImageLocator));
        WebElement neuroctane106Pg3BottleImage = driver.findElement(neuroctane106Pg3BottleImageLocator);
        highlightElement(neuroctane106Pg3BottleImage);
        return neuroctane106Pg3BottleImage.isDisplayed();
    }

    @Step("Is Neuroctane Page 105 6 Bottles Image Displayed")
    private boolean isNeuroctane105Pg6BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(neuroctane105Pg6BottlesImageLocator));
        WebElement neuroctane105Pg6BottleImage = driver.findElement(neuroctane105Pg6BottlesImageLocator);
        highlightElement(neuroctane105Pg6BottleImage);
        return neuroctane105Pg6BottleImage.isDisplayed();
    }

    @Step("Is Neuroctane Image Displayed")
    private boolean isNeuroctaneImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nuroct132PgImageLocator));
        WebElement neuroctaneImage = driver.findElement(nuroct132PgImageLocator);
        highlightElement(neuroctaneImage);
        return neuroctaneImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Neuroctane Page 106 3 Bottle Image Is Displayed")
    public void verifyNeuroctane106Pg3BottleImageIsDisplayed() {
        assertTrue(isNeuroctane106Pg3BottleImageDisplayed(), "Neuroctane Page 106 3 Bottle Image NOT Displayed");
    }

    @Step("Verify the Neuroctane Page 105 6 Bottles Image Is Displayed")
    public void verifyNeuroctane105Pg6BottleImageIsDisplayed() {
        assertTrue(isNeuroctane105Pg6BottleImageDisplayed(), "Neuroctane Page 105 6 Bottles Image NOT Displayed");
    }

    @Step("Verify the Neuroctane Image Is Displayed")
    public void verifyNeuroctaneImageIsDisplayed() {
        assertTrue(isNeuroctaneImageDisplayed(), "Neuroctane Image NOT Displayed");
    }
}
