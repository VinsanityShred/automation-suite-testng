package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class HghCs111Page extends BasePage {

    //// Constructor ////
    public HghCs111Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By hghBoostPgImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/hgh-cs/img/b-4-v2.png?v=1622481188']");

    //// Methods ////
    @Step("Is Hgh Boost Image Displayed")
    private boolean isHghBoostImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hghBoostPgImageLocator));
        WebElement hghBoostImage = driver.findElement(hghBoostPgImageLocator);
        highlightElement(hghBoostImage);
        return hghBoostImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Hgh Boost image Is Displayed")
    public void verifyHghBoostImageIsDisplayed() {
        assertTrue(isHghBoostImageDisplayed(), "Hgh Boost Image NOT Displayed");
    }
}
