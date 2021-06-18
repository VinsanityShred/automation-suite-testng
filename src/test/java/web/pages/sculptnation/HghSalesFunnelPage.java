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
    private By hghBoost6BottlePg111ImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/hgh-cs/img/b-4-v2.png?')]");
    private By hgh6BottleImage116PgImageLocator = By.xpath("//*[@alt='HGH 6 Bottles']");
    private By hghVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By hghDs3BottlePg117ImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/hgh-ds/img/b-2.png?')]");

    //// Methods ////
    @Step("Is HGH 3 Bottle Image Page 117 Image Displayed")
    private boolean isHgh3Bottle117PgImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hghDs3BottlePg117ImageLocator));
        WebElement hgh3Bottle117PgImage = driver.findElement(hghDs3BottlePg117ImageLocator);
        highlightElement(hgh3Bottle117PgImage);
        return hgh3Bottle117PgImage.isDisplayed();
    }

    @Step("Is HGH VSL CS Page 87 Video Displayed")
    private boolean isHghVslCsPg87VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hghVideoLocator));
        WebElement hghVslCsPg87Video = driver.findElement(hghVideoLocator);
        highlightElement(hghVslCsPg87Video);
        return hghVslCsPg87Video.isDisplayed();
    }

    @Step("Is HGH VSL CS Page 83 Video Displayed")
    private boolean isHghVslCsPg83VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hghVideoLocator));
        WebElement hghVslCsPg83Video = driver.findElement(hghVideoLocator);
        highlightElement(hghVslCsPg83Video);
        return hghVslCsPg83Video.isDisplayed();
    }

    @Step("Is HGH 6 Bottle Image Page 116 Image Displayed")
    private boolean isHgh6Bottle116PgImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hgh6BottleImage116PgImageLocator));
        WebElement hgh6Bottle116PgImage = driver.findElement(hgh6BottleImage116PgImageLocator);
        highlightElement(hgh6Bottle116PgImage);
        return hgh6Bottle116PgImage.isDisplayed();
    }

    @Step("Is Hgh Boost 6 Bottle Image Displayed")
    private boolean isHghBoost6BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hghBoost6BottlePg111ImageLocator));
        WebElement hghBoost6BottleImage = driver.findElement(hghBoost6BottlePg111ImageLocator);
        highlightElement(hghBoost6BottleImage);
        return hghBoost6BottleImage.isDisplayed();
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
    @Step("Verify the HGH 3 Bottle Page 117 Image Is Displayed")
    public void verifyHgh3BottlePg117ImageIsDisplayed() {
        assertTrue(isHgh3Bottle117PgImageDisplayed(), "HGH 3 Bottle Page 117 Image NOT Displayed");
    }

    @Step("Verify the HGH VSL CS Page 87 Video Is Displayed")
    public void verifyHghVslCsPg87VideoIsDisplayed() {
        assertTrue(isHghVslCsPg87VideoDisplayed(), "HGH VSL CS Page 87 Video NOT Displayed");
    }

    @Step("Verify the HGH VSL CS Page 83 Video Is Displayed")
    public void verifyHghVslCsPg83VideoIsDisplayed() {
        assertTrue(isHghVslCsPg83VideoDisplayed(), "HGH VSL CS Page 83 Video NOT Displayed");
    }

    @Step("Verify the HGH 6 Bottle Page 116 Image Is Displayed")
    public void verifyHgh6BottlePg116ImageIsDisplayed() {
        assertTrue(isHgh6Bottle116PgImageDisplayed(), "HGH 6 Bottle Page 116 Image NOT Displayed");
    }

    @Step("Verify the Hgh Boost 6 Bottle image Is Displayed")
    public void verifyHghBoost6BottleImageIsDisplayed() {
        assertTrue(isHghBoost6BottleImageDisplayed(), "Hgh Boost 6 Bottle Image NOT Displayed");
    }

    @Step("Verify the HGH CS Page 108 Image Is Displayed")
    public void verifyHghCSPg108ImageIsDisplayed() {
        assertTrue(isHghCSPg108ImageDisplayed(), "HGH CS Page 108 Image NOT Displayed");
    }
}
