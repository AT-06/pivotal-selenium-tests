package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.objects.Account;
import org.testng.Assert;

/**
 * Class for Create Account.
 */
public class AccountSteps {
    private Account account;

    /**
     * Constructor for AccountSteps class.
     *
     * @param account Account object.
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

    /**
     * Verify that is created the account.
     */
    @Then("^I can verify the new account$")
    public void iCanVerifyTheNewAccount() {
        Assert.assertTrue(account.verifyTheAccountName());
    }
}
