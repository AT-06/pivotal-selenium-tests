package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.objects.Account;
import org.testng.Assert;

/**
 * Class for Create Account.
 */
public class AccountSteps {
    private Account account = new Account();

    /**
     * Method for create an account.
     * @param accountName String.
     */
    @Given("^I can create a new \"([^\"]*)\" account$")
    public void iCanCreateANewAccount(String accountName) {
        // Write code here that turns the phrase above into concrete actions
        account.createAccount(accountName);
    }

    /**
     * Verify that is created the account.
     */
    @Then("^I can verify the new account$")
    public void iCanVerifyTheNewAccount() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(account.verifyTheAccountName());
    }
}
