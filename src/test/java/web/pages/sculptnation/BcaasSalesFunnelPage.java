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
    private By bcaaCsPg99ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/3/BCAAs_three/BCAAs_three.png?v=1622589211']");
    private By bcaasCs114PgImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/3/BCAAs_three/BCAAs_three.png?v=1621872093']");
    private By bcca120PgBcaaImageLocator = By.xpath("//img[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/6/BCAAs - Back/BCAAs---Back.png?v=1620766109']");
    private By bccaaUs120Pg6BottleImageLocator = By.xpath("//img[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/6/BCAAS_six/BCAAS_six.png?v=1622744888']");


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

    @Step("Is Bcaas Image Displayed")
    private boolean isBcaasImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bcaasCs114PgImageLocator));
        WebElement bcaasImage = driver.findElement(bcaasCs114PgImageLocator);
        highlightElement(bcaasImage);
        return bcaasImage.isDisplayed();
    }

    @Step("Is Bcaas Page 99 Image Displayed")
    private boolean isBcaasPg99ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bcaaCsPg99ImageLocator));
        WebElement bcaasPg99Image = driver.findElement(bcaaCsPg99ImageLocator);
        highlightElement(bcaasPg99Image);
        return bcaasPg99Image.isDisplayed();
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

    @Step("Verify the Bcaas Image Is Displayed")
    public void verifyBcaasImageIsDisplayed() {
        assertTrue(isBcaasImageDisplayed(), "Bcaas Image NOT Displayed");
    }

    @Step("Verify the Bcaas Page 99 Image Is Displayed")
    public void verifyBcaasPg99ImageIsDisplayed() {
        assertTrue(isBcaasPg99ImageDisplayed(), "Bcaas Page 99 Image NOT Displayed");
    }
}
