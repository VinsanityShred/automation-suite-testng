package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class GreensMultiCs110Page extends BasePage {

    //// Constructor ////
    public GreensMultiCs110Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By greenMulti110PgImageLocator = By.xpath("//*[@class='col-12 col-md-4 col-lg-4 offset-lg-1']");

    //// Methods ////
    @Step("Is Green Multi Image Displayed")
    private boolean isGreenMultiImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(greenMulti110PgImageLocator));
        WebElement greenMultiImage = driver.findElement(greenMulti110PgImageLocator);
        highlightElement(greenMultiImage);
        return greenMultiImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Green Multi image Is Displayed")
    public void verifyGreenMultiImageIsDisplayed() {
        assertTrue(isGreenMultiImageDisplayed(), "Green Multi Image NOT Displayed");
    }
}
