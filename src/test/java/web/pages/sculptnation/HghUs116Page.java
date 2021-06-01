package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class HghUs116Page extends BasePage {

    //// Constructor ////
    public HghUs116Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By hgh116PgImageLocator = By.xpath("//*[@alt='HGH 6 Bottles']");

    //// Methods ////
    @Step("Is HGH Page 116 Image Displayed")
    private boolean isHgh116PgImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hgh116PgImageLocator));
        WebElement hgh116PgImage = driver.findElement(hgh116PgImageLocator);
        highlightElement(hgh116PgImage);
        return hgh116PgImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the HGH Page 116 Image Is Displayed")
    public void verifyHghPg116ImageIsDisplayed() {
        assertTrue(isHgh116PgImageDisplayed(), "HGH Page 116 Image NOT Displayed");
    }
}
