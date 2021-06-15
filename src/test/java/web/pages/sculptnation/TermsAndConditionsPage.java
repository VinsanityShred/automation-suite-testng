package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    @Step("Is Terms Page Header 34 Displayed")
    public boolean isTermsPgHeader34Displayed() {
        WebElement termsPgHeader34 = driver.findElement(trmsPgHeader34Locator);
        highlightElement(termsPgHeader34);
        scrollToMiddle(termsPgHeader34);
        return termsPgHeader34.isDisplayed();
    }

    @Step("Is Terms Page Header 33 Displayed")
    public boolean isTermsPgHeader33Displayed() {
        WebElement termsPgHeader33 = driver.findElement(trmsPgHeader33Locator);
        highlightElement(termsPgHeader33);
        scrollToMiddle(termsPgHeader33);
        return termsPgHeader33.isDisplayed();
    }

    @Step("Is Terms Page Header 32 Displayed")
    public boolean isTermsPgHeader32Displayed() {
        WebElement termsPgHeader32 = driver.findElement(trmsPgHeader32Locator);
        highlightElement(termsPgHeader32);
        scrollToMiddle(termsPgHeader32);
        return termsPgHeader32.isDisplayed();
    }

    @Step("Is Terms Page Header 31 Displayed")
    public boolean isTermsPgHeader31Displayed() {
        WebElement termsPgHeader31 = driver.findElement(trmsPgHeader31Locator);
        highlightElement(termsPgHeader31);
        scrollToMiddle(termsPgHeader31);
        return termsPgHeader31.isDisplayed();
    }

    @Step("Is Terms Page Header 30 Displayed")
    public boolean isTermsPgHeader30Displayed() {
        WebElement termsPgHeader30 = driver.findElement(trmsPgHeader30Locator);
        highlightElement(termsPgHeader30);
        scrollToMiddle(termsPgHeader30);
        return termsPgHeader30.isDisplayed();
    }

    @Step("Is Terms Page Header 29 Displayed")
    public boolean isTermsPgHeader29Displayed() {
        WebElement termsPgHeader29 = driver.findElement(trmsPgHeader29Locator);
        highlightElement(termsPgHeader29);
        scrollToMiddle(termsPgHeader29);
        return termsPgHeader29.isDisplayed();
    }

    @Step("Is Terms Page Header 28 Displayed")
    public boolean isTermsPgHeader28Displayed() {
        WebElement termsPgHeader28 = driver.findElement(trmsPgHeader28Locator);
        highlightElement(termsPgHeader28);
        scrollToMiddle(termsPgHeader28);
        return termsPgHeader28.isDisplayed();
    }

    @Step("Is Terms Page Header 27 Displayed")
    public boolean isTermsPgHeader27Displayed() {
        WebElement termsPgHeader27 = driver.findElement(trmsPgHeader27Locator);
        highlightElement(termsPgHeader27);
        scrollToMiddle(termsPgHeader27);
        return termsPgHeader27.isDisplayed();
    }

    @Step("Is Terms Page Header 26 Displayed")
    public boolean isTermsPgHeader26Displayed() {
        WebElement termsPgHeader26 = driver.findElement(trmsPgHeader26Locator);
        highlightElement(termsPgHeader26);
        scrollToMiddle(termsPgHeader26);
        return termsPgHeader26.isDisplayed();
    }

    @Step("Is Terms Page Header 25 Displayed")
    public boolean isTermsPgHeader25Displayed() {
        WebElement termsPgHeader25 = driver.findElement(trmsPgHeader25Locator);
        highlightElement(termsPgHeader25);
        scrollToMiddle(termsPgHeader25);
        return termsPgHeader25.isDisplayed();
    }

    @Step("Is Terms Page Header 24 Displayed")
    public boolean isTermsPgHeader24Displayed() {
        WebElement termsPgHeader24 = driver.findElement(trmsPgHeader24Locator);
        highlightElement(termsPgHeader24);
        scrollToMiddle(termsPgHeader24);
        return termsPgHeader24.isDisplayed();
    }

    @Step("Is Terms Page Header 23 Displayed")
    public boolean isTermsPgHeader23Displayed() {
        WebElement termsPgHeader23 = driver.findElement(trmsPgHeader23Locator);
        highlightElement(termsPgHeader23);
        scrollToMiddle(termsPgHeader23);
        return termsPgHeader23.isDisplayed();
    }

    @Step("Is Terms Page Header 22 Displayed")
    public boolean isTermsPgHeader22Displayed() {
        WebElement termsPgHeader22 = driver.findElement(trmsPgHeader22Locator);
        highlightElement(termsPgHeader22);
        scrollToMiddle(termsPgHeader22);
        return termsPgHeader22.isDisplayed();
    }

    @Step("Is Terms Page Header 21 Displayed")
    public boolean isTermsPgHeader21Displayed() {
        WebElement termsPgHeader21 = driver.findElement(trmsPgHeader21Locator);
        highlightElement(termsPgHeader21);
        scrollToMiddle(termsPgHeader21);
        return termsPgHeader21.isDisplayed();
    }

    @Step("Is Terms Page Header 20 Displayed")
    public boolean isTermsPgHeader20Displayed() {
        WebElement termsPgHeader20 = driver.findElement(trmsPgHeader20Locator);
        highlightElement(termsPgHeader20);
        scrollToMiddle(termsPgHeader20);
        return termsPgHeader20.isDisplayed();
    }

    @Step("Is Terms Page Header 19 Displayed")
    public boolean isTermsPgHeader19Displayed() {
        WebElement termsPgHeader19 = driver.findElement(trmsPgHeader19Locator);
        highlightElement(termsPgHeader19);
        scrollToMiddle(termsPgHeader19);
        return termsPgHeader19.isDisplayed();
    }

    @Step("Is Terms Page Header 18 Displayed")
    public boolean isTermsPgHeader18Displayed() {
        WebElement termsPgHeader18 = driver.findElement(trmsPgHeader18Locator);
        highlightElement(termsPgHeader18);
        scrollToMiddle(termsPgHeader18);
        return termsPgHeader18.isDisplayed();
    }

    @Step("Is Terms Page Header 17 Displayed")
    public boolean isTermsPgHeader17Displayed() {
        WebElement termsPgHeader17 = driver.findElement(trmsPgHeader17Locator);
        highlightElement(termsPgHeader17);
        scrollToMiddle(termsPgHeader17);
        return termsPgHeader17.isDisplayed();
    }

    @Step("Is Terms Page Header 16 Displayed")
    public boolean isTermsPgHeader16Displayed() {
        WebElement termsPgHeader16 = driver.findElement(trmsPgHeader16Locator);
        highlightElement(termsPgHeader16);
        scrollToMiddle(termsPgHeader16);
        return termsPgHeader16.isDisplayed();
    }

    @Step("Is Terms Page Header 15 Displayed")
    public boolean isTermsPgHeader15Displayed() {
        WebElement termsPgHeader15 = driver.findElement(trmsPgHeader15Locator);
        highlightElement(termsPgHeader15);
        scrollToMiddle(termsPgHeader15);
        return termsPgHeader15.isDisplayed();
    }

    @Step("Is Terms Page Header 14 Displayed")
    public boolean isTermsPgHeader14Displayed() {
        WebElement termsPgHeader14 = driver.findElement(trmsPgHeader14Locator);
        highlightElement(termsPgHeader14);
        scrollToMiddle(termsPgHeader14);
        return termsPgHeader14.isDisplayed();
    }

    @Step("Is Terms Page Header 13 Displayed")
    public boolean isTermsPgHeader13Displayed() {
        WebElement termsPgHeader13 = driver.findElement(trmsPgHeader13Locator);
        highlightElement(termsPgHeader13);
        scrollToMiddle(termsPgHeader13);
        return termsPgHeader13.isDisplayed();
    }

    @Step("Is Terms Page Header 12 Displayed")
    public boolean isTermsPgHeader12Displayed() {
        WebElement termsPgHeader12 = driver.findElement(trmsPgHeader12Locator);
        highlightElement(termsPgHeader12);
        scrollToMiddle(termsPgHeader12);
        return termsPgHeader12.isDisplayed();
    }

    @Step("Is Terms Page Header 11 Displayed")
    public boolean isTermsPgHeader11Displayed() {
        WebElement termsPgHeader11 = driver.findElement(trmsPgHeader11Locator);
        highlightElement(termsPgHeader11);
        scrollToMiddle(termsPgHeader11);
        return termsPgHeader11.isDisplayed();
    }

    @Step("Is Terms Page Header 10 Displayed")
    public boolean isTermsPgHeader10Displayed() {
        WebElement termsPgHeader10 = driver.findElement(trmsPgHeader10Locator);
        highlightElement(termsPgHeader10);
        scrollToMiddle(termsPgHeader10);
        return termsPgHeader10.isDisplayed();
    }

    @Step("Is Terms Page Header 9 Displayed")
    public boolean isTermsPgHeader9Displayed() {
        WebElement termsPgHeader9 = driver.findElement(trmsPgHeader9Locator);
        highlightElement(termsPgHeader9);
        scrollToMiddle(termsPgHeader9);
        return termsPgHeader9.isDisplayed();
    }

    @Step("Is Terms Page Header 8 Displayed")
    public boolean isTermsPgHeader8Displayed() {
        WebElement termsPgHeader8 = driver.findElement(trmsPgHeader8Locator);
        highlightElement(termsPgHeader8);
        scrollToMiddle(termsPgHeader8);
        return termsPgHeader8.isDisplayed();
    }

    @Step("Is Terms Page Header 7 Displayed")
    public boolean isTermsPgHeader7Displayed() {
        WebElement termsPgHeader7 = driver.findElement(trmsPgHeader7Locator);
        highlightElement(termsPgHeader7);
        scrollToMiddle(termsPgHeader7);
        return termsPgHeader7.isDisplayed();
    }

    @Step("Is Terms Page Header 6 Displayed")
    public boolean isTermsPgHeader6Displayed() {
        WebElement termsPgHeader6 = driver.findElement(trmsPgHeader6Locator);
        highlightElement(termsPgHeader6);
        scrollToMiddle(termsPgHeader6);
        return termsPgHeader6.isDisplayed();
    }

    @Step("Is Terms Page Header 5 Displayed")
    public boolean isTermsPgHeader5Displayed() {
        WebElement termsPgHeader5 = driver.findElement(trmsPgHeader5Locator);
        highlightElement(termsPgHeader5);
        scrollToMiddle(termsPgHeader5);
        return termsPgHeader5.isDisplayed();
    }

    @Step("Is Terms Page Header 4 Displayed")
    public boolean isTermsPgHeader4Displayed() {
        WebElement termsPgHeader4 = driver.findElement(trmsPgHeader4Locator);
        highlightElement(termsPgHeader4);
        scrollToMiddle(termsPgHeader4);
        return termsPgHeader4.isDisplayed();
    }

    @Step("Is Terms Page Header 3 Displayed")
    public boolean isTermsPgHeader3Displayed() {
        WebElement termsPgHeader3 = driver.findElement(trmsPgHeader3Locator);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(trmsPgHeaderLocator));
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
        assertTrue(isTermsPgHeader3Displayed(), "Terms Page Header 3 Is NOT Displayed");
        assertTrue(isTermsPgHeader4Displayed(), "Terms Page Header 4 Is NOT Displayed");
        assertTrue(isTermsPgHeader5Displayed(), "Terms Page Header 5 Is NOT Displayed");
        assertTrue(isTermsPgHeader6Displayed(), "Terms Page Header 6 Is NOT Displayed");
        assertTrue(isTermsPgHeader7Displayed(), "Terms Page Header 7 Is NOT Displayed");
        assertTrue(isTermsPgHeader8Displayed(), "Terms Page Header 8 Is NOT Displayed");
        assertTrue(isTermsPgHeader9Displayed(), "Terms Page Header 9 Is NOT Displayed");
        assertTrue(isTermsPgHeader10Displayed(), "Terms Page Header 10 Is NOT Displayed");
        assertTrue(isTermsPgHeader11Displayed(), "Terms Page Header 11 Is NOT Displayed");
        assertTrue(isTermsPgHeader12Displayed(), "Terms Page Header 12 Is NOT Displayed");
        assertTrue(isTermsPgHeader13Displayed(), "Terms Page Header 13 Is NOT Displayed");
        assertTrue(isTermsPgHeader14Displayed(), "Terms Page Header 14 Is NOT Displayed");
        assertTrue(isTermsPgHeader15Displayed(), "Terms Page Header 15 Is NOT Displayed");
        assertTrue(isTermsPgHeader16Displayed(), "Terms Page Header 16 Is NOT Displayed");
        assertTrue(isTermsPgHeader17Displayed(), "Terms Page Header 17 Is NOT Displayed");
        assertTrue(isTermsPgHeader18Displayed(), "Terms Page Header 18 Is NOT Displayed");
        assertTrue(isTermsPgHeader19Displayed(), "Terms Page Header 19 Is NOT Displayed");
        assertTrue(isTermsPgHeader20Displayed(), "Terms Page Header 20 Is NOT Displayed");
        assertTrue(isTermsPgHeader21Displayed(), "Terms Page Header 21 Is NOT Displayed");
        assertTrue(isTermsPgHeader22Displayed(), "Terms Page Header 22 Is NOT Displayed");
        assertTrue(isTermsPgHeader23Displayed(), "Terms Page Header 23 Is NOT Displayed");
        assertTrue(isTermsPgHeader24Displayed(), "Terms Page Header 24 Is NOT Displayed");
        assertTrue(isTermsPgHeader25Displayed(), "Terms Page Header 25 Is NOT Displayed");
        assertTrue(isTermsPgHeader26Displayed(), "Terms Page Header 26 Is NOT Displayed");
        assertTrue(isTermsPgHeader27Displayed(), "Terms Page Header 27 Is NOT Displayed");
        assertTrue(isTermsPgHeader28Displayed(), "Terms Page Header 28 Is NOT Displayed");
        assertTrue(isTermsPgHeader29Displayed(), "Terms Page Header 29 Is NOT Displayed");
        assertTrue(isTermsPgHeader30Displayed(), "Terms Page Header 30 Is NOT Displayed");
        assertTrue(isTermsPgHeader31Displayed(), "Terms Page Header 31 Is NOT Displayed");
        assertTrue(isTermsPgHeader32Displayed(), "Terms Page Header 32 Is NOT Displayed");
        assertTrue(isTermsPgHeader33Displayed(), "Terms Page Header 33 Is NOT Displayed");
        assertTrue(isTermsPgHeader34Displayed(), "Terms Page Header 34 Is NOT Displayed");
    }

    @Step("Verify is the Terms page header displayed")
    public void verifyTermsPgHeaderIsDisplayed() {
        assertTrue(isTermsPgHeaderDisplayed(), "Terms Page Header Is NOT Displayed");
    }

}
