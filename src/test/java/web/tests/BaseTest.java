package web.tests;

import bsh.ConsoleInterface;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class BaseTest {
    private WebDriver driver;
    private ConsoleInterface logger;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(String browser, String appURL) {
        switch (browser) {
            case "headless":
                System.out.println("Headless Chrome browser");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless", "--window-size=1920,1200");
                driver = new ChromeDriver(chromeOptions);
                System.out.printf("Window Size: " + driver.manage().window().getSize());
                break;
            case "chrome":
                System.out.println("Launching Chrome browser");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("Launching Firefox browser");
                driver = new FirefoxDriver();
                break;
            case "safari":
                System.out.println("Launching Safari browser");
                driver = new SafariDriver();
                break;
            case "edge":
                System.out.println("Launching Edge browser");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Launching Default browser: Chrome browser");
                driver = new ChromeDriver();
        }

        driver.get(appURL);
    }

    @Parameters({ "browser", "appURL" })
    @BeforeMethod
    public void initializeTestBaseSetup(String browser, String appURL) {
        try {
            setDriver(browser, appURL);

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}