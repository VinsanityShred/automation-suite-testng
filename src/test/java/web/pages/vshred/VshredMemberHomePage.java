package web.pages.vshred;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredMemberHomePage extends BasePage {
    public static VshredMemberHomePage vsMemberHomePage;

    public VshredMemberHomePage(WebDriver driver) {
        super(driver);
    }

    public static void createVSMemberHomePage(WebDriver driver) {
        vsMemberHomePage = new VshredMemberHomePage(driver);
    }

    public static void verifyVSMemberHomePage() throws Exception {
        vsMemberHomePage.verifyEditProfileIsDisplayed();
    }

    //// Locators ////
    private By vsMemberHomeEditProfileLocator = By.xpath("/html/body/div[4]/section[1]/div/div/div[2]/a");
    private By vsMemberHomeProgramsLocator = By.xpath("//*[@id=\"menu1\"]/div/div/div[2]/div/ul/li[2]/a");

    //// Methods ////
    @Step("Click on programs link")
    public void clickProgramsLink() {
        final WebElement memberHomeProgramsLink = driver.findElement(vsMemberHomeProgramsLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find A Clickable Programs Link").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(memberHomeProgramsLink));
        scrollToTop(memberHomeProgramsLink);
        highlightElement(memberHomeProgramsLink);
        memberHomeProgramsLink.click();
        waitForInvisibilityOfElement(memberHomeProgramsLink);
    }

    public void memberGoToPrograms() {
        clickProgramsLink();
    }

    //// Setters ////

    //// Getters ////
    @Step("Get the member home edit profile button")
    private boolean getMemberHomeEditProfileBtn(){
        Util.waitMilliseconds(1000);
        final WebElement memberHomeEditProfile = driver.findElement(vsMemberHomeEditProfileLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Member Home Edit Profile Button").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(memberHomeEditProfile));
        highlightElement(memberHomeEditProfile);
        return memberHomeEditProfile.isDisplayed();
    }

    @Step("Get the member home programs link")
    private boolean getMemberHomeProgramsMenuLink(){
        final WebElement memberHomeProgramsLink = driver.findElement(vsMemberHomeProgramsLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Member Home Programs Link").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(memberHomeProgramsLink));
        highlightElement(memberHomeProgramsLink);
        return memberHomeProgramsLink.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify Member Home Page Edit Profile Is Displayed")
    public void verifyEditProfileIsDisplayed() throws InterruptedException {
        if (!getMemberHomeEditProfileBtn()) {
            throw new InterruptedException("Member Home Page Edit Profile Button NOT Displayed");
        } else {
            System.out.println("Member Home Page Edit Profile Displayed");
        }
    }

    @Step("Check: Verify Member Home Page Programs Menu Link Is Displayed")
    public void verifyProgramsMenuLinkIsDisplayed() throws InterruptedException {
        if (!getMemberHomeProgramsMenuLink()) {
            throw new InterruptedException("Member Home Page Programs Link NOT Displayed");
        } else {
            System.out.println("Member Home Page Programs Link Displayed");
        }
    }
}
