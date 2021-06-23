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
    private By creatineCsPg88ImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/media/offers/21/Creatine_three/Creatine_three.png?')]");
    private By crtn122Pg3BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/media/offers/21/Creatine_three/Creatine_three.png?')]");
    private By creatineUsF112PgHeaderTextLocator = By.xpath("//h1[@class='text-center']");
    private By creatineVslCsV2Pg84VideoLocator = By.xpath("//*[@class='jw-video jw-reset']");
    private By creatineDS113Pg3BottleImageLocator = By.xpath("//*[contains(@src,'https://d1rolxk7wi0t82.cloudfront.net/media/offers/23/Creatine_three/Creatine_three.png?')]");

    //// Methods ////
    @Step("Is Creatine Page 113 3 Bottle Image Displayed")
    public boolean isCreatineDS113Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(creatineDS113Pg3BottleImageLocator));
        WebElement creatineBottleImage = driver.findElement(creatineDS113Pg3BottleImageLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(creatineBottleImage));
        return creatineBottleImage.isDisplayed();
    }

    @Step("Is Creatine VSL CS V2 Page 84 Video Displayed")
    private boolean isCreatineVslCsV2Pg84VideoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(creatineVslCsV2Pg84VideoLocator));
        WebElement creatineVslCsV2Pg84Video = driver.findElement(creatineVslCsV2Pg84VideoLocator);
        highlightElement(creatineVslCsV2Pg84Video);
        return creatineVslCsV2Pg84Video.isDisplayed();
    }

    @Step("Is Creatine Page 122 3 Bottle Image Displayed")
    public boolean isCreatine122Pg3BottleImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(crtn122Pg3BottleImageLocator));
        WebElement creatine122Pg3BottleImage = driver.findElement(crtn122Pg3BottleImageLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(creatine122Pg3BottleImage));
        return creatine122Pg3BottleImage.isDisplayed();
    }

    @Step("Is Creatine Page 88 3 bottle Image Displayed")
    private boolean isCreatinePg883BottleImageDisplayed() {
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
    @Step("Verify the Creatine Page 113 3 Bottle Image Is Displayed")
    public void verifyCreatine113Pg3BottleImageIsDisplayed() {
        assertTrue(isCreatineDS113Pg3BottleImageDisplayed(), "Creatine Page 113 3 Bottle Image Is NOT Displayed");
    }

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
    public void verifyCreatine122Pg3BottleImageIsDisplayed() {
        assertTrue(isCreatine122Pg3BottleImageDisplayed(), "Creatine Page 122 3 BottleImage Is NOT Displayed");
    }

    @Step("Verify the Creatine Page 88 3 Bottle Image Is Displayed")
    public void verifyCreatine88Pg3BottleImageIsDisplayed() {
        assertTrue(isCreatinePg883BottleImageDisplayed(), "Creatine Page 88 3 Bottle Image NOT Displayed");
    }
}
