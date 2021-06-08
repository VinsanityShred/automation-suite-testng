package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class HghSalesFunnelPage extends BasePage {

    //// Constructor ////
    public HghSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By HghCsPg108ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/hgh-cs/img/b-4-v2.png?v=1622589211']");
    private By hghBoostPgImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/hgh-cs/img/b-4-v2.png?v=1622481188']");
    private By hgh116PgImageLocator = By.xpath("//*[@alt='HGH 6 Bottles']");
    private By hghVslCsPg83VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By hghVslCs87PgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is HGH VSL CS Page 87 Video Displayed")
    private boolean isHghVslCsPg87VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hghVslCs87PgVideoLocator));
        WebElement hghVslCsPg87Video = driver.findElement(hghVslCs87PgVideoLocator);
        highlightElement(hghVslCsPg87Video);
        return hghVslCsPg87Video.isDisplayed();
    }

    @Step("Is HGH VSL CS Page 83 Video Displayed")
    private boolean isHghVslCsPg83VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hghVslCsPg83VideoLocator));
        WebElement hghVslCsPg83Video = driver.findElement(hghVslCsPg83VideoLocator);
        highlightElement(hghVslCsPg83Video);
        return hghVslCsPg83Video.isDisplayed();
    }

    @Step("Is HGH Page 116 Image Displayed")
    private boolean isHgh116PgImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hgh116PgImageLocator));
        WebElement hgh116PgImage = driver.findElement(hgh116PgImageLocator);
        highlightElement(hgh116PgImage);
        return hgh116PgImage.isDisplayed();
    }

    @Step("Is Hgh Boost Image Displayed")
    private boolean isHghBoostImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hghBoostPgImageLocator));
        WebElement hghBoostImage = driver.findElement(hghBoostPgImageLocator);
        highlightElement(hghBoostImage);
        return hghBoostImage.isDisplayed();
    }

    @Step("Is HGH CS Page 108 Image Displayed")
    private boolean isHghCSPg108ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HghCsPg108ImageLocator));
        WebElement hghCSPg108Image = driver.findElement(HghCsPg108ImageLocator);
        highlightElement(hghCSPg108Image);
        return hghCSPg108Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the HGH VSL CS Page 87 Video Is Displayed")
    public void verifyHghVslCsPg87VideoIsDisplayed() {
        assertTrue(isHghVslCsPg87VideoDisplayed(), "HGH VSL CS Page 87 Video NOT Displayed");
    }

    @Step("Verify the HGH VSL CS Page 83 Video Is Displayed")
    public void verifyHghVslCsPg83VideoIsDisplayed() {
        assertTrue(isHghVslCsPg83VideoDisplayed(), "HGH VSL CS Page 83 Video NOT Displayed");
    }

    @Step("Verify the HGH Page 116 Image Is Displayed")
    public void verifyHghPg116ImageIsDisplayed() {
        assertTrue(isHgh116PgImageDisplayed(), "HGH Page 116 Image NOT Displayed");
    }

    @Step("Verify the Hgh Boost image Is Displayed")
    public void verifyHghBoostImageIsDisplayed() {
        assertTrue(isHghBoostImageDisplayed(), "Hgh Boost Image NOT Displayed");
    }

    @Step("Verify the HGH CS Page 108 Image Is Displayed")
    public void verifyHghCSPg108ImageIsDisplayed() {
        assertTrue(isHghCSPg108ImageDisplayed(), "HGH CS Page 108 Image NOT Displayed");
    }
}
