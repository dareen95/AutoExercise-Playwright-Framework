
package pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;

    protected static LoginPage loginPage;
    protected static ProductsPage productsPage;
    protected static CheckoutPage checkoutPage;

    @BeforeClass // يتنفذ مرة واحدة فقط لكل الكلاس
    public void setUp() {
        if (playwright == null) {
            playwright = Playwright.create();
            // تشغيل المتصفح (Headless = false لكي تراه أمامك)
            browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
            context = browser.newContext();
            page = context.newPage();

            // إعداد الـ Timeout لـ 60 ثانية لتجنب أخطاء الشبكة التي ظهرت عندك
            page.setDefaultNavigationTimeout(60000);
            page.setDefaultTimeout(30000);

            // الانتقال للموقع
            page.navigate("https://automationexercise.com/");

            // تهيئة الصفحات
            loginPage = new LoginPage(page);
            productsPage = new ProductsPage(page);
            checkoutPage = new CheckoutPage(page);
        }
    }

    @AfterClass // يغلق المتصفح بعد انتهاء آخر @Test في الكلاس
    public void tearDown() {
        if (browser != null) {
            // لا تغلق المتصفح هنا إذا كنت تريد استخدامه في كلاسات أخرى
            // أو اتركه مفتوحاً للمعاينة
            browser.close();
            playwright.close();
        }
    }

    public Page getPage() {
        return page;
    }
}