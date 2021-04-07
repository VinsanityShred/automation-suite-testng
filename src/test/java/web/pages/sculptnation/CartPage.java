package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CartPage extends BasePage {

    //// Constructor ////
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By cartPgEmptyCartIconLocator = By.xpath("//*[@class='fas fa-shopping-cart empty-cart']");

    //// Methods ////
    @Step("Is Empty Card Logo Displayed")
    private boolean isEmptyCartLogoDisplayed() {
        WebElement emptyCartLogo = driver.findElement(cartPgEmptyCartIconLocator);
        highlightElement(emptyCartLogo);
        return emptyCartLogo.isDisplayed();
    }

    //// Setters ////

    //// Verifiers ////
    @Step("Check: Verify the empty cart logo is displayed")
    public void verifyEmptyCartLogoIsDisplayed() {
        assertTrue(isEmptyCartLogoDisplayed(), "Empty Cart Logo NOT Displayed");
    }

}
