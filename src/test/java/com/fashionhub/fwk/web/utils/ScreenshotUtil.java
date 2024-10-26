package com.fashionhub.fwk.web.utils;

import com.microsoft.playwright.Page;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static byte[] saveScreenshotFile(final Page page, final String filename) {
        return page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(String.format("reports/images/%s.png", filename))));
    }
}
