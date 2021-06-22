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
    private By proteinMultiCs100Pg3BottleImageLocator = By.xpath("//*[@alt='protein']");
    private By prtnMultCs115PgChocolateImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/protein-multi-cs/img/b-2.png?')]");
    private By proteinMultiUs73Pg6BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/protein-multi-us/img/prod_protein_multi_6-v2.png?')]");
    private By proteinMultiUsPg73FlavorDropDownLocator = By.xpath("//*[@id='__BVID__5']");
    private By proteinMultiUs74Pg3BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/protein-multi-ds/img/prod_protein_multi_3.png?')]");
    private By protnPg123ChocolateBottleImageLocator = By.xpath("//*[text()='No Thanks, I am perfectly happy waiting to see how things go.']");

    //// Methods ////
    @Step("Is Protein Multi DS Page 74 3 Bottle Image Displayed")
    public boolean isProtein74Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinMultiUs74Pg3BottleImageLocator));
        WebElement protein74Pg3BottleImage = driver.findElement(proteinMultiUs74Pg3BottleImageLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(protein74Pg3BottleImage));
        return protein74Pg3BottleImage.isDisplayed();
    }

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

    @Step("Is Protein Multi US Page 73 6 Bottle Image Displayed")
    private boolean isProteinMultiUs73Pg6BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinMultiUs73Pg6BottleImageLocator));
        WebElement proteinMultiUs73Pg6BottleImage = driver.findElement(proteinMultiUs73Pg6BottleImageLocator);
        highlightElement(proteinMultiUs73Pg6BottleImage);
        return proteinMultiUs73Pg6BottleImage.isDisplayed();
    }

    @Step("Is Protein Chocolate 3 Bottles Image Displayed")
    private boolean isProteinChocolateImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(prtnMultCs115PgChocolateImageLocator));
        WebElement proteinChocolateImage = driver.findElement(prtnMultCs115PgChocolateImageLocator);
        highlightElement(proteinChocolateImage);
        return proteinChocolateImage.isDisplayed();
    }

    @Step("Is Protein Multi CS Page 100 3 Bottle Image Displayed")
    private boolean isProteinMultiCs100Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinMultiCs100Pg3BottleImageLocator));
        WebElement burn100Pg3BottleImage = driver.findElement(proteinMultiCs100Pg3BottleImageLocator);
        highlightElement(burn100Pg3BottleImage);
        return burn100Pg3BottleImage.isDisplayed();
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
    @Step("Verify the Protein Multi CS Page 74 3 Bottle Image Is Displayed")
    public void verifyProteinMulti74Pg3BottleImageIsDisplayed() {
        assertTrue(isProtein74Pg3BottleImageDisplayed(), "Protein Multi CS Page 74 3 Bottle Image Is NOT Displayed");
    }

    @Step("Verify the Protein Multi CS Page 123 Bottle Image Is Displayed")
    public void verifyProteinMultiPg123BottleImageIsDisplayed() {
        assertTrue(isProteinChocolateBottleImageDisplayed(), "Protein Multi CS Page 123 Bottle Image Is NOT Displayed");
    }

    @Step("Verify the Protein Multi US Page 73 6 Bottle Image Is Displayed")
    public void verifyProteinMultiUs73Pg6BottleImageIsDisplayed() {
        assertTrue(isProteinMultiUs73Pg6BottleImageDisplayed(), "Protein Multi US Page 73 6 Bottle Image NOT Displayed");
    }

    @Step("Verify the Protein Chocolate 3 Bottles Image Is Displayed")
    public void verifyProteinChocolateImageIsDisplayed() {
        assertTrue(isProteinChocolateImageDisplayed(), "Protein Chocolate 3 Bottles Image NOT Displayed");
    }

    @Step("Verify the Protein Multi CS Page 100 3 Bottle Image Is Displayed")
    public void verifyProteinMultiCs100Pg3BottleImageIsDisplayed() {
        assertTrue(isProteinMultiCs100Pg3BottleImageDisplayed(), "Protein Multi CS Page 100 3 Bottle Image NOT Displayed");
    }

    @Step("Verify the Protein Multi CS Page 80 3 Bottle Image Is Displayed")
    public void verifyProteinMultiCs80Pg3BottleImageIsDisplayed() {
        assertTrue(isProteinMultiCs80Pg3BottleImageDisplayed(), "Protein Multi CS Page 80 3 Bottle Image NOT Displayed");
    }
}
