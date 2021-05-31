package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class EnzymesUsF157Page extends BasePage {

    //// Constructor ////
    public EnzymesUsF157Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By enymsUs157PgEnzymesImageLocator = By.xpath("//*[@alt='Enzymes 6 Bottles']");

    //// Methods ////
    @Step("Is Enzymes Image Displayed")
    private boolean isEnzymesImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enymsUs157PgEnzymesImageLocator));
        WebElement bcaasImage = driver.findElement(enymsUs157PgEnzymesImageLocator);
        highlightElement(bcaasImage);
        return bcaasImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Enzymes Image Is Displayed")
    public void verifyEnzymesImageIsDisplayed() {
        assertTrue(isEnzymesImageDisplayed(), "Enzymes Image NOT Displayed");
    }
}
