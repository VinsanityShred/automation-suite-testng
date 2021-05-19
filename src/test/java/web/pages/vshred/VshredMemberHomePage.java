package web.pages.vshred;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredMemberHomePage extends BasePage {

    public static final String MEMBER_HOME_URL = "https://testing-2.vshred.com/member";

    public VshredMemberHomePage(WebDriver driver) {
        super(driver);
    }
    //// Locators ////
    By vsMemberHomeEditProfileLocator = By.cssSelector("body > div.main-container > section.py-4 > div > div > div.col-xs-8 > a");
    By vsMemberHomeProgramsLocator = By.cssSelector("#menu1 > div > div > div.col-md-10.col-sm-10.text-right.text-left-xs.text-left-sm > div > ul > li:nth-child(2) > a");

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
