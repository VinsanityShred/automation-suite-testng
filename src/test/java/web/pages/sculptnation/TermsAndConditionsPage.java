package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class TermsAndConditionsPage extends BasePage {

    //// Constructor ////
    public TermsAndConditionsPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By trmsPgHeaderLocator = By.xpath("//h3[text()='Terms and Conditions']");
    By trmsPgHeader1Locator = By.xpath("//u[text()='Access to the Website and Restrictions on Your Use']");
    By trmsPgHeader2Locator = By.xpath("//u[text()='Privacy Policy']");

    //// Methods ////
    @Step("Is Terms Page Header 2 Displayed")
    public boolean isTermsPgHeader2Displayed() {
        WebElement termsPgHeader2 = driver.findElement(trmsPgHeader2Locator);
        highlightElement(termsPgHeader2);
        scrollToMiddle(termsPgHeader2);
        return termsPgHeader2.isDisplayed();
    }

    @Step("Is Terms Page Header 1 Displayed")
    public boolean isTermsPgHeader1Displayed() {
        WebElement termsPgHeader1 = driver.findElement(trmsPgHeader1Locator);
        highlightElement(termsPgHeader1);
        scrollToMiddle(termsPgHeader1);
        return termsPgHeader1.isDisplayed();
    }

    @Step("Is Terms Page Header Displayed")
    public boolean isTermsPgHeaderDisplayed() {
        WebElement termsPgHeader = driver.findElement(trmsPgHeaderLocator);
        highlightElement(termsPgHeader);
        scrollToMiddle(termsPgHeader);
        return termsPgHeader.isDisplayed();
    }





    //// Setters ////

    //// Getters ////

    //// Verifiers ////s
    @Step("Verify is the Terms page header displayed")
    public void verifyTermsPgHeader1To34IsDisplayed() {
        assertTrue(isTermsPgHeader1Displayed(), "Terms Page Header 1 Is NOT Displayed");
        assertTrue(isTermsPgHeader2Displayed(), "Terms Page Header 2 Is NOT Displayed");
    }

    @Step("Verify is the Terms page header displayed")
    public void verifyTermsPgHeaderIsDisplayed() {
        assertTrue(isTermsPgHeaderDisplayed(), "Terms Page Header Is NOT Displayed");
    }

}
