package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

public class BcaaUs121Page extends BasePage {

    //// Constructor ////
    public BcaaUs121Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By bcaaPg121NoThanksLinkLocator = By.xpath("//*[text()='No thanks, I will pass on this HUGE savings for now realizing I will NEVER have this opportunity again']");

    //// Methods ////
    @Step("Click on the No Thanks link")
    public void clickNoThanksLink() {
        WebElement noThanksLink = driver.findElement(bcaaPg121NoThanksLinkLocator);
        wait.until(ExpectedConditions.visibilityOf(noThanksLink));
        highlightElement(noThanksLink);
        noThanksLink.click();
        wait.until(ExpectedConditions.invisibilityOf(noThanksLink));
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
}
