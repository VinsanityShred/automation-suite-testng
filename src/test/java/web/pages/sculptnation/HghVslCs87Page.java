package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class HghVslCs87Page extends BasePage {

    //// Constructor ////
    public HghVslCs87Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By hghVslCs87PgVideoLocator = By.xpath("//*[@class='jw-video jw-reset']");

    //// Methods ////
    @Step("Is HGH VSL CS Page 87 Video Displayed")
    private boolean isHghVslCsPg87VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hghVslCs87PgVideoLocator));
        WebElement hghVslCsPg87Video = driver.findElement(hghVslCs87PgVideoLocator);
        highlightElement(hghVslCsPg87Video);
        return hghVslCsPg87Video.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the HGH VSL CS Page 87 Video Is Displayed")
    public void verifyHghVslCsPg87VideoIsDisplayed() {
        assertTrue(isHghVslCsPg87VideoDisplayed(), "HGH VSL CS Page 87 Video NOT Displayed");
    }


}
