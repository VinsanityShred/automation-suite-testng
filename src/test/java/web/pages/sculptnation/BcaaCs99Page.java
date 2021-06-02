package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class BcaaCs99Page extends BasePage {

    //// Constructor ////
    public BcaaCs99Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By bcaaCsPg99ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/3/BCAAs_three/BCAAs_three.png?v=1622589211']");

    //// Methods ////
    @Step("Is Bcaas Page 99 Image Displayed")
    private boolean isBcaasPg99ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bcaaCsPg99ImageLocator));
        WebElement bcaasPg99Image = driver.findElement(bcaaCsPg99ImageLocator);
        highlightElement(bcaasPg99Image);
        return bcaasPg99Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Bcaas Page 99 Image Is Displayed")
    public void verifyBcaasPg99ImageIsDisplayed() {
        assertTrue(isBcaasPg99ImageDisplayed(), "Bcaas Page 99 Image NOT Displayed");
    }
}
