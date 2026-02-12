package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    private Page page;

    // 1. Locators
    private String cartButton = "a:has-text('Cart')";
    private String proceedToCheckoutBtn = "text=Proceed To Checkout";
    private String messageTextArea = "textarea[name='message']";
    private String placeOrderBtn = "a[href='/payment']";
    private String nameOnCardInput = "input[name='name_on_card']";
    private String cardNumberInput = "input[name='card_number']";
    private String cvcInput = "input[name='cvc']";
    private String expiryMonthInput = "input[name='expiry_month']";
    private String expiryYearInput = "input[name='expiry_year']";
    private String payButton = "button#submit";

    public CheckoutPage(Page page) {
        this.page = page;
    }

    // 2. Methods
    public void proceedToPayment() {
        page.click(cartButton);
        page.click(proceedToCheckoutBtn);
        page.fill(messageTextArea, "Please deliver ASAP.");
        page.click(placeOrderBtn);
    }

    public void enterPaymentDetails(String name, String cardNum, String cvc, String month, String year) {
        page.fill(nameOnCardInput, name);
        page.fill(cardNumberInput, cardNum);
        page.fill(cvcInput, cvc);
        page.fill(expiryMonthInput, month);
        page.fill(expiryYearInput, year);
        page.click(payButton);
    }
}