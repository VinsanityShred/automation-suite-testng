package web.tests.vshred;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;

@Feature("Purchase")
@Story("Special gold coaching OTP plan test")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSGoldCoachingOTPTest extends VSGoldCoachingTest {
    // Class created so specific test name could be indicated in class name while using more general
    //   VSGoldCoachingTest class to do the work. Any future customizations necessary can be
    //   implemented here
}
