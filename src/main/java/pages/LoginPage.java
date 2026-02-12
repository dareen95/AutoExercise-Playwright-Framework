package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.options.WaitUntilState;

public class LoginPage {
    private Page page;
    private String loginEmailInput = "input[data-qa='login-email']";
    private String loginPasswordInput = "input[data-qa='login-password']";
    private String loginButton = "button[data-qa='login-button']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String email, String password) {
        page.navigate("https://automationexercise.com/login",
                new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));


        page.waitForSelector(loginEmailInput,
                new Page.WaitForSelectorOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(60000));

        page.fill(loginEmailInput, email);
        page.fill(loginPasswordInput, password);
        page.click(loginButton);
    }
}