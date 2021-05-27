package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BcaaCsF114Page extends BasePage {

    //// Constructor ////
    public BcaaCsF114Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By bcaasCs114PgImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/3/BCAAs_three/BCAAs_three.png?v=1621872093']");

    //// Methods ////
    @Step("Is Bcaas Image Displayed")
    private boolean isBcaasImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bcaasCs114PgImageLocator));
        WebElement bcaasImage = driver.findElement(bcaasCs114PgImageLocator);
        highlightElement(bcaasImage);
        return bcaasImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Bcaas Image Is Displayed")
    public void verifyBcaasImageIsDisplayed() {
        assertTrue(isBcaasImageDisplayed(), "Bcaas Image NOT Displayed");
    }
}
