package org.fundacionjala.pivotal.steps.ui.project;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.account.Account;
import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.fundacionjala.pivotal.pages.project.CreateProject;
import org.fundacionjala.pivotal.pages.project.DeleteProject;
import org.fundacionjala.pivotal.pages.project.EditProject;
import org.fundacionjala.pivotal.pages.project.PageLogin;
import org.fundacionjala.pivotal.steps.FeatureNames;
import org.fundacionjala.pivotal.util.Helper;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

/**
 * Class that contains the assertion steps of Project feature.
 */
@SuppressWarnings("ALL")
public class ProjectAssertionSteps {

    private Account account;
    private final Assertion assertion;
    private EditProject editProject;
    private DashBoard dashBoard;
    private FeatureNames feature;
    private PageLogin pageLogin;
    private CreateProject createProject;
    private FeatureNames proyName;
    private DeleteProject deleteProject;

    /**
     * @param editProject   EditProject page object.
     * @param dashBoard     Dashboard page object.
     * @param deleteProject DeleteProject page object.
     * @param account       EditProject page
     * @param feature       Account page object.
     * @param pageLogin     Login page object.
     * @param createProject CreateProject page object.
     * @param proyName      name of the project.
     * @param helper        Helper object.
     */

    // CSOFF: ParameterNumber
    public ProjectAssertionSteps(final EditProject editProject, final DashBoard dashBoard,
                                 final DeleteProject deleteProject, final Account account,
                                 final FeatureNames feature, final PageLogin pageLogin,
                                 final CreateProject createProject, final FeatureNames proyName, final Helper helper) {
        // CSON: ParameterNumber
        this.editProject = editProject;
        this.dashBoard = dashBoard;
        this.account = account;
        this.assertion = helper.getAssertion();
        this.feature = feature;
        this.pageLogin = pageLogin;
        this.createProject = createProject;
        this.proyName = proyName;
        this.deleteProject = deleteProject;
    }

    /**
     * Verify that is created the account.
     */
    @Then("^I can verify the new account$")
    public void iCanVerifyTheNewAccount() {
        assertion.assertTrue(account.verifyTheAccountName());
    }

    /**
     * Method for Verify the message of saved changes.
     *
     * @param message String.
     */
    @Then("^I can verify the message saved \"([^\"]*)\"$")
    public void iCanVerifyTheMessageSaved(final String message) {
        assertion.assertEquals(message, editProject.setMessageSaved());
    }

    /**
     * Method for return to dashboard.
     */
    @Then("^I return to dashboard and verify the project$")
    public void iReturnToDashboardAndVerifyTheProject() {
        dashBoard.setButtonDashborad();
        assertion.assertEquals(feature.getProjectName(), editProject.getTitleProject());
    }

    /**
     * Then can see login page.
     */
    @Then("^I can see the Login Page$")
    public void iCanSeeTheLoginPage() {
        assertion.assertTrue(pageLogin.checkPageLogin());
    }

    /**
     * Verify that is created the project.
     */
    @Then("^I can verify the new project with the project name$")
    public void iCanVerifyTheNewProjectWithProjectName() {
        assertion.assertEquals(proyName.getProjectName(), createProject.verifyName());
    }

    /**
     * Method for Expect Message was success full Deleted.
     */
    @Then("^I can verify the project deleted$")
    public void iCanVerifyTheProjectDeleted() {
        Assert.assertTrue(deleteProject.setMessageDelete());
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
