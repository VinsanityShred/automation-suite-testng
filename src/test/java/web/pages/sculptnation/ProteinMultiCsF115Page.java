package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ProteinMultiCsF115Page extends BasePage {

    //// Constructor ////
    public ProteinMultiCsF115Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By prtnMultCs115PgChocolateImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/protein-multi-cs/img/b-2.png?v=1621872093']");

    //// Methods ////

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    //// Methods ////
    @Step("Is Protein Chocolate Image Displayed")
    private boolean isProteinChocolateImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(prtnMultCs115PgChocolateImageLocator));
        WebElement proteinChocolateImage = driver.findElement(prtnMultCs115PgChocolateImageLocator);
        highlightElement(proteinChocolateImage);
        return proteinChocolateImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Protein Chocolate Image Is Displayed")
    public void verifyProteinChocolateImageIsDisplayed() {
        assertTrue(isProteinChocolateImageDisplayed(), "Protein Chocolate Image NOT Displayed");
    }
}
