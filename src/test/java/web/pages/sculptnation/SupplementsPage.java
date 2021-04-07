package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class SupplementsPage extends BasePage {

    //// Constructor ////
    public SupplementsPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By productCardLocator = By.className("card-body");

    //// Methods ////
    @Step("Is Product Card Displayed")
    private boolean isProductCardDisplayed() {
        WebElement productCard = driver.findElements(productCardLocator).get(0);
        highlightElement(productCard);
        return productCard.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Check: Verify a product card is displayed")
    public void verifyProductCardIsDisplayed() {
        assertTrue(isProductCardDisplayed(), "Product Card NOT Displayed");
    }
}
