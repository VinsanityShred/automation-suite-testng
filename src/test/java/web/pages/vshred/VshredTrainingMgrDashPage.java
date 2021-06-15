package web.pages.vshred;

import org.openqa.selenium.WebDriver;

public class VshredTrainingMgrDashPage extends VshredTrainerDashPage {
    public static VshredTrainingMgrDashPage vsTrainingMgrPage;

    public VshredTrainingMgrDashPage(WebDriver driver) {
        super(driver);
    }

    public static void createTrainingMgrDashPage(WebDriver driver) {
        vsTrainingMgrPage = new VshredTrainingMgrDashPage(driver);
    }
}
