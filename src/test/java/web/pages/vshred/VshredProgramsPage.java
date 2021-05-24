package web.pages.vshred;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredProgramsPage extends BasePage {
    public static final String PROGRAMS_PAGE_URL = "https://testing-2.vshred.com/programs";

    public VshredProgramsPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By vsProgramBigArmsLocator = By.cssSelector("body > div.main-container > section > div > div > div:nth-child(12) > div > a:nth-child(2)");

    //// Methods ////
    @Step("Click on big arms program")
    public void clickBigArmsProgram() {
        final WebElement programBigArms = driver.findElement(vsProgramBigArmsLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Big Arms Program").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(programBigArms));
        scrollToTop(programBigArms);
        highlightElement(programBigArms);
        programBigArms.click();
        waitForInvisibilityOfElement(programBigArms);
    }

    //// Setters ////

    //// Getters ////
    @Step("Get the big arms program link")
    private boolean getBigArmsProgram(){
        final WebElement programBigArms = driver.findElement(vsProgramBigArmsLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Big Arms Program").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(programBigArms));
        highlightElement(programBigArms);
        return programBigArms.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify Programs Page Big Arms Is Displayed")
    public void verifyBigArmsProgramIsDisplayed() throws InterruptedException {
        if (!getBigArmsProgram()) {
            throw new InterruptedException("Program Big Arms NOT Displayed");
        } else {
            System.out.println("Program Big Arms Is Displayed");
        }
    }
}
