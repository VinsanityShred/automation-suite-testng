package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CreatineCs88Page extends BasePage {

    //// Constructor ////
    public CreatineCs88Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By creatineCsPg88ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/21/Creatine_three/Creatine_three.png?v=1622589211']");

    //// Methods ////
    @Step("Is Creatine Page 88 Image Displayed")
    private boolean isCreatinePg88ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(creatineCsPg88ImageLocator));
        WebElement creatinePg88Image = driver.findElement(creatineCsPg88ImageLocator);
        highlightElement(creatinePg88Image);
        return creatinePg88Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Creatine Page 88 Image Is Displayed")
    public void verifyCreatinePg88ImageIsDisplayed() {
        assertTrue(isCreatinePg88ImageDisplayed(), "Creatine Page 88 Image NOT Displayed");
    }
}
