package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

import static org.testng.Assert.assertEquals;

public class CreatineUsF112Page extends BasePage {

    //// Constructor ////
    public CreatineUsF112Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By creatineUsF112PgHeaderTextLocator = By.xpath("//h1[@class='text-center']");

    //// Methods ////

    //// Setters ////

    //// Getters ////
    @Step("Get Creatine Header Text")
    public String getCreatineHeaderText() {
        WebElement creatineHeaderText = driver.findElement(creatineUsF112PgHeaderTextLocator);
        return creatineHeaderText.getText();
    }

    //// Verifiers ////
    @Step("Verify Creatine header text is a match")
    public void verifyCreatineHeaderTextIsAMatch() {
        String expectedCreatineHeaderText = "STOCKPILE YOUR BODY'S NUCLEAR ARSENAL\n" +
                "INCREASE YOUR ORDER:";
        assertEquals(getCreatineHeaderText(), expectedCreatineHeaderText, "Creatine Header NOT A Match");
    }
}
