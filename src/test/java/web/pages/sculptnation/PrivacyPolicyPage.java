package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class PrivacyPolicyPage extends BasePage {

    //// Constructor ////
    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By prvcyPgHeaderLocator = By.xpath("//h3[text()='Privacy Policy']");
    By prvcyPgHeader1Locator = By.xpath("//h3[text()='1. UPDATES TO OUR PRIVACY POLICY']");
    By prvcyPgHeader2Locator = By.xpath("//h3[text()='2. PERSONAL INFORMATION WE COLLECT']");
    By prvcyPgHeader3Locator = By.xpath("//h3[text()='3. PURPOSES AND LEGAL BASIS FOR PROCESSING PERSONAL INFORMATION']");
    By prvcyPgHeader4Locator = By.xpath("//h3[text()='4. PERSONAL INFORMATION WE SHARE']");
    By prvcyPgHeader5Locator = By.xpath("//h3[text()='5. LINKS TO OTHER WEBSITES']");
    By prvcyPgHeader6Locator = By.xpath("//h3[text()='6. THIRD-PARTY ADVERTISEMENTS']");
    By prvcyPgHeader7Locator = By.xpath("//h3[text()='7. HOW WE PROTECT PERSONAL INFORMATION']");
    By prvcyPgHeader8Locator = By.xpath("//h3[text()='8. CHILDREN’S PRIVACY']");
    By prvcyPgHeader9Locator = By.xpath("//h3[text()='9. YOUR RIGHTS – ACCESS & CORRECTION']");
    By prvcyPgHeader10Locator = By.xpath("//h3[text()='10. RETENTION OF PERSONAL INFORMATION']");
    By prvcyPgHeader11Locator = By.xpath("//h3[text()='11. HOW TO CONTACT US']");
    By prvcyPgHeader12Locator = By.xpath("//h3[text()='12. California Consumer Privacy Act - Notices and Rights for California Consumers']");

    //// Methods ////
    @Step("Is Privacy and Policy header 12 displayed")
    public boolean isPrivacyPolicyHeaders12Displayed() {
        WebElement privacyPolicyHeader12 = driver.findElement(prvcyPgHeader12Locator);
        highlightElement(privacyPolicyHeader12);
        scrollToMiddle(privacyPolicyHeader12);
        return privacyPolicyHeader12.isDisplayed();
    }

    @Step("Is Privacy and Policy header 11 displayed")
    public boolean isPrivacyPolicyHeaders11Displayed() {
        WebElement privacyPolicyHeader11 = driver.findElement(prvcyPgHeader11Locator);
        highlightElement(privacyPolicyHeader11);
        scrollToMiddle(privacyPolicyHeader11);
        return privacyPolicyHeader11.isDisplayed();
    }

    @Step("Is Privacy and Policy header 10 displayed")
    public boolean isPrivacyPolicyHeaders10Displayed() {
        WebElement privacyPolicyHeader10 = driver.findElement(prvcyPgHeader10Locator);
        highlightElement(privacyPolicyHeader10);
        scrollToMiddle(privacyPolicyHeader10);
        return privacyPolicyHeader10.isDisplayed();
    }

    @Step("Is Privacy and Policy header 9 displayed")
    public boolean isPrivacyPolicyHeaders9Displayed() {
        WebElement privacyPolicyHeader9 = driver.findElement(prvcyPgHeader9Locator);
        highlightElement(privacyPolicyHeader9);
        scrollToMiddle(privacyPolicyHeader9);
        return privacyPolicyHeader9.isDisplayed();
    }

    @Step("Is Privacy and Policy header 8 displayed")
    public boolean isPrivacyPolicyHeaders8Displayed() {
        WebElement privacyPolicyHeader8 = driver.findElement(prvcyPgHeader8Locator);
        highlightElement(privacyPolicyHeader8);
        scrollToMiddle(privacyPolicyHeader8);
        return privacyPolicyHeader8.isDisplayed();
    }

    @Step("Is Privacy and Policy header 7 displayed")
    public boolean isPrivacyPolicyHeaders7Displayed() {
        WebElement privacyPolicyHeader7 = driver.findElement(prvcyPgHeader7Locator);
        highlightElement(privacyPolicyHeader7);
        scrollToMiddle(privacyPolicyHeader7);
        return privacyPolicyHeader7.isDisplayed();
    }

    @Step("Is Privacy and Policy header 6 displayed")
    public boolean isPrivacyPolicyHeaders6Displayed() {
        WebElement privacyPolicyHeader6 = driver.findElement(prvcyPgHeader6Locator);
        highlightElement(privacyPolicyHeader6);
        scrollToMiddle(privacyPolicyHeader6);
        return privacyPolicyHeader6.isDisplayed();
    }

    @Step("Is Privacy and Policy header 5 displayed")
    public boolean isPrivacyPolicyHeaders5Displayed() {
        WebElement privacyPolicyHeader5 = driver.findElement(prvcyPgHeader5Locator);
        highlightElement(privacyPolicyHeader5);
        scrollToMiddle(privacyPolicyHeader5);
        return privacyPolicyHeader5.isDisplayed();
    }

    @Step("Is Privacy and Policy header 4 displayed")
    public boolean isPrivacyPolicyHeaders4Displayed() {
        WebElement privacyPolicyHeader4 = driver.findElement(prvcyPgHeader4Locator);
        highlightElement(privacyPolicyHeader4);
        scrollToMiddle(privacyPolicyHeader4);
        return privacyPolicyHeader4.isDisplayed();
    }

    @Step("Is Privacy and Policy header 3 displayed")
    public boolean isPrivacyPolicyHeaders3Displayed() {
        WebElement privacyPolicyHeader3 = driver.findElement(prvcyPgHeader3Locator);
        highlightElement(privacyPolicyHeader3);
        scrollToMiddle(privacyPolicyHeader3);
        return privacyPolicyHeader3.isDisplayed();
    }

    @Step("Is Privacy and Policy header 2 displayed")
    public boolean isPrivacyPolicyHeaders2Displayed() {
        WebElement privacyPolicyHeader2 = driver.findElement(prvcyPgHeader2Locator);
        highlightElement(privacyPolicyHeader2);
        scrollToMiddle(privacyPolicyHeader2);
        return privacyPolicyHeader2.isDisplayed();
    }

    @Step("Is Privacy and Policy header 1 displayed")
    public boolean isPrivacyPolicyHeaders1Displayed() {
        WebElement privacyPolicyHeader1 = driver.findElement(prvcyPgHeader1Locator);
        highlightElement(privacyPolicyHeader1);
        scrollToMiddle(privacyPolicyHeader1);
        return privacyPolicyHeader1.isDisplayed();
    }

    @Step("Is Privacy and Policy header displayed")
    public boolean isPrivacyPolicyHeaderDisplayed() {
        WebElement privacyPolicyHeader = driver.findElement(prvcyPgHeaderLocator);
        highlightElement(privacyPolicyHeader);
        return privacyPolicyHeader.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Check: Verify the Privacy and Policy Header Is Displayed")
    public void verifyPrivacyPolicyHeaders1To12Displayed() {
        assertTrue(isPrivacyPolicyHeaders1Displayed(), "Privacy And Policy Header 1 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders2Displayed(), "Privacy And Policy Header 2 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders3Displayed(), "Privacy And Policy Header 3 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders4Displayed(), "Privacy And Policy Header 4 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders5Displayed(), "Privacy And Policy Header 5 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders6Displayed(), "Privacy And Policy Header 6 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders7Displayed(), "Privacy And Policy Header 7 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders8Displayed(), "Privacy And Policy Header 8 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders9Displayed(), "Privacy And Policy Header 9 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders10Displayed(), "Privacy And Policy Header 10 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders11Displayed(), "Privacy And Policy Header 11 NOT Displayed");
        assertTrue(isPrivacyPolicyHeaders12Displayed(), "Privacy And Policy Header 12 NOT Displayed");
    }

    @Step("Check: Verify the Privacy and Policy Header Is Displayed")
    public void verifyPrivacyPolicyHeaderDisplayed() {
        assertTrue(isPrivacyPolicyHeaderDisplayed(), "Privacy And Policy Header NOT Displayed");
    }
}
