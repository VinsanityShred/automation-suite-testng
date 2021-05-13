package web.pages.sculptnation;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

public class Coupon218Page extends BasePage {

    //// Constructor ////
    public Coupon218Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    By couponPg218NoThanksLinkLocator = By.xpath("//*[text()='No thanks, my metabolism doesn’t need a boost.']");

    //// Methods ////
    @Step("Click on the No Thanks link")
    public void clickNoThanksLink() {
        WebElement noThanksLink = driver.findElement(couponPg218NoThanksLinkLocator);
        wait.until(ExpectedConditions.visibilityOf(noThanksLink));
        highlightElement(noThanksLink);
        noThanksLink.click();
        wait.until(ExpectedConditions.invisibilityOf(noThanksLink));
    }


    //// Setters ////

    //// Getters ////

    //// Verifiers ////
}
