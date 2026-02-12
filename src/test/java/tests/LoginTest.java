package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test(description = "التحقق من تسجيل الدخول ببيانات صحيحة")
    public void verifyValidLogin() {
        page.navigate("https://automationexercise.com/login");
        // 1. إنشاء كائن من صفحة اللوجن وتمرير الـ page المشتركة له
        LoginPage loginPage = new LoginPage(page);

        // 2. تنفيذ عملية الدخول (تأكد من استخدام إيميل مسجل فعلياً في الموقع)
        loginPage.login("darin.mazen2019@gmail.com", "123456789");

        // 3. التحقق (Assertion): الموقع يظهر جملة "Logged in as [Username]" عند النجاح
        // سنستخدم Playwright Assertions لأنها تنتظر ظهور العنصر تلقائياً في المواقع البطيئة
        assertThat(page.locator("text=Logged in as")).isVisible();

        System.out.println("تم تسجيل الدخول بنجاح والانتقال للخطوة التالية.");
    }

    @Test(description = "التحقق من فشل الدخول ببيانات خاطئة", priority = 1)
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(page);

        // محاولة دخول ببيانات خاطئة
        loginPage.login("wrong_email@test.com", "wrong_pass");

        // التحقق من ظهور رسالة الخطأ الحمراء
        assertThat(page.locator("text=Your email or password is incorrect!")).isVisible();
    }
}