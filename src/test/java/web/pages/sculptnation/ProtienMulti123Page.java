package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ProtienMulti123Page extends BasePage {

    //// Constructor ////
    public ProtienMulti123Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By protnPg123NoThanksLinkLocator = By.xpath("//*[text()='No Thanks, I am perfectly happy waiting to see how things go.']");
    By protnPg123ChocolateBottleImageLocator = By.xpath("//*[text()='No Thanks, I am perfectly happy waiting to see how things go.']");

    //// Methods ////
    @Step("Is Protein Multi CS Page 123 Bottle Image Displayed")
    public boolean isProteinChocolateBottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(protnPg123ChocolateBottleImageLocator));
        WebElement proteinChocolateBottleImage = driver.findElement(protnPg123ChocolateBottleImageLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(proteinChocolateBottleImage));
        return proteinChocolateBottleImage.isDisplayed();
    }

    @Step("Click on the No Thanks link")
    public void clickNoThanksLink() {
        WebElement noThanksLink = driver.findElement(protnPg123NoThanksLinkLocator);
        wait.until(ExpectedConditions.visibilityOf(noThanksLink));
        highlightElement(noThanksLink);
        noThanksLink.click();
        wait.until(ExpectedConditions.invisibilityOf(noThanksLink));
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Protein Multi CS Page 123 Bottle Image Is Displayed")
    public void verifyProteinMultiPg123BottleImageIsDisplayed() {
        assertTrue(isProteinChocolateBottleImageDisplayed(), "Protein Multi CS Page 123 Bottle Image Is NOT Displayed");
    }
}
