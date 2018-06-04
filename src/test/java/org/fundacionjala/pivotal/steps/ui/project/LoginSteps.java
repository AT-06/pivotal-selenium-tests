package org.fundacionjala.pivotal.steps.ui.project;

import cucumber.api.java.en.Given;
import org.fundacionjala.pivotal.util.PropertiesConfig;
import org.fundacionjala.pivotal.pages.project.PageLogin;

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
        pageLogin.signIn(PropertiesConfig.getInstance()
                .getUser(), PropertiesConfig.getInstance().getPassword());
    }
}
