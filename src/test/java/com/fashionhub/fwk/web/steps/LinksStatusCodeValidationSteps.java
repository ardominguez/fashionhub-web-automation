package com.fashionhub.fwk.web.steps;

import com.fashionhub.fwk.web.pages.fashionhub.HomePage;
import com.fashionhub.fwk.web.utils.APIUtils;
import com.fashionhub.fwk.web.hook.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinksStatusCodeValidationSteps {

    private final List<String> linksUrl;
    private final HomePage homePage;

    public LinksStatusCodeValidationSteps(TestContext testContext) {
        this.linksUrl = new ArrayList<>();
        this.homePage = new HomePage(testContext.getPage());
    }

    @Given("The customer is on the homepage")
    public void the_customer_is_on_the_homepage() {
        this.homePage.openPage();
    }

    @When("The customer get each link on the page")
    public void the_customer_visit_each_link_on_the_page() {
        linksUrl.addAll(this.homePage.getAllPageLinks());
    }

    @Then("Each link should return a status code of 200 or 30x")
    public void each_link_should_return_a_status_code_of_200_or_30x() {
        for (String link: this.linksUrl) {
            HttpResponse<String> response = APIUtils.doGet(link);

            int statusCode = response.statusCode();
            String errorMessage = String.format("Link %s return not expected status code: %s", link, statusCode);
            assertTrue(statusCode == 200 || (statusCode >= 300 && statusCode < 309), errorMessage);
        }
    }

    @Then("No link should return a status code of 40x")
    public void no_link_should_return_a_status_code_of_40_x() {
        for (String link: this.linksUrl) {
            HttpResponse<String> response = APIUtils.doGet(link);

            int statusCode = response.statusCode();
            String errorMessage = String.format("Link %s return not expected status code: %s", link, statusCode);
            assertFalse(statusCode > 400 && statusCode < 409, errorMessage);
        }
    }

}
