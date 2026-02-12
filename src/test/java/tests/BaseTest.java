package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import org.testng.annotations.*;
import pages.BasePage;

public class BaseTest {
    protected static Page page;
    protected static BasePage basePage;

    @BeforeSuite
    public void suiteSetup() {
        basePage = new BasePage();
        page = basePage.initBrowser("https://automationexercise.com/");

        //  منع تحميل الصور والفيديوهات
        page.route("**/*.{png,jpg,jpeg,svg,gif,webp,mp4}", route -> route.abort());

        // حذف الإعلانات برمجياً فور ظهورها
        page.addInitScript("() => { " +
                "  const observer = new MutationObserver(() => { " +
                "    document.querySelectorAll('ins.adsbygoogle, div[id^=\"google_ads\"], iframe[id^=\"aswift\"]').forEach(el => el.remove()); " +
                "  }); " +
                "  observer.observe(document.documentElement, { childList: true, subtree: true }); " +
                "}");

        page.setDefaultTimeout(60000);
    }

    public Page getPage() {
        return page;
    }

    @AfterSuite
    public void suiteTearDown() {
        if (page != null) {
            page.context().browser().close();
        }
    }
}