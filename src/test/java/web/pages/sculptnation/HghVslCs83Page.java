package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class HghVslCs83Page extends BasePage {

    //// Constructor ////
    public HghVslCs83Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By hghVslCsPg83VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is HGH VSL CS Page 83 Video Displayed")
    private boolean isHghVslCsPg83VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hghVslCsPg83VideoLocator));
        WebElement hghVslCsPg83Video = driver.findElement(hghVslCsPg83VideoLocator);
        highlightElement(hghVslCsPg83Video);
        return hghVslCsPg83Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the HGH VSL CS Page 83 Video Is Displayed")
    public void verifyHghVslCsPg83VideoIsDisplayed() {
        assertTrue(isHghVslCsPg83VideoDisplayed(), "HGH VSL CS Page 83 Video NOT Displayed");
    }
}
