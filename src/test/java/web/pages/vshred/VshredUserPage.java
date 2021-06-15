package web.pages.vshred;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredUserPage extends BasePage {
    public static VshredUserPage vsUserPage;

    public VshredUserPage(WebDriver driver) {
        super(driver);
    }

    public static void createUserPage(WebDriver driver) {
        vsUserPage = new VshredUserPage(driver);
    }

    //// Locators ////
    By vsUserViewTabLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div/div/div[1]/ul/li[1]/a");
    By vsUserCustomPlansTabLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div/div/div[1]/ul/li[5]/a");
    By vsUserQuestionnaireTabLocator = By.xpath("//*[@id=\"tab-custom-plans\"]/div/div/ul/li[2]/a");
    By vsUserQuestionnaireTableLocator = By.xpath("//*[@id=\"questionnaires-table\"]");

    //// Methods ////
    @Step("Click on custom plans tab")
    public void clickCustomPlansTab() {
        final WebElement customPlans = driver.findElement(vsUserCustomPlansTabLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Custom Plans Tab").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(customPlans));
        highlightElement(customPlans);
        customPlans.click();
    }

    @Step("Click on questionnaires tab")
    public void clickQuestionnairesTab() {
        final WebElement questionTab = driver.findElement(vsUserQuestionnaireTabLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Questionnaires Tab").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(questionTab));
        highlightElement(questionTab);
        questionTab.click();
    }

    //// Getters ////
    @Step("Get the user view tab")
    private boolean getUserViewTab(){
        final WebElement userViewTab = driver.findElement(vsUserViewTabLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find User View Tab").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(userViewTab));
        highlightElement(userViewTab);
        return userViewTab.isDisplayed();
    }

    @Step("Get the user questionnaire table")
    private boolean getUserQuestionnaireTable(){
        final WebElement userQuestionTable = driver.findElement(vsUserQuestionnaireTableLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find User Questionnaire Table").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(userQuestionTable));
        highlightElement(userQuestionTable);
        return userQuestionTable.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify User View Tab Is Displayed")
    public void verifyViewTabIsDisplayed() throws InterruptedException {
        if (!getUserViewTab()) {
            throw new InterruptedException("User View Tab NOT Displayed");
        } else {
            System.out.println("User View Tab IS Displayed");
        }
    }

    @Step("Check: Verify User Questionnaire Table Is Displayed")
    public void verifyQuestionnaireTableIsDisplayed() throws InterruptedException {
        if (!getUserQuestionnaireTable()) {
            throw new InterruptedException("User View Questionnaire NOT Displayed");
        } else {
            System.out.println("User View Questionnaire IS Displayed");
        }
    }

    public static void verifyUserPage() throws Exception {
        //// Verify user page logo ////
        vsUserPage.verifyViewTabIsDisplayed();
    }

    public static void verifyQuestionnaireTableDisplayed() throws Exception {
        //// Verify user page questionnaire table ////
        vsUserPage.verifyQuestionnaireTableIsDisplayed();
    }
}
