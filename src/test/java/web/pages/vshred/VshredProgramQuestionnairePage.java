package web.pages.vshred;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import web.pages.BasePage;

import java.time.Duration;

public class VshredProgramQuestionnairePage extends BasePage {
    // Enumeration of questionnaire fields to relate to field selectors for questionnaire page variations
    public enum QuestionnaireFields {
        Q_FirstName,
        Q_LastName,
        Q_Email,
        Q_DOB,
        Q_Country,
        Q_PhoneNum,
        Q_HeightFeet,
        Q_HeightInch,
        Q_Weight,
        Q_WeightUnit,
        Q_MostFavFoods,
        Q_LeastFavFoods,
        Q_FoodsNotEat,
        Q_AllergiesYN,
        Q_FoodAllergiesList,
        Q_ImportantHelpToGoals,
        Q_HoursSleepPerNight,
        Q_BiggestStressFactors,
        Q_InjuryList,
        Q_HealthConditions,
        Q_HowHearAboutUs,
        Q_DecidingFactor,
        Q_AgreeToTerms
    }

    public enum WeightUnits {
        Wt_LB,
        Wt_KB
    }


    public static VshredProgramQuestionnairePage vsQuestionnairePage;

    public VshredProgramQuestionnairePage(WebDriver driver) {
        super(driver);
    }

    public static void createVSQuestionnairePage(WebDriver driver) {
        vsQuestionnairePage = new VshredProgramQuestionnairePage(driver);
    }

    //// Locators ////
    // ** REQUIRED FIELD SELECTORS **
    // ** MAIN FIELDS **
    private By vsFirstNameFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[1]/div/div/input");
    private By vsLastNameFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[2]/div/div/input");
    private By vsEmailFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[3]/div/div/input");
    private By vsDOBFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[4]/div/div/input");
    private By vsCountryFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[5]/div/div/input");
    private By vsPhoneNumFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[6]/div/div/input");
    private By vsHeightFeetFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[7]/div/div/select"); // Options: 4, 5, 6, 7
    private By vsHeightInchFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[8]/div/div/select"); // Options: 0 through 11
    private By vsWeightFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[9]/div/div/input");
    // The two following items are indirectly required, related to vsWeightFieldSelector, picking one or the other LB vs KG
    private By vsWeightLBCheckboxSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[10]/div/div/div[2]/label/span[2]");
    private By vsWeightKGCheckboxSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[10]/div/div/div[1]/label/span[2]");
    private By vsMostFavFoodsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[18]/div/div/textarea");
    private By vsLeastFavFoodsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[20]/div/div/textarea");
    private By vsFoodsNotEatFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[19]/div/div/textarea");
    private By vsFoodAllergiesYesFieldSelector = By.xpath("//*[@id=\"has_food_allergies[]-checkbox-field\"]/div[2]/label/span[2]");
    private By vsFoodAllergiesNoFieldSelector = By.xpath("//*[@id=\"has_food_allergies[]-checkbox-field\"]/div[1]/label/span[2]");
    private By vsFoodAllergiesListFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[22]/div/div/input");
    // ** FITNESS GOALS AND HISTORY **
    private By vsMostImportantHelpToGoalsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[33]/div/div/textarea");
    // ** LIFESTYLE **
    private By vsHoursSleepPerNightFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[34]/div[2]/div/input");
    private By vsBiggestStressFactorsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[36]/div/div/textarea");
    // ** HEALTH/INJURIES **
    private By vsInjuryListFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[41]/div/div/input"); // Put N/A by default
    private By vsHealthConditionsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[42]/div/div/textarea");
    // ** MISCELLANEOUS **
    private By vsHowHearAboutUsFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[44]/div[2]/div/input");
    private By vsDecidingFactorFieldSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[45]/div/div/textarea");

    private By vsAgreeTermsConditionsSelector = By.xpath("//*[@id=\"app\"]/main/div/div/div/div/form/div/div[47]/div/div/div/label/span[3]");

    private By vsSubmitButton = By.xpath("/html/body/div[4]/div/main/div/div/div/div/form/div/div[49]/button");

    //// Methods ////
    @Step("Check box to agree to terms and conditions")
    public void agreeToTermsConditions() {
        // Check box for agree to terms and conditions
        setCheckboxValue(vsAgreeTermsConditionsSelector, "Terms checkbox", true);
    }

    @Step("Click questionnaire submit button")
    public void clickSubmitButton() {
        System.out.println("Clicking questionnaire Submit button");
        final WebElement submitBtn = driver.findElement(vsSubmitButton);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Questionnaire Submit Button").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(submitBtn));
        highlightElement(submitBtn);
        submitBtn.click();
        System.out.println("Questionnaire Submitted");
    }

    //// Setters ////
    @Step("Set Field Value")
    public void setFieldValue(By fieldSelector, String strFieldName, String strValue) {
        System.out.println("Setting field " + strFieldName + " to value " + strValue);
        WebElement fieldElement = driver.findElement(fieldSelector);
        Actions action = new Actions(driver);
        action.moveToElement(fieldElement).perform();
        highlightElement(fieldElement);
        fieldElement.clear();
        fieldElement.click();
        setTextBySendKeys(strValue);
    }

    @Step("Set Checkbox Value")
    public void setCheckboxValue(By boxSelector, String strBoxName, boolean aValue) {
        System.out.println("Setting checkbox " + strBoxName + " to value " + aValue);
        WebElement checkboxElement = driver.findElement(boxSelector);
        Actions action = new Actions(driver);
        action.moveToElement(checkboxElement).perform();

        if (aValue) {
            if (!checkboxElement.isSelected()) {
                checkboxElement.click();
            }
        } else {
            if (checkboxElement.isSelected()) {
                checkboxElement.click();
            }
        }
    }

    @Step("Set Drop-down Value")
    public void setDropdownValue(By fieldSelector, String strFieldName, String strValue) {
        System.out.println("Setting field " + strFieldName + " to value " + strValue);
        Select fieldElement = new Select(driver.findElement(fieldSelector));
        fieldElement.selectByVisibleText(strValue);
    }

    //// Getters ////
    @Step("Get name fields")
    public boolean getNameFields(){
        System.out.println("Looking for name fields");
        Util.waitMilliseconds(1000); // Give time for field to appear in DOM
        final WebElement firstName = driver.findElement(vsFirstNameFieldSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find First Name Field").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(firstName));
        highlightElement(firstName);

        final WebElement lastName = driver.findElement(vsLastNameFieldSelector);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Last Name Field").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(lastName));
        highlightElement(lastName);

        return (firstName.isDisplayed() && lastName.isDisplayed());
    }

    //// Verifiers ////
    @Step("Check: Verify First and Last Name Fields Displayed")
    public void verifyNameFieldsDisplayed() throws InterruptedException {
        if (!getNameFields()) {
            throw new InterruptedException("Name Fields NOT Displayed");
        } else {
            System.out.println("Name Fields Are Displayed");
        }
    }
}
