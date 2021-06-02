package web.pages.vshred;

import framework.utility.Util;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VshredOrderFormGoldCoachingPage extends VshredOrderFormPlatinumCoachingPage {
    public static VshredOrderFormGoldCoachingPage vsGoldCoachingOrderFormPage;

    public VshredOrderFormGoldCoachingPage(WebDriver driver) { super(driver); }

    public static void createVSGoldCoachingOrderFormPage(WebDriver driver) {
        vsGoldCoachingOrderFormPage = new VshredOrderFormGoldCoachingPage(driver);
    }
}
