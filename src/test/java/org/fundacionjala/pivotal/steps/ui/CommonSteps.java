package org.fundacionjala.pivotal.steps.ui;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.core.util.PropertiesInput;
import org.fundacionjala.core.util.PropertiesManager;
import org.fundacionjala.pivotal.util.Helper;
import org.fundacionjala.pivotal.pages.PageLogin;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

/**
 * Class of Login Steps.
 */
public class CommonSteps {

    private final Assertion assertion;

    /**
     * Constructor for CommonSteps class.
     *
     * @param pageLogin object.
     * @param helper    object.
     */
    public CommonSteps(final PageLogin pageLogin, final Helper helper) {
        this.pageLogin = pageLogin;
        this.assertion = helper.getAssertion();
    }

    private PageLogin pageLogin;

    /**
     * Given a valid user and password.
     */
    @Given("I put a valid user and Password")
    public void iPutAValidAnd() {
        pageLogin.setUrl(PropertiesManager.getInstance().getProperties(PropertiesInput.URL_LOGIN));
        pageLogin.signIn(PropertiesManager.getInstance()
                .getProperties(PropertiesInput.USER), PropertiesManager
                .getInstance().getProperties(PropertiesInput.PASSWORD));
    }

    /**
     * Then can see login page.
     */
    @Then("^I can see the Login Page$")
    public void iCanSeeTheLoginPage() {
        assertion.assertTrue(pageLogin.checkPageLogin());
    }

    /**
     * Step for apply Soft Assertion.
     */
    @And("^Assert all$")
    public void assertAll() {
        if (assertion instanceof SoftAssert) {
            ((SoftAssert) assertion).assertAll();

        }
    }
}
