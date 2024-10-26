package com.fashionhub.fwk.web.steps;

import com.fashionhub.fwk.web.dto.PullRequestInfoDTO;
import com.fashionhub.fwk.web.pages.github.PullRequestsPage;
import com.fashionhub.fwk.web.hook.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RetrieveOpenPullRequestSteps {

    private final List<PullRequestInfoDTO> pullRequestList;
    private final PullRequestsPage pullRequestsPage;

    public RetrieveOpenPullRequestSteps(TestContext testContext) {
        this.pullRequestList = new ArrayList<>();
        this.pullRequestsPage = new PullRequestsPage(testContext.getPage());
    }

    @Given("The product owner visits {string} repository pull requests page from {string} owner")
    public void the_product_owner_visits_x_repository_pull_requests_page_from_x_owner(String repository, String owner) {
        pullRequestsPage.openPage(owner, repository);
    }

    @When("The product owner gets the list of open pull requests")
    public void the_product_owner_gets_the_list_of_open_pull_requests() {
        List<PullRequestInfoDTO> prInfoList = pullRequestsPage.getOpenPullRequestList();
        pullRequestList.addAll(prInfoList);
    }

    @Then("A CSV file with {string} as name should be generated with the list of open pull requests")
    public void a_csv_file_should_be_generated_with_the_list_of_open_pull_requests(String repository) {
        pullRequestsPage.saveCsvReport(repository, pullRequestList);
        assertEquals(pullRequestsPage.getTotalOpenPullRequest(), pullRequestList.size());
    }
}
