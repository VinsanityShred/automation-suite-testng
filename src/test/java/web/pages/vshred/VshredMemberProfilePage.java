package web.pages.vshred;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredMemberProfilePage extends BasePage {
    public static VshredMemberProfilePage vsMemberProfilePage;

    public VshredMemberProfilePage(WebDriver driver) {
        super(driver);
    }

    public static void createVSMemberProfilePage(WebDriver driver) {
        vsMemberProfilePage = new VshredMemberProfilePage(driver);
    }

    //// Locators ////
    private By vsMemberProfileQuestionnaireLocator = By.xpath("//*[@id=\"questionnaire\"]");
    private By vsMemberProfileLogoutLocator = By.xpath("/html/body/div[4]/section/div/div/div[1]/div/div[2]/ul/li[6]/a");
    private By vsMemberProfileViewCustomPlansLocator = By.xpath("//*[@id=\"account-profile\"]/form/div/div[2]/div/span/button");
    private By vsModalDialogLocator = By.xpath("/html/body/div[5]/div/div");
    private By vsModalDialogCloseLocator = By.xpath("/html/body/div[5]/div/div/div[2]");

    //// Methods ////
    @Step("Click on close X for successful questionnaire submit modal dialog")
    public void clearQuestionnaireSubmissionModal() {
        Util.waitMilliseconds(2000); // Give time for dialog to appear in DOM
        final WebElement modalSubmitDialog = driver.findElement(vsModalDialogLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Modal Submit Dialog").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(modalSubmitDialog));
        highlightElement(modalSubmitDialog);

        final WebElement modalCloseX = driver.findElement(vsModalDialogCloseLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Modal Close X").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(modalCloseX));
        modalCloseX.click();

        waitForInvisibilityOfElement(modalSubmitDialog);

    }

    @Step("Click on Fill Questionnaire button")
    public void clickFillQuestionnaire() {
        final WebElement memberProfileQuestionnaire = driver.findElement(vsMemberProfileQuestionnaireLocator);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        highlightElement(memberProfileQuestionnaire);
        executor.executeScript("arguments[0].click();", memberProfileQuestionnaire);
        waitForInvisibilityOfElement(memberProfileQuestionnaire);
    }

    @Step("Click on Custom Plans button")
    public void clickCustomPlans() {
        final WebElement memberCustomPlans = driver.findElement(vsMemberProfileViewCustomPlansLocator);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        highlightElement(memberCustomPlans);
        executor.executeScript("arguments[0].click();", memberCustomPlans);
        waitForInvisibilityOfElement(memberCustomPlans);
    }

    @Step("Click on Logout link")
    public void clickLogOut() {
        final WebElement memberProfileLogout = driver.findElement(vsMemberProfileLogoutLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logout Link").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(memberProfileLogout));
        scrollToTop(memberProfileLogout);
        highlightElement(memberProfileLogout);
        memberProfileLogout.click();
        waitForInvisibilityOfElement(memberProfileLogout);
    }
}
