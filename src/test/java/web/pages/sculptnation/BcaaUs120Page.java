package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BcaaUs120Page extends BasePage {

    //// Constructor ////
    public BcaaUs120Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By bcaa120PgNoThanksLinkLocator = By.xpath("//*[text()='No thanks, I will pass on this HUGE savings for now realizing I will NEVER have this opportunity again']");
    By bcca120PgBcaaImageLocator = By.xpath("//img[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/6/BCAAs - Back/BCAAs---Back.png?v=1620766109']");
    private By bccaaUs120Pg6BottleImageLocator = By.xpath("//img[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/6/BCAAS_six/BCAAS_six.png?v=1622744888']");

    //// Methods ////
    @Step("Click on the No Thanks link")
    public void clickNoThanksLink() {
        WebElement noThanksLink = driver.findElement(bcaa120PgNoThanksLinkLocator);
        wait.until(ExpectedConditions.visibilityOf(noThanksLink));
        highlightElement(noThanksLink);
        noThanksLink.click();
        wait.until(ExpectedConditions.invisibilityOf(noThanksLink));
    }

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

}
