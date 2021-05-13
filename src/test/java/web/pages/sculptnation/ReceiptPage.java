package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReceiptPage extends BasePage {

    //// Constructor ////
    public ReceiptPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By rcptPgThankYouHeaderLocator = By.xpath("//h2[text()='Thank you for your orders!']");
    By rcptPgTotalLocator = By.xpath("//*[@class='text-danger total-text']");

    //// Methods ////
    @Step("Is Thank You Header Displayed")
    public boolean isThankYouHeaderDisplayed() {
        WebElement thankYouHeader = driver.findElement(rcptPgThankYouHeaderLocator);
        highlightElement(thankYouHeader);
        return thankYouHeader.isDisplayed();
    }

    //// Setters ////

    //// Getters ////
    @Step("Get Receipt Page Total")
    private String getReceiptPgTotal() {
        WebElement receiptPgTotal = driver.findElement(rcptPgTotalLocator);
        highlightElement(receiptPgTotal);
        return receiptPgTotal.getText();
    }

    //// Verifiers ////
    @Step("Verify Receipt Page Total IS a Match")
    public void verifyReceiptPgTotalsMatch(String expectedTotal) {
        assertEquals(getReceiptPgTotal(), expectedTotal);
    }

    @Step("Verify Receipt Page Header IS Displayed")
    public void verifyReceiptPgHeaderIsDisplayed() {
        assertTrue(isThankYouHeaderDisplayed(), "Thank You Header Is NOT Displayed");
    }
}
