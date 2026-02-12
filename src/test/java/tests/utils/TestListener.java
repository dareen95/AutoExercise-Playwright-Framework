package tests.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.microsoft.playwright.Page;
import tests.BaseTest;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        // الآن الميثود getPage ستعمل لأننا أضفناها في BaseTest
        Page page = ((BaseTest) testClass).getPage();

        // كود أخذ سكرين شوت عند الفشل
        if (page != null) {
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(java.nio.file.Paths.get("screenshots/" + result.getName() + ".png")));
        }
    }
}