package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class AboutUsPage extends BasePage {

    //// Constructor ////
    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By sNLandPgAboutUSHeaderLocator = By.xpath("//*[@href='/about-us']");

    //// Methods ////
    @Step("Is About Us Header Displayed")
    private boolean isAboutUsHeaderDisplayed() {
        final WebElement aboutUsHeader = driver.findElement(sNLandPgAboutUSHeaderLocator);
        highlightElement(aboutUsHeader);
        return aboutUsHeader.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Check: Verify About Us Header Is Displayed")
    public void verifyAboutUsHeaderIsDisplayed() {
        assertTrue(isAboutUsHeaderDisplayed(), "About Us Header NOT Displayed");
    }
}
