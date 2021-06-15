package web.tests.vshred;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;

@Feature("Purchase")
@Story("Special diet 4-week plan test")
@Listeners( framework.testng.AllureScreenshots.class )
public class VSDietFourWeekTest extends VSDietMultiWeekTest {
    // Class created so specific test name could be indicated in class name while using more general
    //   VSDietMultiWeekTest class to do the work. Any future customizations necessary can be
    //   implemented here
}
