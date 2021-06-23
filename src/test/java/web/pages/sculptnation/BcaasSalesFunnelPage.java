package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BcaasSalesFunnelPage extends BasePage {

    //// Constructor ////
    public BcaasSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By bcaaCs99Pg3BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/media/offers/3/BCAAs_three/BCAAs_three.png?')]");
    private By bcaasCs114PgImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/media/offers/3/BCAAs_three/BCAAs_three.png?')]");
    private By bcca120PgBcaaImageLocator = By.xpath("//img[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/6/BCAAs - Back/BCAAs---Back.png?v=1620766109']");
    private By bccaaUs120Pg6BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/media/offers/6/BCAAS_six/BCAAS_six.png?')]");


    //// Methods ////
    @Step("Is Bcaa Image Displayed")
    public boolean bcaaImageIsDisplayed() {
        WebElement bcaaImage = driver.findElement(bcca120PgBcaaImageLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(bcaaImage));
        return bcaaImage.isDisplayed();
    }

    @Step("Is Bcaas 6 Bottle Image Displayed")
    public boolean isBcaas6BottleImageDisplayed() {
        WebElement bcaas6BottleImage = driver.findElement(bccaaUs120Pg6BottleImageLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(bcaas6BottleImage));
        return bcaas6BottleImage.isDisplayed();
    }

    @Step("Is Bcaas 3 Bottles Image Displayed")
    private boolean isBcaasImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bcaasCs114PgImageLocator));
        WebElement bcaasImage = driver.findElement(bcaasCs114PgImageLocator);
        highlightElement(bcaasImage);
        return bcaasImage.isDisplayed();
    }

    @Step("Is Bcaas Page 99 3 Bottle Image Displayed")
    private boolean isBcaas99Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bcaaCs99Pg3BottleImageLocator));
        WebElement bcaas99Pg3BottleImage = driver.findElement(bcaaCs99Pg3BottleImageLocator);
        highlightElement(bcaas99Pg3BottleImage);
        return bcaas99Pg3BottleImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Bcaas 6 Bottle Image Is Displayed")
    public void verifyBcaas6BottleImageIsDisplayed() {
        assertTrue(isBcaas6BottleImageDisplayed(), "Bcaas 6 Bottle Image Is NOT Displayed");
    }

    @Step("Verify the Bcaa Image Is Displayed")
    public void verifyBcaaImageIsDisplayed() {
        assertTrue(bcaaImageIsDisplayed(), "Bcaa Image Is NOT Displayed");
    }

    @Step("Verify the Bcaas 3 Bottles Image Is Displayed")
    public void verifyBcaasImageIsDisplayed() {
        assertTrue(isBcaasImageDisplayed(), "Bcaas 3 Bottles Image NOT Displayed");
    }

    @Step("Verify the Bcaas Page 99 3 Bottle Image Is Displayed")
    public void verifyBcaas99Pg3BottleImageIsDisplayed() {
        assertTrue(isBcaas99Pg3BottleImageDisplayed(), "Bcaas Page 99 3 Bottle Image NOT Displayed");
    }
}
