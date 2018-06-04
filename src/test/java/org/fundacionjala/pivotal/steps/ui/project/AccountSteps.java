package org.fundacionjala.pivotal.steps.ui.project;

import cucumber.api.java.en.Given;
import org.fundacionjala.pivotal.pages.account.Account;

/**
 * Class for Create account.
 */
public class AccountSteps {
    private Account account;

    /**
     * Constructor for AccountSteps class.
     *
     * @param account account object.
     */
    public AccountSteps(final Account account) {
        this.account = account;
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

}
