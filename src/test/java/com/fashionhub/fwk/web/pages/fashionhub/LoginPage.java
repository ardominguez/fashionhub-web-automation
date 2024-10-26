package com.fashionhub.fwk.web.pages.fashionhub;

import com.fashionhub.fwk.web.pages.BasePage;
import com.fashionhub.fwk.web.pages.fashionhub.locators.LoginPageLocators;
import com.fashionhub.fwk.web.utils.ConfigurationsLoader;
import com.microsoft.playwright.Page;
import org.apache.commons.lang3.StringUtils;

import static com.fashionhub.fwk.web.utils.ConfigurationsLoader.getConfigValue;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    @Override
    public String getPageUrl() {
        return String.format("%s/fashionhub/login.html",  getConfigValue("fashionhub.baseUrl"));
    }

    public void fillLoginFormWithValidCredentials() {
        String validUsername = ConfigurationsLoader.getConfigValue("fashionhub.loginPage.validUsername");
        String validPassword = ConfigurationsLoader.getConfigValue("fashionhub.loginPage.validPassword");

        fillUsername(validUsername);
        fillPassword(validPassword);
    }

    public void fillLoginFormWithInvalidCredentials() {
        String invalidUsername = ConfigurationsLoader.getConfigValue("fashionhub.loginPage.invalidUsername");
        String invalidPassword = ConfigurationsLoader.getConfigValue("fashionhub.loginPage.invalidPassword");

        fillUsername(invalidUsername);
        fillPassword(invalidPassword);
    }

    public void fillUsername(String username) {
        page.fill(LoginPageLocators.USERNAME_INPUT, username);
    }

    public void fillPassword(String password) {
        page.fill(LoginPageLocators.PASSWORD_INPUT, password);
    }

    public void submitLogin() {
        page.click(LoginPageLocators.LOGIN_INPUT_BUTTON);
    }

    public boolean isLoginPage() {
        return StringUtils.equals(this.page.url(), getPageUrl());
    }

    public boolean errorMessageIsDisplayed() {
        String errorMessage = page.locator(LoginPageLocators.INVALID_CREDENTIALS_ERROR_MESSAGE_DIV).textContent();
        return StringUtils.equals(errorMessage, "Invalid username or password.");
    }
}
