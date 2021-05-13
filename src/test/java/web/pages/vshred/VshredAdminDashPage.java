package web.pages.vshred;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredAdminDashPage extends BasePage {

    public static final String ADMIN_DROPDOWN_TEXT = "Admin";
    public static final String ADMIN_LOGOUT_TEXT = "Logout";
    public static final String ADMIN_DASH_URL = "https://testing-2.vshred.com/admin";

    public VshredAdminDashPage(WebDriver driver) {
        super(driver);
    }

    //// Locators ////

    By vsAdminDashLogoLocator = By.cssSelector("#page-wrapper > div.row.border-bottom > nav > ul > li.logo-element.p-0.nav-item > img");
    By vsAdminDashDropdownLocator = By.cssSelector("#dropdownMenuLink > span > span.text-muted.text-xs.block");
    By vsAdminDashLogoutLocator = By.cssSelector("#page-wrapper > div.row.border-bottom > nav > ul > li:nth-child(2) > a");

    //// Methods ////
    @Step("Click on logout button")
    public void clickLogoutButton() {
        final WebElement logoutButton = driver.findElement(vsAdminDashLogoutLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find A Clickable Logout Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(logoutButton));
        scrollToTop(logoutButton);
        highlightElement(logoutButton);
        logoutButton.click();
        waitForInvisibilityOfElement(logoutButton);
    }

    public boolean isLoggedIn() {
        return getAdminDashLogout();
    }

    public void userLogOut() {
        clickLogoutButton();
    }

    //// Setters ////

    //// Getters ////
    @Step("Get the admin dash page logo")
    private boolean getAdminDashLogo(){
        final WebElement adminDashLogo = driver.findElement(vsAdminDashLogoLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logo Image").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(adminDashLogo));
        highlightElement(adminDashLogo);
        return adminDashLogo.isDisplayed();
    }

    @Step("Get the admin dash page dropdown menu")
    private boolean getAdminDashDropdownMenu(){
        final WebElement adminDashDropdown = driver.findElement(vsAdminDashDropdownLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Admin Dropdown").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(adminDashDropdown));
        highlightElement(adminDashDropdown);
        return adminDashDropdown.isDisplayed() && (adminDashDropdown.getText().equalsIgnoreCase(ADMIN_DROPDOWN_TEXT));
    }

    @Step("Get the admin dash logout")
    private boolean getAdminDashLogout(){
        final WebElement adminDashLogout = driver.findElement(vsAdminDashLogoutLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Admin Logout").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(adminDashLogout));
        highlightElement(adminDashLogout);
        return adminDashLogout.isDisplayed() && (adminDashLogout.getText().equalsIgnoreCase(ADMIN_LOGOUT_TEXT));
    }

    //// Verifiers ////

    @Step("Check: Verify Admin Dash Page Logo Is Displayed")
    public void verifyAdminDashLogoIsDisplayed() throws InterruptedException {
        if (!getAdminDashLogo()) {
            throw new InterruptedException("Admin Dash Page Logo NOT Displayed");
        } else {
            System.out.println("Admin Dash Page Logo Displayed");
        }
    }

    @Step("Check: Verify Admin Dash Dropdown Menu Is Displayed")
    public void verifyAdminDropdownMenuDisplayed() throws InterruptedException {
        if (!getAdminDashDropdownMenu()) {
            throw new InterruptedException("Admin Dash Page Dropdown Menu NOT Displayed");
        } else {
            System.out.println("Admin Dash Page Dropdown Menu Displayed");
        }
    }

}
