package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class ProteinSalesFunnelPage extends BasePage {

    //// Constructor ////
    public ProteinSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By proteinMultiCs80Pg3BottleImageLocator = By.xpath("//*[@alt='protein']");
    private By proteinMultiCs100PgImageLocator = By.xpath("//*[@alt='protein']");
    private By prtnMultCs115PgChocolateImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/protein-multi-cs/img/b-2.png?')]");
    private By proteinMultiUsPg73ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/protein-multi-us/img/prod_protein_multi_6-v2.png?v=1622589211']");
    private By proteinMultiUsPg73FlavorDropDownLocator = By.xpath("//*[@id='__BVID__5']");
    private By protnPg123ChocolateBottleImageLocator = By.xpath("//*[text()='No Thanks, I am perfectly happy waiting to see how things go.']");

    //// Methods ////
    @Step("Is Protein Multi CS Page 123 Bottle Image Displayed")
    public boolean isProteinChocolateBottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(protnPg123ChocolateBottleImageLocator));
        WebElement proteinChocolateBottleImage = driver.findElement(protnPg123ChocolateBottleImageLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(proteinChocolateBottleImage));
        return proteinChocolateBottleImage.isDisplayed();
    }

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

    @Step("Is Protein Chocolate 3 Bottles Image Displayed")
    private boolean isProteinChocolateImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(prtnMultCs115PgChocolateImageLocator));
        WebElement proteinChocolateImage = driver.findElement(prtnMultCs115PgChocolateImageLocator);
        highlightElement(proteinChocolateImage);
        return proteinChocolateImage.isDisplayed();
    }

    @Step("Is Protein Multi CS Page 100 Image Displayed")
    private boolean isProteinMultiCsPg100ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinMultiCs100PgImageLocator));
        WebElement burnPg118Image = driver.findElement(proteinMultiCs100PgImageLocator);
        highlightElement(burnPg118Image);
        return burnPg118Image.isDisplayed();
    }

    @Step("Is Protein Multi CS Page 80 3 Bottle Image Displayed")
    private boolean isProteinMultiCs80Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinMultiCs80Pg3BottleImageLocator));
        WebElement proteinMultiCs80Pg3BottleImage = driver.findElement(proteinMultiCs80Pg3BottleImageLocator);
        highlightElement(proteinMultiCs80Pg3BottleImage);
        return proteinMultiCs80Pg3BottleImage.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Protein Multi CS Page 123 Bottle Image Is Displayed")
    public void verifyProteinMultiPg123BottleImageIsDisplayed() {
        assertTrue(isProteinChocolateBottleImageDisplayed(), "Protein Multi CS Page 123 Bottle Image Is NOT Displayed");
    }

    @Step("Verify the Protein Multi US Page 73 Image Is Displayed")
    public void verifyProteinMultiUsPg73ImageIsDisplayed() {
        assertTrue(isProteinMultiUsPg73ImageDisplayed(), "Protein Multi US Page 73 Image NOT Displayed");
    }

    @Step("Verify the Protein Chocolate 3 Bottles Image Is Displayed")
    public void verifyProteinChocolateImageIsDisplayed() {
        assertTrue(isProteinChocolateImageDisplayed(), "Protein Chocolate 3 Bottles Image NOT Displayed");
    }

    @Step("Verify the Protein Multi CS Page 100 Image Is Displayed")
    public void verifyProteinMultiCsPg100ImageIsDisplayed() {
        assertTrue(isProteinMultiCsPg100ImageDisplayed(), "Protein Multi CS Page 100 Image NOT Displayed");
    }

    @Step("Verify the Protein Multi CS Page 80 3 Bottle Image Is Displayed")
    public void verifyProteinMultiCs80Pg3BottleImageIsDisplayed() {
        assertTrue(isProteinMultiCs80Pg3BottleImageDisplayed(), "Protein Multi CS Page 80 3 Bottle Image NOT Displayed");
    }
}
