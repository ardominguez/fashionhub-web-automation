package com.fashionhub.fwk.web.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.apache.commons.lang3.StringUtils;

public class BrowserFactory {

    private BrowserFactory() {}

    public static Browser create(Playwright playwright, String browser) {
        BrowserType browserType = switch (browser) {
            case "firefox" -> playwright.firefox();
            case "safari" -> playwright.webkit();
            default -> playwright.chromium();
        };

        return browserType.launch(buildLunchOptions());
    }

    public static BrowserType.LaunchOptions buildLunchOptions() {
        return new BrowserType.LaunchOptions().setHeadless(getHeadless());
    }

    private static boolean getHeadless() {
        String headlessArg = System.getProperty("headless");
        return StringUtils.isBlank(headlessArg) || !StringUtils.equals("false", headlessArg);
    }
}
