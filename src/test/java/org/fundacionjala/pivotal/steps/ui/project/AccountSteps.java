package org.fundacionjala.pivotal.steps.ui.project;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.account.Account;
import org.fundacionjala.pivotal.util.Helper;
import org.testng.asserts.Assertion;

/**
 * Class for Create account.
 */
public class AccountSteps {
    private Account account;
    private final Assertion assertion;

    /**
     * Constructor for AccountSteps class.
     *
     * @param account account object.
     * @param helper  object.
     */
    public AccountSteps(final Account account, final Helper helper) {
        this.account = account;
        this.assertion = helper.getAssertion();
    }

    /**
     * Method for create an account.
     *
     * @param accountName String.
     */
    @Given("^I can create a new \"([^\"]*)\" account$")
    public void iCanCreateANewAccount(final String accountName) {
        account.createAccount(accountName);
    }

    /**
     * Verify that is created the account.
     */
    @Then("^I can verify the new account$")
    public void iCanVerifyTheNewAccount() {
        assertion.assertTrue(account.verifyTheAccountName());
    }

}
