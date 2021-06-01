package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BurnCs118Page extends BasePage {

    //// Constructor ////
    public BurnCs118Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By burnCs118PgImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/burn-evolved/img/be-1.png?v=1622581155']");

    //// Methods ////
    @Step("Is Burn Page 118 Image Displayed")
    private boolean isBurnPg118ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burnCs118PgImageLocator));
        WebElement burnPg118Image = driver.findElement(burnCs118PgImageLocator);
        highlightElement(burnPg118Image);
        return burnPg118Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Burn Page 118 Image Is Displayed")
    public void verifyBurnPg118ImageIsDisplayed() {
        assertTrue(isBurnPg118ImageDisplayed(), "Burn Page 118 Image NOT Displayed");
    }
}
