package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.common.PropertiesConfig;
import org.fundacionjala.pivotal.objects.PageLogin;
import org.testng.Assert;

/**
 * Class of Login Steps.
 */
public class LoginSteps {
    private PageLogin pageLogin = new PageLogin();

    //@Before("@selenium")
    @Given("I put a valid user and Password")
    public void iPutAValidAnd() {
        pageLogin.asLogin(PropertiesConfig.getPropertiesConfig().getUser(), PropertiesConfig.getPropertiesConfig().getPassword());
    }

    @Then("^I can see the Login Page$")
    public void iCanSeeTheLoginPage() {
        Assert.assertTrue(pageLogin.checkPageLogin());
    }
}
