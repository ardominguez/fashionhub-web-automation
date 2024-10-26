package com.fashionhub.fwk.web.pages.github.locators;

public class PullRequestsPageLocators {

    private PullRequestsPageLocators() {}

    public static final String PR_TAB_COUNT_SPAN = "//span[@id='pull-requests-repo-tab-count']";
    public static final String PR_ITEM_LINKS = "//div[contains(@class, 'js-issue-row')]";
    public static final String PR_ITEM_LINKS_NAMES = "//div[contains(@class, 'js-issue-row')]//a[@data-hovercard-type='pull_request']";
    public static final String PR_ITEM_LINKS_DATES = "//div[contains(@class, 'js-issue-row')]//span[@class='opened-by']/relative-time";
    public static final String PR_ITEM_LINKS_USERS = "//div[contains(@class, 'js-issue-row')]//span[@class='opened-by']/a";
    public static final String PR_NEXT_PAGE_LINK = "//a[@class='next_page']";
    public static final String PR_DISABLED_NEXT_PAGE_LINK = "//a[contains(@class,'disabled')]";
}
