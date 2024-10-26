package com.fashionhub.fwk.web.pages;

import com.fashionhub.fwk.web.utils.ConfigurationsLoader;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BasePage {

    protected final Page page;
    protected List<String> consoleErrors;

    public BasePage(Page page) {
        this.page = page;
        this.consoleErrors = new ArrayList<>();
    }

    public abstract String getPageUrl();

    public void openPage() {
        listenErrorConsoleMessages();

        this.page.navigate(getPageUrl());
        page.waitForURL(getPageUrl());
    }

    public boolean hasNoConsoleErrors() {
        return consoleErrors.isEmpty();
    }

    protected boolean isDisplayed(Page page, String selector) {
        ElementHandle element = page.waitForSelector(selector, buildSelectorOptions());
        return Objects.nonNull(element) && element.isVisible();
    }

    private void listenErrorConsoleMessages() {
        this.page.onConsoleMessage(consoleMessage -> {
            if(StringUtils.equals(consoleMessage.type(), "error")) {
                consoleErrors.add(consoleMessage.text());
            }
        });
    }

    private Page.WaitForSelectorOptions buildSelectorOptions() {
        Page.WaitForSelectorOptions selectorOptions =  new Page.WaitForSelectorOptions();
        selectorOptions.setTimeout(5000d);
        return selectorOptions;
    }
}
