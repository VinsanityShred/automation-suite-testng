package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CreatineCs122Page extends BasePage {

    //// Constructor ////
    public CreatineCs122Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By crtn122PgNoThanksLinkLocator = By.xpath("//*[text()='No Thanks, I am perfectly happy waiting to see how things go.']");
    By crtn122PgBottleImageLocator = By.xpath("//*[text()='No Thanks, I am perfectly happy waiting to see how things go.']");

    //// Methods ////
    @Step("Is Creatine Bottle Image Displayed")
    public boolean isCreatineBottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(crtn122PgBottleImageLocator));
        WebElement creatineBottleImage = driver.findElement(crtn122PgBottleImageLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(creatineBottleImage));
        return creatineBottleImage.isDisplayed();
    }

    @Step("Click on the No Thanks link")
    public void clickNoThanksLink() {
        WebElement noThanksLink = driver.findElement(crtn122PgNoThanksLinkLocator);
        wait.until(ExpectedConditions.visibilityOf(noThanksLink));
        highlightElement(noThanksLink);
        noThanksLink.click();
        wait.until(ExpectedConditions.invisibilityOf(noThanksLink));
    }


    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Creatine Bottle Image Is Displayed")
    public void verifyCreatineBottleImageIsDisplayed() {
        assertTrue(isCreatineBottleImageDisplayed(), "Creatine Bottle Image Is NOT Displayed");
    }
}
