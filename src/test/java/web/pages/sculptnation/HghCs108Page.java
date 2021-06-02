package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class HghCs108Page extends BasePage {

    //// Constructor ////
    public HghCs108Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By HghCsPg108ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/hgh-cs/img/b-4-v2.png?v=1622589211']");

    //// Methods ////
    @Step("Is HGH CS Page 108 Image Displayed")
    private boolean isHghCSPg108ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HghCsPg108ImageLocator));
        WebElement hghCSPg108Image = driver.findElement(HghCsPg108ImageLocator);
        highlightElement(hghCSPg108Image);
        return hghCSPg108Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the HGH CS Page 108 Image Is Displayed")
    public void verifyHghCSPg108ImageIsDisplayed() {
        assertTrue(isHghCSPg108ImageDisplayed(), "HGH CS Page 108 Image NOT Displayed");
    }
}
