package web.pages.vshred;

import framework.utility.Util;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredHomePage extends BasePage {

    public static VshredHomePage vsHomePage;

    //// Constructor ////
    public VshredHomePage(WebDriver driver) {
        super(driver);
    }

    public static void createVSHomePage(WebDriver driver) {
        vsHomePage = new VshredHomePage(driver);
    }

    //// Locators ////
    private By homepageLogoLocator = By.xpath("//*[@id=\"menu1\"]/div/div/div[1]/div/a/img[1]");
    private By homepageHeaderTextLocator = By.xpath("//h2[text()='Your Programs']");
    private By homepageCircleAvatarLocator = By.className("circle-avatar");
    private By homepageLoginLocator = By.xpath("//*[@id=\"menu1\"]/div/div/div[2]/div[2]/a/span");
    private By homepageLogoutLinkLocator = By.cssSelector("body > div.main-container > section > div > div > div.col-md-4 > div > div:nth-child(3) > ul > li:nth-child(6) > a");
    private By gymWorkoutPlayerLocator = By.xpath("//*[@class='embed-responsive-item']");

    //// Methods ////
    @Step("Click Logout link")
    public void clickLogoutLink() {
        Util.waitMilliseconds(1000);
        final WebElement homepageLogoutLink = driver.findElement(homepageLogoutLinkLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logout Link").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(homepageLogoutLink));
        highlightElement(homepageLogoutLink);
        homepageLogoutLink.click();
    }

    @Step("Click Login")
    public void clickLogin() {
        Util.waitMilliseconds(1000);
        final WebElement homepageLogin = driver.findElement(homepageLoginLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Login Link").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(homepageLogin));
        highlightElement(homepageLogin);
        homepageLogin.click();
    }

    @Step("Click Avatar Circle")
    public void clickAvatarCircle() {
        final WebElement avatarCircle = driver.findElement(homepageCircleAvatarLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logout Link").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(avatarCircle));
        highlightElement(avatarCircle);
        avatarCircle.click();
    }

    @Step("Is Home page logo displayed")
    public boolean isHomepageLogoDisplayed() {
        Util.waitMilliseconds(1500); // Wait for item to appear in DOM
        final WebElement homepageLogoDisplayed = driver.findElement(homepageLogoLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Home Page Logo").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(homepageLogoDisplayed));
        highlightElement(homepageLogoDisplayed);
        return homepageLogoDisplayed.isDisplayed();
    }

    @Step("Is Gym Workout Player")
    public boolean isGymWorkoutPlayerDisplayed() {
        final WebElement gymWorkoutPlayer = driver.findElement(gymWorkoutPlayerLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Home Page Logo").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(gymWorkoutPlayer));
        highlightElement(gymWorkoutPlayer);
        return gymWorkoutPlayer.isDisplayed();
    }

    //// Setters ////

    //// Getters ////
    @Step("Get Home Page Header Text")
    public String getHomepageHeaderText() {
        final WebElement homepageHeaderText = driver.findElement(homepageHeaderTextLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Header Text: YOUR PROGRAMS").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.textToBePresentInElement(homepageHeaderText,
                        "YOUR PROGRAMS"));
        highlightElement(homepageHeaderText);
        return homepageHeaderText.getText();
    }

    //// Verifiers ////
    @Step("Check: Verify Gym Workout Player Is Displayed")
    public void verifyGymWorkoutPlayerIsDisplayed() throws Exception {
        if (isGymWorkoutPlayerDisplayed() == true) {
            System.out.println("Gym Workout Player Displayed");
        } else {
            throw new InterruptedException("Gym Workout Player NOT Displayed");
        }
    }

    @Step("Check: Verify Home Page Header Text Is A Match")
    public void verifyHomepageHeaderTextIsAMatch() throws Exception{
        if (getHomepageHeaderText().equals("YOUR PROGRAMS")) {
            System.out.println("Home Page Header Text IS A Match");
        } else {
            throw new InterruptedException("Home Page Header Text Is NOT A Match");
        }
    }

    @Step("Check: Verify Home Page Header Text Is A Match")
    public void verifyHomepageHeaderTextIsAMatchFail() throws Exception{
        if (getHomepageHeaderText().equals("YO PROGRAMS")) {
            System.out.println("Home Page Header Text IS A Match");
        } else {
            throw new InterruptedException("Home Page Header Text NOT A Match");
        }
    }

    @Step("Check: Verify Home Page Logo Is Displayed")
    public void verifyHomepageLogoIsDisplayed() throws InterruptedException {
        if (isHomepageLogoDisplayed() == true) {
            System.out.println("Home Page Logo Displayed");
        } else {
            throw new InterruptedException("Home Page Logo NOT Displayed");
        }
    }

    public static void verifyVSHomePage() throws Exception {
        //// Verify login page logo ////
        vsHomePage.verifyHomepageLogoIsDisplayed();
    }
}
