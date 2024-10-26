package com.fashionhub.fwk.web.steps;

import com.fashionhub.fwk.web.pages.fashionhub.AccountPage;
import com.fashionhub.fwk.web.pages.fashionhub.LoginPage;
import com.fashionhub.fwk.web.hook.Hooks;
import com.fashionhub.fwk.web.hook.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerLoginSteps {

    private final LoginPage loginPage;
    private final AccountPage accountPage;

    public CustomerLoginSteps(TestContext testContext) {
        this.loginPage = new LoginPage(testContext.getPage());
        this.accountPage = new AccountPage(testContext.getPage());
    }

    @Given("The customer is on the login page")
    public void the_customer_is_on_the_login_page() {
        loginPage.openPage();
    }

    @When("The customer enters valid credentials")
    public void the_customer_enters_valid_credentials() {
        loginPage.fillLoginFormWithValidCredentials();
    }

    @When("The customer enters invalid credentials")
    public void the_customer_enters_invalid_credentials() {
        loginPage.fillLoginFormWithInvalidCredentials();
    }

    @And("The customer clicks the login button")
    public void the_customer_clicks_the_login_button() {
        loginPage.submitLogin();
    }

    @Then("The customer should remain on the login page")
    public void the_customer_should_remain_on_the_login_page() {
        assertTrue(this.loginPage.isLoginPage(), "The customer is not on the account page");
    }

    @Then("The customer should see an error message")
    public void the_customer_should_see_an_error_message() {
        assertTrue(this.loginPage.errorMessageIsDisplayed(), "The invalid login error message was not displayed");
    }

    @Then("The customer should be redirected to the Account page")
    public void the_customer_should_be_redirected_to_the_account_page() {
        assertTrue(accountPage.isAccountPageUrl(), "The customer is not on the account page");
    }

    @Then("The customer should see a welcome message")
    public void the_customer_should_see_a_welcome_message() {
        assertTrue(this.accountPage.isWelcomeMessageDisplayed(), "The welcome message was not displayed");
    }

    @Then("The customer should see a logout button")
    public void the_customer_should_see_a_logout_button() {
        assertTrue(this.accountPage.isLogoutButtonDisplayed(), "The logout button was not displayed");
    }
}
