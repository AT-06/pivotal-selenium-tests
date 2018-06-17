package org.fundacionjala.pivotal.steps.ui.workspace;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import org.fundacionjala.pivotal.pages.common.Navigator;
import org.fundacionjala.pivotal.pages.workspace.CreateWorkspace;
import org.fundacionjala.pivotal.pages.workspace.EditWorkspace;

/**
 * Class WorkspaceSteps to execute functions of features.
 */
public class WorkspaceSteps {
    private CreateWorkspace createWorkspace;
    private EditWorkspace editWorkspace;
    private Navigator nav;

    /**
     * Constructor for AccountSteps class.
     * @param createWorkspace object.
     * @param editWorkspace object.
     * @param nav Navigator.
     */
    public WorkspaceSteps(final CreateWorkspace createWorkspace, final EditWorkspace editWorkspace,
                          final Navigator nav) {
        this.createWorkspace = createWorkspace;
        this.editWorkspace = editWorkspace;
        this.nav = nav;
    }

    /**
     * Method for create a new workspace.
     * @param workspaceName string workspace name.
     */
    @And("^I can create a new \"([^\"]*)\" workspace$")
    public void iCanCreateANewWorkspace(final String workspaceName) {
        createWorkspace.createWorkspace(workspaceName);
        createWorkspace.setWorkspaceName(workspaceName);
    }

    /**
     * Step and to go to edit the workspace name.
     * @param name workspace.
     */
    @And("^I edit the workspace name \"([^\"]*)\" and press save$")
    public void iSelectTheWorkspaceCreatedAndIEditTheWorkspaceNameAndPressSave(final String name) {
        editWorkspace.editWorkspace(name);
    }
    /**
     * Step then to go to verify edit the workspace name.
     */
    @Then("^I can verify the edit workspace$")
    public void thenICanVerifyTheEditWorkspace() {
        Assert.assertTrue(editWorkspace.getSuccessMessage().isDisplayed());
    }

    /**
     * Step given to select the last workspace and delete it.
     */
    @Given("^I select the last workspace created and I delete it$")
    public void iGoToWorkspaceAndISelectTheLastWorkspaceCreatedAndIDeleteTheWorkspace() {
        nav.returnToDashboardFromProjWork();
        nav.clickTabWorkspace();
        editWorkspace.deleteLastWorkspace();
    }

    /**
     * return to workspace.
     */
    @Given("^I go to workspace$")
    public void iGoToWorkspace() {
        nav.clickTabWorkspace();
    }
}
