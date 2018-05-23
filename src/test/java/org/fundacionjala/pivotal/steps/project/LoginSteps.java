package org.fundacionjala.pivotal.steps.project;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.utils.PropertiesConfig;
import org.fundacionjala.pivotal.pages.project.PageLogin;
import org.testng.Assert;

/**
 * Class of Login Steps.
 */
public class LoginSteps {
    /**
     * Constructor for LoginSteps class.
     *
     * @param pageLogin object.
     */
    public LoginSteps(final PageLogin pageLogin) {
        this.pageLogin = pageLogin;
    }

    private PageLogin pageLogin;

    /**
     * Given a valid user and password.
     */
    @Given("I put a valid user and Password")
    public void iPutAValidAnd() {
        pageLogin.asLogin(PropertiesConfig.getPropertiesConfig()
                .getUser(), PropertiesConfig.getPropertiesConfig().getPassword());
    }

    /**
     * Then can see login page.
     */
    @Then("^I can see the Login Page$")
    public void iCanSeeTheLoginPage() {
        Assert.assertTrue(pageLogin.checkPageLogin());
    }
}
