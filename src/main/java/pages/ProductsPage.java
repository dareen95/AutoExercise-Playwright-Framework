package pages;
import com.microsoft.playwright.Page;

public class ProductsPage {
    private Page page;

    private String searchInput = "#search_product";
    private String searchButton = "#submit_search";
    private String firstProductAddToCart = "(//a[@data-product-id='1'])[1]";
    private String viewCartLink = "u:has-text('View Cart')";

    public ProductsPage(Page page) {
        this.page = page;
    }

    public void searchForProduct(String productName) {
        page.fill(searchInput, productName);
        page.click(searchButton);
    }

    public void addFirstProductToCart() {
        page.hover(firstProductAddToCart); // ً لإظهار الزر
        page.click(firstProductAddToCart);
        page.click(viewCartLink);
    }
}