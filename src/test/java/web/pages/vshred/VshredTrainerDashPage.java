package web.pages.vshred;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.pages.BasePage;

import java.time.Duration;
import java.util.NoSuchElementException;

public class VshredTrainerDashPage extends BasePage {
    public static final String TRAINER_DROPDOWN_TEXT = "Trainer";
    public static final String TRAINER_LOGOUT_TEXT = "Logout";

    public static VshredTrainerDashPage vsTrainerPage;

    public VshredTrainerDashPage(WebDriver driver) {
        super(driver);
    }

    public static void createTrainerDashPage(WebDriver driver) {
        vsTrainerPage = new VshredTrainerDashPage(driver);
    }

    //// Locators ////
    By vsTrainerDashLogoLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li[3]/img");
    By vsTrainerDashDropdownLocator = By.xpath("//*[@id=\"dropdownMenuLink\"]/span/span[2]");
    By vsTrainerDashLogoutLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li[2]/a");
    By vsTrainerDashOrdersLocator = By.xpath("//*[@id=\"side-menu\"]/li[2]/a/span");
    By vsTrainerDashTableOfOrdersLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div[2]/div[1]/div/table");
    By vsTrainerDashTableOfAssignedClientsLocator = By.cssSelector("#page-wrapper > div.wrapper.wrapper-content > div > div > div > div.mb-4 > div:nth-child(1) > div > table");
    //By vsTrainerDashTableOfAssignedClientsLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div/div[2]/div[1]/div/table");
    By vsTrainerDashCustomerNameSearchLocator = By.xpath("//*[@id=\"__BVID__15\"]");
    By vsTrainerDashCustomerNameLinkLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/div/a");
    By vsTrainerDashAssignClientQuestionIconLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr[1]/td[7]/div/div/span/i");
    By vsTrainerDashAssignedClientsLocator = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a/span");
    By vsTrainerDashTrainerToolLocator = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
    By vsTrainerDashQuestionnaireModalLocator = By.xpath("//*[@id=\"__BVID__34___BV_modal_content_\"]");
    By vsTrainerDashQuestionnaireModalCloseLocator = By.xpath("//*[@id=\"__BVID__34___BV_modal_footer_\"]/button");
    By vsTrainerDashQuestionnaireDateTimeLocator = By.cssSelector("#page-wrapper > div.wrapper.wrapper-content > div > div > div > div.mb-4 > div:nth-child(1) > div > table > tbody > tr:nth-child(1) > td:nth-child(7) > div > span");
    //By vsTrainerDashQuestionnaireDateTimeLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div/div[2]/div[1]/div/table/tbody/tr[1]/td[7]/div/span");
    By vsTrainerDashLoadingIconLocator = By.cssSelector("#page-wrapper > div.wrapper.wrapper-content > div > div > div > div.mb-4.base-table-filter-opacity > div.base-table-overlay > div");
    //By vsTrainerDashLoadingIconLocator = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/div/div/div[2]/div[1]/div");

    //// Methods ////
    @Step("Wait for order results to display")
    public void waitForOrderResults() {
        // TODO: Change code to look for actual table locator with max 45 second search
        Util.waitMilliseconds(2000); // Give time for table to appear in DOM
        final WebElement loadingIcon = driver.findElement(vsTrainerDashLoadingIconLocator);
        if (loadingIcon.isDisplayed()) {
            System.out.println("Loading icon is displayed");
        }
        System.out.println("Waiting up to 60 seconds for table data to appear");
        WebDriverWait waitLoad = new WebDriverWait(driver, 60);
        waitLoad.until(ExpectedConditions.visibilityOfElementLocated(vsTrainerDashTableOfOrdersLocator));

        final WebElement ordersTable = driver.findElement(vsTrainerDashTableOfOrdersLocator);
        highlightElement(ordersTable);


        //WebDriverWait wait = new WebDriverWait(driver, 60);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(vsTrainerDashTableOfOrdersLocator));
       /* new WebDriverWait(driver, 60).
                pollingEvery(Duration.ofMillis(1000)). //.ignoring(NoSuchElementException.class).
                withMessage("Could Not Find Orders Table").
                withTimeout(Duration.ofSeconds(60)).
                until(ExpectedConditions.visibilityOfElementLocated(vsTrainerDashTableOfOrdersLocator));
        highlightElement(ordersTable);

        */
    }

