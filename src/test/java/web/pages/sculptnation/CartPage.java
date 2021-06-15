package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CartPage extends BasePage {

    //// Constructor ////
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By cartPgEmptyCartIconLocator = By.xpath("//*[@class='fas fa-shopping-cart empty-cart']");
    private By cartPgCartTableLocator = By.className("cart-items-table");
    private By cartPgProceedToCheckoutButtonLocator = By.xpath("//*[@href='/checkout']");

    //// Methods ////
    @Step("Click on the Proceed To Checkout Button")
    public void clickProceedToCheckoutButton() {
        WebElement proceedToCheckoutButton = driver.findElement(cartPgProceedToCheckoutButtonLocator);
        highlightElement(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        wait.until(ExpectedConditions.invisibilityOf(proceedToCheckoutButton));
    }

    @Step("Is Cart Table displayed")
    private boolean isCartTableDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPgCartTableLocator));
        WebElement cartTableDisplayed = driver.findElement(cartPgCartTableLocator);
        highlightElement(cartTableDisplayed);
        return cartTableDisplayed.isDisplayed();
    }

    @Step("Is Empty Card Logo Displayed")
    private boolean isEmptyCartLogoDisplayed() {
        WebElement emptyCartLogo = driver.findElement(cartPgEmptyCartIconLocator);
        highlightElement(emptyCartLogo);
        return emptyCartLogo.isDisplayed();
    }

    //// Getters ////


    //// Setters ////

    //// Verifiers ////
    @Step("Check: Verify the empty cart table is displayed")
    public void verifyCartTableIsDisplayed() {
        assertTrue(isCartTableDisplayed(), "Empty Cart Table NOT Displayed");
    }

    @Step("Check: Verify the empty cart logo is displayed")
    public void verifyEmptyCartLogoIsDisplayed() {
        assertTrue(isEmptyCartLogoDisplayed(), "Empty Cart Logo NOT Displayed");
    }

}
