package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ProteinMultiUs73Page extends BasePage {

    //// Constructor ////
    public ProteinMultiUs73Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By proteinMultiUsPg73ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/protein-multi-us/img/prod_protein_multi_6-v2.png?v=1622589211']");
    private By proteinMultiUsPg73FlavorDropDownLocator = By.xpath("//*[@id='__BVID__5']");

    //// Methods ////
    @Step("Select flavor from drop down")
    public void selectFlavorFromDropDown(String selector){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinMultiUsPg73FlavorDropDownLocator));
        WebElement flavorDropDown = driver.findElement(proteinMultiUsPg73FlavorDropDownLocator);
        Select flavorOption = new Select (flavorDropDown);
        flavorOption.selectByVisibleText(selector);
    }

    @Step("Is Protein Multi US Page 73 Image Displayed")
    private boolean isProteinMultiUsPg73ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinMultiUsPg73ImageLocator));
        WebElement proteinMultiUsPg73Image = driver.findElement(proteinMultiUsPg73ImageLocator);
        highlightElement(proteinMultiUsPg73Image);
        return proteinMultiUsPg73Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Protein Multi US Page 73 Image Is Displayed")
    public void verifyProteinMultiUsPg73ImageIsDisplayed() {
        assertTrue(isProteinMultiUsPg73ImageDisplayed(), "Protein Multi US Page 73 Image NOT Displayed");
    }
}
