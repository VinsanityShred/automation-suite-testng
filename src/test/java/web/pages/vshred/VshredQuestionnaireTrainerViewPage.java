package web.pages.vshred;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Class for handling questionnaire view such as that displayed in "users" page->custom plans->questionnaire
public class VshredQuestionnaireTrainerViewPage extends VshredProgramQuestionnairePage {
    public static VshredQuestionnaireTrainerViewPage vsQuestionnaireTrainerViewPage;

    public VshredQuestionnaireTrainerViewPage(WebDriver driver) {
        super(driver);
    }

    public static void createVSQuestionnaireTrainerViewPage(WebDriver driver) {
        vsQuestionnaireTrainerViewPage = new VshredQuestionnaireTrainerViewPage(driver);
    }

    public static void verifyVSQuestionnaireTrainerViewPage() throws Exception {
        //// Verify name fields displayed ////
        vsQuestionnaireTrainerViewPage.verifyNameFieldsDisplayed();
    }

    //// LOCATORS ////
    // TRAINER VIEW QUESTIONNAIRE LOCATORS (Read-only view)
    // ** MAIN FIELDS **
    private By vsTViewFirstNameFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[14]/td[2]");
    private By vsTViewLastNameFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[3]/td[2]");
    private By vsTViewEmailFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[4]/td[2]");
    private By vsTViewDOBFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[5]/td[2]");
    private By vsTViewCountryFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[6]/td[2]");
    private By vsTViewPhoneNumFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[13]/td[2]");
    private By vsTViewHeightFeetFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[7]/td[2]"); // Options: 4, 5, 6, 7
    private By vsTViewHeightInchFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[8]/td[2]"); // Options: 0 through 11
    private By vsTViewWeightFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[9]/td[2]");
    // The two following items are indirectly required, related to vsWeightFieldSelector, picking one or the other LB vs KG
    private By vsTViewWeightLBSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[10]/td[2]"); // Same as field below, display LB
    private By vsTViewWeightKGSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[10]/td[2]"); // Same as field above, display KG
    private By vsTViewMostFavFoodsFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[16]/td[2]");
    private By vsTViewLeastFavFoodsFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[17]/td[2]");
    private By vsTViewFoodsNotEatFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[47]/td[2]");
    private By vsTViewFoodAllergiesYesSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[18]/td[2]"); // Same as field below, display yes
    private By vsTViewFoodAllergiesNoSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[18]/td[2]"); // Same as field above, display no
    private By vsTViewFoodAllergiesListFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[19]/td[2]");
    // ** FITNESS GOALS AND HISTORY **
    private By vsTViewMostImportantHelpToGoalsFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[30]/td[2]");
    // ** LIFESTYLE **
    private By vsTViewHoursSleepPerNightFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[31]/td[2]");
    private By vsTViewBiggestStressFactorsFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[33]/td[2]");
    // ** HEALTH/INJURIES **
    //private By vsTViewInjuryListFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[38]/td[2]"); // Put N/A by default
    private By vsTViewHealthConditionsFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[39]/td[2]");
    // ** MISCELLANEOUS **
    private By vsTViewHowHearAboutUsFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[42]/td[2]");
    private By vsTViewDecidingFactorFieldSelector = By.xpath("//*[@id=\"questionnaires-table\"]/tbody/tr[43]/td[2]");

    //// Methods ////

    //// Getters ////
    @Step("Get name fields")
    @Override
    public boolean getNameFields(){
        System.out.println("Looking for name fields");
        Util.waitMilliseconds(1000); // Give time for field to appear in DOM
        final WebElement firstName = driver.findElement(vsTViewFirstNameFieldSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find First Name Field").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(firstName));
        highlightElement(firstName);

        final WebElement lastName = driver.findElement(vsTViewLastNameFieldSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Last Name Field").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(lastName));
        highlightElement(lastName);

        return (firstName.isDisplayed() && lastName.isDisplayed());
    }

}
