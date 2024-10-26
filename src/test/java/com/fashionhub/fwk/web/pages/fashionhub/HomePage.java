package com.fashionhub.fwk.web.pages.fashionhub;

import com.fashionhub.fwk.web.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

import static com.fashionhub.fwk.web.utils.ConfigurationsLoader.getConfigValue;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    @Override
    public String getPageUrl() {
        return String.format("%s/fashionhub/",  getConfigValue("fashionhub.baseUrl"));
    }

    public Set<String> getAllPageLinks() {
        Set<String> linksUrl = new HashSet<>();

        Locator aTagLocators = this.page.locator("a");

        for(Locator aTag: aTagLocators.all()) {
            String hrefLink = aTag.getAttribute("href");

            if(!StringUtils.startsWithAny(hrefLink, "http", "https")) {
                hrefLink = String.format("%s%s",  getConfigValue("fashionhub.baseUrl"), hrefLink);
            }

            linksUrl.add(hrefLink);
        }

        return linksUrl;
    }
}
