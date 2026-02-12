package tests;

import org.testng.annotations.Test;
import com.microsoft.playwright.Locator;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductCartTest extends BaseTest {

    @Test
    public void verifyAddProductToCart() {
        page.navigate("https://automationexercise.com/product_details/1");

        // استخدام الضغط القسري (Force Click)
        page.locator("button.add-to-cart").click(new Locator.ClickOptions().setForce(true));

        page.click("u:has-text('View Cart')");
        assertThat(page.locator("text=Blue Top")).isVisible();
        System.out.println("تمت إضافة المنتج بنجاح.");
    }
}