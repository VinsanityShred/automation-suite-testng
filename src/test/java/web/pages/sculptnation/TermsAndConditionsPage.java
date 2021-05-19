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
    By trmsPgHeader3Locator = By.xpath("//u[text()='Purchasing Items Featured on our Website']");
    By trmsPgHeader4Locator = By.xpath("//u[text()='Pricing Errors and Omissions']");
    By trmsPgHeader5Locator = By.xpath("//u[text()='Multiple Product Orders']");
    By trmsPgHeader6Locator = By.xpath("//u[text()='Order Acceptance Policy']");
    By trmsPgHeader7Locator = By.xpath("//u[text()='Out of Stock Products']");
    By trmsPgHeader8Locator = By.xpath("//u[text()='100% Lifetime Money Back Guarantee']");
    By trmsPgHeader9Locator = By.xpath("//u[text()='Taxes']");
    By trmsPgHeader10Locator = By.xpath("//u[text()='Modification or Suspension of the Website']");
    By trmsPgHeader11Locator = By.xpath("//u[text()='Content Disclaimer']");
    By trmsPgHeader12Locator = By.xpath("//u[text()='Assumption of Risk']");
    By trmsPgHeader13Locator = By.xpath("//u[text()='Physician Consent and Review']");
    By trmsPgHeader14Locator = By.xpath("//u[text()='Disclaimer of Warranties with Respect to Use of Website and Products and Services']");
    By trmsPgHeader15Locator = By.xpath("//u[text()='Limitations of Liability and Damages']");
    By trmsPgHeader16Locator = By.xpath("//u[text()='Compliance with Laws']");
    By trmsPgHeader17Locator = By.xpath("//u[text()='Indemnity']");
    By trmsPgHeader18Locator = By.xpath("//u[text()='Links to Third-Party Sites']");
    By trmsPgHeader19Locator = By.xpath("//u[text()='Mobile Networks; Texting']");
    By trmsPgHeader20Locator = By.xpath("//u[text()='Ownership of Content']");
    By trmsPgHeader21Locator = By.xpath("//u[text()='User Content']");
    By trmsPgHeader22Locator = By.xpath("//u[text()='Member Public Profiles']");
    By trmsPgHeader23Locator = By.xpath("//u[text()='Custom Plans']");
    By trmsPgHeader24Locator = By.xpath("//u[text()='Enforcement of Rules and Policies']");
    By trmsPgHeader25Locator = By.xpath("//u[text()='Enforcement of Rules and Policies']");
    By trmsPgHeader26Locator = By.xpath("//u[text()='Product Reviews']");
    By trmsPgHeader27Locator = By.xpath("//u[text()='Governing Law']");
    By trmsPgHeader28Locator = By.xpath("//u[text()='Dispute Resolution by Binding Arbitration']");
    By trmsPgHeader29Locator = By.xpath("//u[text()='Digital Millennium Copyright Act']");
    By trmsPgHeader30Locator = By.xpath("//u[text()='Severability of Agreement']");
    By trmsPgHeader31Locator = By.xpath("//u[text()='Electronic Signatures and Agreements']");
    By trmsPgHeader32Locator = By.xpath("//u[text()='Technical Support']");
    By trmsPgHeader33Locator = By.xpath("//u[text()='Miscellaneous']");
    By trmsPgHeader34Locator = By.xpath("//u[text()='Notice for California Users']");

    //// Methods ////
    @Step("Is Terms Page Header 3 Displayed")
    public boolean isTermsPgHeader3Displayed() {
        WebElement termsPgHeader3 = driver.findElement(trmsPgHeader2Locator);
        highlightElement(termsPgHeader3);
        scrollToMiddle(termsPgHeader3);
        return termsPgHeader3.isDisplayed();
    }

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
