package org.fundacionjala.pivotal.steps.ui.workspace;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.common.Navigator;
import org.fundacionjala.pivotal.pages.workspace.CreateWorkspace;
import org.fundacionjala.pivotal.pages.workspace.EditWorkspace;
import org.fundacionjala.pivotal.util.Helper;
import org.testng.asserts.Assertion;

/**
 * Class that contains the assertion steps of Workspace feature.
 */
public class WorkspaceAssertionSteps {
    private EditWorkspace editWorkspace;
    private Navigator nav;
    private Assertion assertion;
    private CreateWorkspace createWorkspace;

    /**
     * Constructor for AccountSteps class.
     *
     * @param nav             Navigator.
     * @param editWorkspace   account object.
     * @param createWorkspace account object.
     * @param helper          object.
     */

    public WorkspaceAssertionSteps(final EditWorkspace editWorkspace, final Navigator nav,
                                   final Helper helper, final CreateWorkspace createWorkspace) {
        this.editWorkspace = editWorkspace;
        this.nav = nav;
        this.assertion = helper.getAssertion();
        this.createWorkspace = createWorkspace;
    }

    /**
     * Step given to verify the delete workspace.
     */
    @Then("^I can verify the delete workspace$")
    public void thenICanVerifyTheDeleteWorkspace() {
        assertion.assertTrue(editWorkspace.getSuccessDeleteMessage().isDisplayed());
    }

    /**
     * Method to verify the creation of a new workspace.
     */
    @Then("^I can verify the new workspace$")
    public void iCanVerifyTheNewWorkspace() {
        nav.returnToDashboardFromProjWork();
        nav.clickTabWorkspace();
        assertion.assertEquals(createWorkspace.getLastWorkspaceCreatedText(), createWorkspace.getWorkspaceName());
    }

}
