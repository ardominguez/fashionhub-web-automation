package com.fashionhub.fwk.web.pages.github;

import com.fashionhub.fwk.web.dto.PullRequestInfoDTO;
import com.fashionhub.fwk.web.pages.BasePage;
import com.fashionhub.fwk.web.pages.github.locators.PullRequestsPageLocators;
import com.fashionhub.fwk.web.utils.ConfigurationsLoader;
import com.fashionhub.fwk.web.utils.CsvFileUtils;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PullRequestsPage extends BasePage {

    public PullRequestsPage(Page page) {
        super(page);
    }

    @Override
    public String getPageUrl() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void openPage(String owner, String repository) {
        String pullRequestPage = String.format("https://github.com/%s/%s/pulls", owner, repository);
        page.navigate(pullRequestPage);
        page.waitForURL(pullRequestPage);
    }

    public List<PullRequestInfoDTO> getOpenPullRequestList() {
        List<PullRequestInfoDTO> openPrInfoList = new ArrayList<>();
        Locator nextLink = page.locator(PullRequestsPageLocators.PR_NEXT_PAGE_LINK);

        int currentPage = 1;
        int totalPullRequest = this.getTotalOpenPullRequest();

        do {

            Locator itemLinkLocators = page.locator(PullRequestsPageLocators.PR_ITEM_LINKS_NAMES);
            Locator dateLocators = page.locator(PullRequestsPageLocators.PR_ITEM_LINKS_DATES);
            Locator userLocators = page.locator(PullRequestsPageLocators.PR_ITEM_LINKS_USERS);

            for (int i = 0; i < itemLinkLocators.all().size(); i++) {
                String prName = itemLinkLocators.all().get(i).textContent();
                String prDatetime = dateLocators.all().get(i).getAttribute("datetime");
                String prUser = userLocators.all().get(i).textContent();

                PullRequestInfoDTO prInfo = new PullRequestInfoDTO(prName, prDatetime, prUser);
                openPrInfoList.add(prInfo);
            }

            if(nextLink.count() == 0) {
                break;
            }

            nextLink.first().click();
            page.waitForURL(String.format("**/pulls?page=%s**", ++currentPage));

        } while (openPrInfoList.size() < totalPullRequest);

        return openPrInfoList;
    }



    private boolean isLinkEnabled(Locator locator) {
        return StringUtils.isNotBlank(locator.getAttribute("href"));
    }

    public int getTotalOpenPullRequest() {
        String pullRequestStr = this.page.locator(PullRequestsPageLocators.PR_TAB_COUNT_SPAN).textContent();
        return Integer.parseInt(pullRequestStr);
    }

    public void saveCsvReport(String repository, List<PullRequestInfoDTO> pullRequestList) {
        CsvFileUtils.saveCsvFile(repository, pullRequestList);
    }
}
