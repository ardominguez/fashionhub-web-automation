package com.fashionhub.fwk.web.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class ParallelExecutionHandler {

    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();

    public static void addParallelExecution(Browser browser) {
        var browserContext = browser.newContext();

        browserContextThreadLocal.set(browserContext);
        pageThreadLocal.set(browserContext.newPage());
    }

    public synchronized static Page getPage() {
        return pageThreadLocal.get();
    }

    public synchronized static BrowserContext getBrowserContext() {
        return browserContextThreadLocal.get();
    }
}
