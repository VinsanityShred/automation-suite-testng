package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreatineSalesFunnelPage extends BasePage {

    //// Constructor ////
    public CreatineSalesFunnelPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By creatineCsPg88ImageLocator = By.xpath("//*[@src='https://d1rolxk7wi0t82.cloudfront.net/media/offers/21/Creatine_three/Creatine_three.png?v=1622589211']");
    private By crtn122PgNoThanksLinkLocator = By.xpath("//*[text()='No Thanks, I am perfectly happy waiting to see how things go.']");
    private By crtn122PgBottleImageLocator = By.xpath("//*[text()='No Thanks, I am perfectly happy waiting to see how things go.']");
    private By creatineUsF112PgHeaderTextLocator = By.xpath("//h1[@class='text-center']");
    private By creatineVslCsV2Pg84VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");


    //// Methods ////
    @Step("Is Creatine VSL CS V2 Page 84 Video Displayed")
    private boolean isCreatineVslCsV2Pg84VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(creatineVslCsV2Pg84VideoLocator));
        WebElement creatineVslCsV2Pg84Video = driver.findElement(creatineVslCsV2Pg84VideoLocator);
        highlightElement(creatineVslCsV2Pg84Video);
        return creatineVslCsV2Pg84Video.isDisplayed();
    }

    @Step("Is Creatine Bottle Image Displayed")
    public boolean isCreatineBottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(crtn122PgBottleImageLocator));
        WebElement creatineBottleImage = driver.findElement(crtn122PgBottleImageLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(creatineBottleImage));
        return creatineBottleImage.isDisplayed();
    }

    @Step("Click on the No Thanks link")
    public void clickNoThanksLink() {
        WebElement noThanksLink = driver.findElement(crtn122PgNoThanksLinkLocator);
        wait.until(ExpectedConditions.visibilityOf(noThanksLink));
        highlightElement(noThanksLink);
        noThanksLink.click();
        wait.until(ExpectedConditions.invisibilityOf(noThanksLink));
    }

    @Step("Is Creatine Page 88 Image Displayed")
    private boolean isCreatinePg88ImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(creatineCsPg88ImageLocator));
        WebElement creatinePg88Image = driver.findElement(creatineCsPg88ImageLocator);
        highlightElement(creatinePg88Image);
        return creatinePg88Image.isDisplayed();
    }

    //// Setters ////

    //// Getters ////
    @Step("Get Creatine Header Text")
    public String getCreatineHeaderText() {
        WebElement creatineHeaderText = driver.findElement(creatineUsF112PgHeaderTextLocator);
        return creatineHeaderText.getText();
    }

    //// Verifiers ////
    @Step("Verify the Creatine VSL CS V2 Page 84 Video Is Displayed")
    public void verifyCreatineVslCsV2Pg84VideoIsDisplayed() {
        assertTrue(isCreatineVslCsV2Pg84VideoDisplayed(), "Creatine VSL CS V2 Page 84 Video NOT Displayed");
    }

    @Step("Verify Creatine header text is a match")
    public void verifyCreatineHeaderTextIsAMatch() {
        String expectedCreatineHeaderText = "STOCKPILE YOUR BODY'S NUCLEAR ARSENAL\n" +
                "INCREASE YOUR ORDER:";
        assertEquals(getCreatineHeaderText(), expectedCreatineHeaderText, "Creatine Header NOT A Match");
    }

    @Step("Verify the Creatine Bottle Image Is Displayed")
    public void verifyCreatineBottleImageIsDisplayed() {
        assertTrue(isCreatineBottleImageDisplayed(), "Creatine Bottle Image Is NOT Displayed");
    }

    @Step("Verify the Creatine Page 88 Image Is Displayed")
    public void verifyCreatinePg88ImageIsDisplayed() {
        assertTrue(isCreatinePg88ImageDisplayed(), "Creatine Page 88 Image NOT Displayed");
    }
}
