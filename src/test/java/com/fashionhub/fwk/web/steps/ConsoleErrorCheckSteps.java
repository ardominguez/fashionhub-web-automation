package com.fashionhub.fwk.web.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fashionhub.fwk.web.pages.BasePage;
import com.fashionhub.fwk.web.pages.fashionhub.AboutPage;
import com.fashionhub.fwk.web.pages.fashionhub.CartPage;
import com.fashionhub.fwk.web.pages.fashionhub.HomePage;
import com.fashionhub.fwk.web.pages.fashionhub.ProductsPage;
import com.fashionhub.fwk.web.hook.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ConsoleErrorCheckSteps {

    private final HomePage homePage;
    private final CartPage cartPage;
    private final AboutPage aboutPage;
    private final ProductsPage productsPage;

    public ConsoleErrorCheckSteps(TestContext testContext) {
        homePage = new HomePage(testContext.getPage());
        cartPage = new CartPage(testContext.getPage());
        aboutPage = new AboutPage(testContext.getPage());
        productsPage = new ProductsPage(testContext.getPage());
    }

    @Given("The customer is on the {string} page")
    public void the_customer_is_on_the_home_page(String page) {
        BasePage pageObj = getPage(page);
        pageObj.openPage();
    }


    @Then("In the {string} page there should be no errors in the browser console")
    public void in_the_home_page_there_should_be_no_errors_in_the_browser_console(String page) {
        BasePage pageObj = getPage(page);
        assertTrue(pageObj.hasNoConsoleErrors());

    }

    private BasePage getPage(String page) {
       return switch (page) {
            case "Products" -> this.productsPage;
            case "Cart" -> this.cartPage;
            case "About" -> this.aboutPage;
            default -> this.homePage;
        };
    }
}