    @Step("Wait for assigned clients to display")
    public void waitForAssignedClientsResults() {
        Util.waitMilliseconds(2000); // Give time for table to appear in DOM
        final WebElement loadingIcon = driver.findElement(vsTrainerDashLoadingIconLocator);
        if (loadingIcon.isDisplayed()) {
            System.out.println("Loading icon is displayed");
        }
        System.out.println("Waiting up to 60 seconds for table data to appear");
        WebDriverWait waitLoad = new WebDriverWait(driver, 60);
        waitLoad.until(ExpectedConditions.visibilityOfElementLocated(vsTrainerDashTableOfAssignedClientsLocator));

        final WebElement clientsTable = driver.findElement(vsTrainerDashTableOfAssignedClientsLocator);
        highlightElement(clientsTable);
    }

    @Step("Click on logout button")
    public void clickLogoutButton() {
        WebElement logoutButton = driver.findElement(vsTrainerDashLogoutLocator);
        Actions action = new Actions(driver);
        action.moveToElement(logoutButton).perform();
        highlightElement(logoutButton);
        logoutButton.click();
    }

    @Step("Click on orders menu link")
    public void clickOrders() {
        Util.waitMilliseconds(1500);
        final WebElement ordersMenu = driver.findElement(vsTrainerDashOrdersLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Orders Menu link").
                withTimeout(Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(ordersMenu));
        highlightElement(ordersMenu);
        ordersMenu.click();
        waitForOrderResults();
    }

    @Step("Click customer name")
    public void clickCustomerNameLink() {
        WebElement customerNameLink = driver.findElement(vsTrainerDashCustomerNameLinkLocator);
        Actions action = new Actions(driver);
        action.moveToElement(customerNameLink).perform();
        highlightElement(customerNameLink);
        customerNameLink.click();
    }

    @Step("Click customer questionnaire icon")
    public void clickCustomerQuestionnaireIconLink() {
        WebElement customerQuestionLink = driver.findElement(vsTrainerDashAssignClientQuestionIconLocator);
        Actions action = new Actions(driver);
        action.moveToElement(customerQuestionLink).perform();
        highlightElement(customerQuestionLink);
        customerQuestionLink.click();
    }

    @Step("Click Trainer Tool left menu")
    public void clickTrainerTool() {
        WebElement trainerToolLink = driver.findElement(vsTrainerDashTrainerToolLocator);
        Actions action = new Actions(driver);
        action.moveToElement(trainerToolLink).perform();
        highlightElement(trainerToolLink);
        trainerToolLink.click();
    }

    @Step("Click questionnaire modal close")
    public void clickQuestionnaireClose() {
        WebElement modalClose = driver.findElement(vsTrainerDashQuestionnaireModalCloseLocator);
        Actions action = new Actions(driver);
        action.moveToElement(modalClose).perform();
        highlightElement(modalClose);
        modalClose.click();
    }

    @Step("Click Assigned Clients left menu")
    public void clickAssignedClients() {
        Util.waitMilliseconds(1500); // Give time to appear in DOM after Trainer Tool click
        WebElement assignedClientsLink = driver.findElement(vsTrainerDashAssignedClientsLocator);
        Actions action = new Actions(driver);
        action.moveToElement(assignedClientsLink).perform();
        highlightElement(assignedClientsLink);
        assignedClientsLink.click();
    }

    @Step("Enter customer name and hit enter to search")
    public void searchCustomerName(String aCustName) {
        System.out.println("Searching for customer name " + aCustName);
        WebElement customerNameEdit = driver.findElement(vsTrainerDashCustomerNameSearchLocator);
        Actions action = new Actions(driver);
        action.moveToElement(customerNameEdit).perform();
        highlightElement(customerNameEdit);
        customerNameEdit.clear();
        customerNameEdit.click();
        setTextBySendKeys(aCustName);
        customerNameEdit.sendKeys(Keys.ENTER);
    }


    public boolean isLoggedIn() {
        return getTrainerDashLogout();
    }

    public void userLogOut() {
        clickLogoutButton();
    }

    public String questionnaireSubmitDateTime() {
        Util.waitMilliseconds(1500); // Give time to appear in DOM

        System.out.print("Looking for and retrieving questionnaire submit date/time...");
        WebElement qSubmitDate = driver.findElement(vsTrainerDashQuestionnaireDateTimeLocator);
        Actions action = new Actions(driver);
        action.moveToElement(qSubmitDate).perform();
        highlightElement(qSubmitDate);
        return qSubmitDate.getText();
    }

    //// Setters ////

    //// Getters ////
    @Step("Get the trainer dash page logo")
    private boolean getTrainerDashLogo(){
        final WebElement trainerDashLogo = driver.findElement(vsTrainerDashLogoLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Logo Image").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(trainerDashLogo));
        highlightElement(trainerDashLogo);
        return trainerDashLogo.isDisplayed();
    }

    @Step("Get the trainer dash page dropdown menu")
    private boolean getTrainerDashDropdownMenu(){
        final WebElement trainerDashDropdown = driver.findElement(vsTrainerDashDropdownLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Trainer Dropdown").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(trainerDashDropdown));
        highlightElement(trainerDashDropdown);
        return trainerDashDropdown.isDisplayed() && (trainerDashDropdown.getText().equalsIgnoreCase(TRAINER_DROPDOWN_TEXT));
    }

    @Step("Get the trainer dash logout")
    private boolean getTrainerDashLogout(){
        final WebElement trainerDashLogout = driver.findElement(vsTrainerDashLogoutLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Trainer Logout").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(trainerDashLogout));
        highlightElement(trainerDashLogout);
        return trainerDashLogout.isDisplayed() && (trainerDashLogout.getText().equalsIgnoreCase(TRAINER_LOGOUT_TEXT));
    }

    @Step("Get the trainer dash questionnaire modal")
    private boolean getTrainerDashQuestionnaireModal(){
        Util.waitMilliseconds(2000); // Give time for pop-up modal to appear in DOM
        final WebElement trainerDashQuestionModal = driver.findElement(vsTrainerDashQuestionnaireModalLocator);
        new WebDriverWait(driver, 10).
                pollingEvery(Duration.ofMillis(100)).
                withMessage("Could Not Find Questionnaire Modal").
                withTimeout(Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(trainerDashQuestionModal));
        highlightElement(trainerDashQuestionModal);
        return trainerDashQuestionModal.isDisplayed();
    }

    //// Verifiers ////
    @Step("Check: Verify Trainer Dash Page Logo Is Displayed")
    public void verifyTrainerDashLogoIsDisplayed() throws InterruptedException {
        if (!getTrainerDashLogo()) {
            throw new InterruptedException("Trainer Dash Page Logo NOT Displayed");
        } else {
            System.out.println("Trainer Dash Page Logo Displayed");
        }
    }

    @Step("Check: Verify Trainer Dash Dropdown Menu Is Displayed")
    public void verifyTrainerDropdownMenuDisplayed() throws InterruptedException {
        if (!getTrainerDashDropdownMenu()) {
            throw new InterruptedException("Trainer Dash Page Dropdown Menu NOT Displayed");
        } else {
            System.out.println("Trainer Dash Page Dropdown Menu Displayed");
        }
    }

    @Step("Check: Verify Trainer Dash Questionnaire Modal Is Displayed")
    public void verifyQuestionnaireModal() throws InterruptedException {
        if (!getTrainerDashQuestionnaireModal()) {
            throw new InterruptedException("Trainer Dash Page Questionnaire Modal NOT Displayed");
        } else {
            System.out.println("Trainer Dash Questionnaire Modal Displayed");
        }
    }

    @Step("Check: Verify Trainer Dash Page Is Displayed")
    public static void verifyTrainerDashPage() throws Exception {
        //// Verify trainer dash page logo ////
        vsTrainerPage.verifyTrainerDashLogoIsDisplayed();

        //// Verify trainer dropdown menu displays ////
        vsTrainerPage.verifyTrainerDropdownMenuDisplayed();
    }

}
