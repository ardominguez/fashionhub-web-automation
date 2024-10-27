package com.fashionhub.fwk.web.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.apache.commons.lang3.StringUtils;

public class BrowserFactory {

    private BrowserFactory() {}

    public static Browser create(Playwright playwright, String browserName) {
        BrowserEnum browserEnum = BrowserEnum.fromName(browserName);

        BrowserType browserType = switch (browserEnum) {
            case FIREFOX -> playwright.firefox();
            case WEBKIT -> playwright.webkit();
            default -> playwright.chromium();
        };

        return browserType.launch(buildLunchOptions(browserEnum));
    }

    public static BrowserType.LaunchOptions buildLunchOptions(BrowserEnum browserEnum) {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(getHeadless());
        if(StringUtils.equals("chromium", browserEnum.getEngine())) {
            options.setChannel(browserEnum.getChannel());
        }
        return options;
    }

    private static boolean getHeadless() {
        String headlessArg = System.getProperty("headless");
        return StringUtils.isBlank(headlessArg) || !StringUtils.equals("false", headlessArg);
    }
}
