package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

public class BasePage {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    public Page initBrowser(String url) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(100));

        BrowserContext context = browser.newContext();
        // زيادة وقت الانتظار الافتراضي لـ 90 ثانية بسبب بطء الموقع
        context.setDefaultTimeout(90000);
        page = context.newPage();

        // الدخول للموقع مع انتظار الاستجابة فقط وليس تحميل الإعلانات بالكامل
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.COMMIT));

        return page;
    }
}