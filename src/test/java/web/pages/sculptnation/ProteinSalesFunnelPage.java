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
    private By proteinMultiCs80PgImageLocator = By.xpath("//*[@alt='protein']");
    private By proteinMultiCs100PgImageLocator = By.xpath("//*[@alt='protein']");
    private By prtnMultCs115PgChocolateImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/cms/sales-pages/protein-multi-cs/img/b-2.png?v=1621872093']");
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

    @Step("Is Protein Chocolate Image Displayed")
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

    @Step("Is Protein Multi CS Page 80 Image Displayed")
    private boolean isProteinMultiCsPg80ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proteinMultiCs80PgImageLocator));
        WebElement proteinMultiCsPg80Image = driver.findElement(proteinMultiCs80PgImageLocator);
        highlightElement(proteinMultiCsPg80Image);
        return proteinMultiCsPg80Image.isDisplayed();
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

    @Step("Verify the Protein Chocolate Image Is Displayed")
    public void verifyProteinChocolateImageIsDisplayed() {
        assertTrue(isProteinChocolateImageDisplayed(), "Protein Chocolate Image NOT Displayed");
    }

    @Step("Verify the Protein Multi CS Page 100 Image Is Displayed")
    public void verifyProteinMultiCsPg100ImageIsDisplayed() {
        assertTrue(isProteinMultiCsPg100ImageDisplayed(), "Protein Multi CS Page 100 Image NOT Displayed");
    }

    @Step("Verify the Protein Multi CS Page 80 Image Is Displayed")
    public void verifyProteinMultiCsPg80ImageIsDisplayed() {
        assertTrue(isProteinMultiCsPg80ImageDisplayed(), "Protein Multi CS Page 80 Image NOT Displayed");
    }
}
