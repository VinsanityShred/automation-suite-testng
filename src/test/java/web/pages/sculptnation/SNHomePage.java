package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.pages.BasePage;

public class SNHomePage extends BasePage {
    //// Constructor ////
    public SNHomePage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By homePgAccountContainerLocator = By.xpath("//*[@class='row account-page']");
    By homePgLogoutButtonLocator = By.xpath("//*[@class='link side-bar__link']");

    //// Methods ////
    @Step("Click on the Logout button")
    public void clickLogoutButton() {
        final WebElement logoutButton = driver.findElement(homePgLogoutButtonLocator);
        highlightElement(logoutButton);
        logoutButton.isDisplayed();
    }

    @Step("Is Account Container Displayed")
    public void isHomePgAccountContainerDisplayed() {
        final WebElement homePgAccountContainerDisplayed = driver.findElement(homePgAccountContainerLocator);
        highlightElement(homePgAccountContainerDisplayed);
        homePgAccountContainerDisplayed.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
}
