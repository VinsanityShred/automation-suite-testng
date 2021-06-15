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

public class VshredOrderConfirmPage extends BasePage {
    public static VshredOrderConfirmPage vsOrderConfirmPage;

    public VshredOrderConfirmPage(WebDriver driver) {
        super(driver);
    }

    public static void createVSOrderConfirmPage(WebDriver driver) {
        vsOrderConfirmPage = new VshredOrderConfirmPage(driver);
    }

    public static void verifyVSOrderConfirmPage() throws Exception {
        //// Verify thanks for order message ////
        vsOrderConfirmPage.verifyThankYouMessageIsDisplayed();
    }

    //// Locators ////
    private By vsThanksForOrderSelector = By.xpath("/html/body/div[4]/section/div/h2");
    private By vsFillQuestionnaireSelector = By.xpath("//*[@id=\"questionnaire\"]"); // TODO: wait for visibility to move on

    //// Methods ////
    @Step("Click on Questionnaire link")
    public void clickQuestionnaireButton() {
        final WebElement linkQuestionnaire = driver.findElement(vsFillQuestionnaireSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Questionnaire Link").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(linkQuestionnaire));
        highlightElement(linkQuestionnaire);
        linkQuestionnaire.click();
    }

    //// Getters ////
    @Step("Get coupon offer")
    private boolean getThankYouMessage(){
        System.out.println("Looking for thank you message");
        Util.waitMilliseconds(1000); // Give time for field to appear in DOM
        final WebElement thankYouMsg = driver.findElement(vsThanksForOrderSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Thank You Message").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(thankYouMsg));
        highlightElement(thankYouMsg);
        return thankYouMsg.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify Thank You Message Is Displayed")
    public void verifyThankYouMessageIsDisplayed() throws InterruptedException {
        if (!getThankYouMessage()) {
            throw new InterruptedException("Thank You Message NOT Displayed");
        } else {
            System.out.println("Thank You Message Is Displayed");
        }
    }

}
