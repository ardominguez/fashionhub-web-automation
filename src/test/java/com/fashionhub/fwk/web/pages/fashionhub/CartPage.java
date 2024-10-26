package com.fashionhub.fwk.web.pages.fashionhub;

import com.fashionhub.fwk.web.pages.BasePage;
import com.microsoft.playwright.Page;

import static com.fashionhub.fwk.web.utils.ConfigurationsLoader.getConfigValue;

public class CartPage extends BasePage {

    public CartPage(Page page) {
        super(page);
    }

    @Override
    public String getPageUrl() {
        return String.format("%s/fashionhub/cart.html",  getConfigValue("fashionhub.baseUrl"));
    }
}
