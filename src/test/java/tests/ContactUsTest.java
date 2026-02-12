package tests;

import org.testng.annotations.Test;
import java.io.File;
import java.nio.file.Paths;
import com.microsoft.playwright.Locator;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactUsTest extends BaseTest {

    @Test
    public void verifyContactUsForm() {
        page.navigate("https://automationexercise.com/contact_us");

        page.fill("input[name='name']", "Aero Admin");
        page.fill("input[name='email']", "admin@aero.com");

        // تأمين وجود الملف
        File file = new File("test-file.txt");
        try { if (!file.exists()) file.createNewFile(); } catch (Exception e) {}

        page.setInputFiles("input[name='upload_file']", Paths.get(file.getAbsolutePath()));

        page.onceDialog(dialog -> dialog.accept());
        page.click("input[name='submit']");

        // التأكد من ظهور الرسالة حتى لو كانت مخفية جزئياً
        Locator status = page.locator(".status.alert.alert-success");
        status.scrollIntoViewIfNeeded();
        assertThat(status).isVisible();
    }
}