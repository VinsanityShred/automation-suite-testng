package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ShippingAndReturnsPage extends BasePage {

    //// Constructor ////
    public ShippingAndReturnsPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By shpgRtrnPgHeaderLocator = By.xpath("//h3[text()='Shipping and Returns']");

    //// Methods ////
    @Step("Is Shipping and Return header displayed")
    public boolean isShippingReturnHeaderDisplayed() {
        WebElement shippingReturnHeader = driver.findElement(shpgRtrnPgHeaderLocator);
        highlightElement(shippingReturnHeader);
        return shippingReturnHeader.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Check: Verify the Watch Video Link Is Displayed")
    public void verifyShippingReturnHeaderDisplayed() {
        assertTrue(isShippingReturnHeaderDisplayed(), "Shipping And Return Header NOT Displayed");
    }

}
