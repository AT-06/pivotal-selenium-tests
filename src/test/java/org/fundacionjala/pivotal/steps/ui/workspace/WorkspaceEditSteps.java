package org.fundacionjala.pivotal.steps.ui.workspace;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.common.Navigator;
import org.fundacionjala.pivotal.pages.workspace.EditWorkspace;
import org.testng.Assert;

/**
 * Class WorkspaceEditSteps to call methods to create a feature.
 */
public class WorkspaceEditSteps {
    private EditWorkspace editWorkspace;
    private Navigator nav;

    /**
     * Constructor for AccountSteps class.
     * @param nav Navigator.
     * @param editWorkspace account object.
     */
    public WorkspaceEditSteps(final EditWorkspace editWorkspace, final Navigator nav) {
        this.editWorkspace = editWorkspace;
        this.nav = nav;
    }


    /**
     * Step and to go to workspace tab.
     */
    @And("^I go to workspace tab$")
    public void iGoToWorkspaceTab() {
        nav.clickTabWorkspace();
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
     * return to workspace dashborard.
     */
    @Given("^I go to workspace$")
    public void iGoToWorkspace() {
        nav.clickTabWorkspace();
    }
}
