package web.pages.sculptnation;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.pages.BasePage;

import static org.testng.Assert.assertTrue;

public class CouponGreensV2F217Page extends BasePage {

    //// Constructor ////
    public CouponGreensV2F217Page(WebDriver driver) {
        super(driver);
    }

    //// Locators ////
    private By cupnGrnsPgCouponLocator = By.xpath("//*[@class='coupon']");
    private By cupnGrnsPgAddToCartLocator = By.xpath("//a[text()='Add To Cart']");

    //// Methods ////
    @Step("Click on the Add To Cart link")
    public void clickAddToCartLinkByIndex(int index){
        Util.waitMilliseconds(1500);
        WebElement addToCartLink = driver.findElements(cupnGrnsPgAddToCartLocator).get(index);
        highlightElement(addToCartLink);
        scrollToBottom(addToCartLink);
        addToCartLink.click();
        wait.until(ExpectedConditions.invisibilityOf(addToCartLink));
    }

    @Step("Is Greens Coupon Displayed")
    private boolean isGreensPgCouponDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cupnGrnsPgCouponLocator));
        WebElement greensPgCoupon = driver.findElement(cupnGrnsPgCouponLocator);
        highlightElement(greensPgCoupon);
        return greensPgCoupon.isDisplayed();
    }

    //// Setters ////

    //// Getters ////

    //// Verifiers ////
    @Step("Verify the Greens Page Coupon Is Displayed")
    public void verifyGreensPgCouponIsDisplayed() {
        assertTrue(isGreensPgCouponDisplayed(), "Greens Page Coupon NOT Displayed");
    }
}
