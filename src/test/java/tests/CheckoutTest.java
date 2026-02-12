package tests;

import org.testng.annotations.Test;
import pages.CheckoutPage;
import com.microsoft.playwright.Locator;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyFullCheckoutProcess() {
        CheckoutPage checkoutPage = new CheckoutPage(page);

        page.navigate("https://automationexercise.com/view_cart");

        // الضغط القسري على زر الـ Checkout
        page.locator(".check_out").click(new Locator.ClickOptions().setForce(true));

        checkoutPage.enterPaymentDetails("Gemini AI", "4111111111111111", "311", "12", "2027");

        assertThat(page.locator("text=Order Placed!")).isVisible();
    }
}