package com.fashionhub.fwk.web.hook;

import com.fashionhub.fwk.web.factory.BrowserFactory;
import com.fashionhub.fwk.web.factory.ParallelExecutionHandler;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.Getter;

@Getter
public class TestContext {

    private final Page page;
    private final Browser browser;
    private final BrowserContext browserContext;

    public TestContext() {
        Playwright playwright = Playwright.create();
        browser = BrowserFactory.create(playwright, getSelectedBrowser());

        ParallelExecutionHandler.addParallelExecution(browser);

        browserContext = ParallelExecutionHandler.getBrowserContext();
        page = ParallelExecutionHandler.getPage();
    }

    private String getSelectedBrowser() {
        return System.getProperty("browser", "chrome");
    }
}
