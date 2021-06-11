package web.pages.vshred;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VshredQuestionnaireGoldPage extends VshredProgramQuestionnairePage {

    public static VshredQuestionnaireGoldPage vsQuestionnaireGoldPage;

    public VshredQuestionnaireGoldPage(WebDriver driver) {
        super(driver);
    }

    public static void createVSQuestionnaireGoldPage(WebDriver driver) {
        vsQuestionnaireGoldPage = new VshredQuestionnaireGoldPage(driver);
    }

    //// LOCATORS ////
    // GOLD COACHING QUESTIONNAIRE LOCATORS (Editable fields view, such as for member entry)
    // ** MAIN FIELDS **
    public By vsGoldFirstNameFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[37]/div/div/input");
    public By vsGoldLastNameFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[26]/div/div/input");
    public By vsGoldEmailFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[27]/div/div/input");
    public By vsGoldDOBFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[28]/div/div/input");
    public By vsGoldCountryFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[29]/div/div/input");
    public By vsGoldPhoneNumFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[24]/div/div/input");
    public By vsGoldHeightFeetFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[30]/div/div/select"); // Options: 4, 5, 6, 7
    public By vsGoldHeightInchFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[31]/div/div/select"); // Options: 0 through 11
    public By vsGoldWeightFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[32]/div/div/input");
    // The two following items are indirectly required, related to vsWeightFieldSelector, picking one or the other LB vs KG
    public By vsGoldWeightLBCheckboxSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[33]/div/div/div[2]/label/span[2]");
    public By vsGoldWeightKGCheckboxSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[33]/div/div/div[1]/label/span[2]");
    public By vsGoldMostFavFoodsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[39]/div/div/textarea");
    public By vsGoldLeastFavFoodsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[40]/div/div/textarea");
    public By vsGoldFoodsNotEatFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[23]/div/div/textarea");
    public By vsGoldFoodAllergiesYesFieldSelector = By.xpath("//*[@id=\"has_food_allergies[]-checkbox-field\"]/div[2]/label/span[2]");
    public By vsGoldFoodAllergiesNoFieldSelector = By.xpath("//*[@id=\"has_food_allergies[]-checkbox-field\"]/div[1]/label/span[2]");
    public By vsGoldFoodAllergiesListFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[42]/div/div/input");
    // ** FITNESS GOALS AND HISTORY **
    public By vsGoldMostImportantHelpToGoalsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[6]/div/div/textarea");
    // ** LIFESTYLE **
    public By vsGoldHoursSleepPerNightFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[7]/div[2]/div/input");
    public By vsGoldBiggestStressFactorsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[9]/div/div/textarea");
    // ** HEALTH/INJURIES **
    public By vsGoldInjuryListFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[41]/div/div/input"); // Put N/A by default
    public By vsGoldHealthConditionsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[15]/div/div/textarea");
    // ** MISCELLANEOUS **
    public By vsGoldHowHearAboutUsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[18]/div[2]/div/input");
    public By vsGoldDecidingFactorFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[19]/div/div/textarea");

    private By vsGoldAgreeTermsConditionsSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[20]/div/div/div/label/span[3]");

    //// Methods ////
    @Step("Check box to agree to terms and conditions")
    @Override
    public void agreeToTermsConditions() {
        // Check box for agree to terms and conditions
        setCheckboxValue(vsGoldAgreeTermsConditionsSelector, "Terms checkbox", true);
    }

    //// Getters ////
    @Step("Get name fields")
    @Override
    public boolean getNameFields(){
        System.out.println("Looking for gold questionnaire name fields");
        Util.waitMilliseconds(1000); // Give time for field to appear in DOM
        final WebElement firstName = driver.findElement(vsGoldFirstNameFieldSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find First Name Field").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(firstName));
        highlightElement(firstName);

        final WebElement lastName = driver.findElement(vsGoldLastNameFieldSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Last Name Field").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(lastName));
        highlightElement(lastName);

        return (firstName.isDisplayed() && lastName.isDisplayed());
    }

    //// Verifiers ////
    @Step("Verify questionnaire gold name fields present")
    public static void verifyVSQuestionnaireGoldPage() throws Exception {
        //// Verify name fields displayed ////
        vsQuestionnaireGoldPage.verifyNameFieldsDisplayed();
    }
}
