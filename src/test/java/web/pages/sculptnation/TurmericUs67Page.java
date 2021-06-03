package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class TurmericUs67Page extends BasePage {

    //// Constructor ////
    public TurmericUs67Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By turmericUsPg67VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is Turmeric Black Page 67 Video Displayed")
    private boolean isTurmericUsPg67VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(turmericUsPg67VideoLocator));
        WebElement turmericUsPg67Video = driver.findElement(turmericUsPg67VideoLocator);
        highlightElement(turmericUsPg67Video);
        return turmericUsPg67Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Turmeric Black Page 67 Video Is Displayed")
    public void verifyTurmericUsPg67VideoVideoIsDisplayed() {
        assertTrue(isTurmericUsPg67VideoDisplayed(), "Turmeric Black Page 67 Video NOT Displayed");
    }
}
