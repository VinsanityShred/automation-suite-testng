package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class ContactUsPage extends BasePage {

    //// Constructor ////
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By CUPgParagraphTextLocator = By.xpath("//p[contains(text(),'Sculpt Nation is a cutting edge worldwide sports nutrition brand.')]");

    //// Methods ////

    //// Setters ////

    //// Getters ////
    @Step("Get the Contact Us page text")
    public boolean getContactUsPageText() {
        final WebElement contactUsPageText = driver.findElement(CUPgParagraphTextLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Contact Us Page Text").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(contactUsPageText));
        highlightElement(contactUsPageText);
        return contactUsPageText.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify the Contact Us Page Text Is Displayed")
    public void verifyContactUsPgTextIsDisplayed() throws InterruptedException {
        if (getContactUsPageText()) {
            System.out.println("Contact Us Page Text IS Displayed");
        } else {
            throw new InterruptedException("Contact Us Page Text NOT Displayed");
        }
    }


}
