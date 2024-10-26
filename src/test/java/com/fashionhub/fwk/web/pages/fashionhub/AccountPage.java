package com.fashionhub.fwk.web.pages.fashionhub;

import com.fashionhub.fwk.web.pages.BasePage;
import com.fashionhub.fwk.web.pages.fashionhub.locators.AccountPageLocators;
import com.microsoft.playwright.Page;
import org.apache.commons.lang3.StringUtils;

import static com.fashionhub.fwk.web.utils.ConfigurationsLoader.getConfigValue;

public class AccountPage extends BasePage {

    public AccountPage(Page page) {
        super(page);
    }

    @Override
    public String getPageUrl() {
        return String.format("%s/fashionhub/account.html",  getConfigValue("fashionhub.baseUrl"));
    }

    public boolean isAccountPageUrl() {
        return StringUtils.equalsAnyIgnoreCase(this.page.url(), getPageUrl());
    }

    public boolean isWelcomeMessageDisplayed() {
        String welcomeMessage = page.locator(AccountPageLocators.WELCOME_MESSAGE_HEADER).textContent();
        return StringUtils.contains(welcomeMessage, "Welcome, ");
    }

    public boolean isLogoutButtonDisplayed() {
        return  isDisplayed(page, AccountPageLocators.LOGOUT_BUTTON);
    }
}
