package web.pages.vshred;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;

public class VshredProgramsPage extends BasePage {
    public static VshredProgramsPage vsProgramsPage;

    public VshredProgramsPage(WebDriver driver) {
        super(driver);
    }

    public static void createVSProgramsPage(WebDriver driver) {
        vsProgramsPage = new VshredProgramsPage(driver);
    }

    //// Locators ////
    private By vsProgramBigArmsLocator = By.xpath("/html/body/div[4]/section/div/div/div[12]/div/a[1]/img");
    //private By vsProgramMoveLocator = By.xpath("/html/body/div[4]/section/div/div/div[2]/div/a[1]/img");
    private By vsProgramFatLossExtremeHimLocator = By.xpath("/html/body/div[4]/section/div/div/div[6]/div/a[1]/img");
    private By vsProgramFatLossExtremeHerLocator = By.xpath("/html/body/div[4]/section/div/div/div[7]/div/a[1]/img");

    //// Methods ////
    public void clickProgramLink(String strProgramName, By aProgramLocator) {
        final WebElement programLink = driver.findElement(aProgramLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find " + strProgramName + " Program Link").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(programLink));
        scrollToTop(programLink);
        highlightElement(programLink);
        programLink.click();
        waitForInvisibilityOfElement(programLink);
    }

    @Step("Click on Big Arms Program Link")
    public void clickBigArmsProgram() {
        clickProgramLink("Big Arms", vsProgramBigArmsLocator);
    }

    @Step("Click on Fat Loss Extreme for Him Program Link")
    public void clickFatLossExtremeHimProgram() {
        clickProgramLink("Fat Loss Extreme for Him", vsProgramFatLossExtremeHimLocator);
    }

    @Step("Click on Fat Loss Extreme for Her Program Link")
    public void clickFatLossExtremeHerProgram() {
        clickProgramLink("Fat Loss Extreme for Her", vsProgramFatLossExtremeHerLocator);
    }

    //// Setters ////

    //// Getters ////
    private boolean getProgram(String strProgramName, By aProgramLocator){
        final WebElement programLink = driver.findElement(aProgramLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find " +  strProgramName + " Program Link").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(programLink));
        highlightElement(programLink);
        return programLink.isDisplayed();
    }

    @Step("Get the big arms program link")
    private boolean getBigArmsProgram(){
        return getProgram("Big Arms", vsProgramBigArmsLocator);
    }

    //// Verifiers ////
    public void verifyProgramIsDisplayed(String strProgramName, By aProgramLocator) throws InterruptedException {
        if (!getProgram(strProgramName, aProgramLocator)) {
            throw new InterruptedException("Program " + strProgramName + " NOT Displayed");
        } else {
            System.out.println("Program " + strProgramName + " Is Displayed");
        }
    }

    /*public static void verifyVSProgramsPage() throws Exception {
        //// Verify desired program is present ////
        vsProgramsPage.verifyBigArmsProgramIsDisplayed();
    }*/

    @Step("Check: Verify Big Arms Program Link Is Displayed")
    public void verifyBigArmsProgramIsDisplayed() throws InterruptedException {
        verifyProgramIsDisplayed("Big Arms", vsProgramBigArmsLocator);
    }

    @Step("Check: Verify Fat Loss Extreme for Him Program Link Is Displayed")
    public void verifyFatLossExtremeHimProgramIsDisplayed() throws InterruptedException {
        verifyProgramIsDisplayed("Fat Loss Extreme for Him", vsProgramFatLossExtremeHimLocator);
    }

    @Step("Check: Verify Fat Loss Extreme for Her Program Link Is Displayed")
    public void verifyFatLossExtremeHerProgramIsDisplayed() throws InterruptedException {
        verifyProgramIsDisplayed("Fat Loss Extreme for Her", vsProgramFatLossExtremeHerLocator);
    }
}
