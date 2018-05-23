package org.fundacionjala.pivotal.steps.workspace;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.common.Navigator;
import org.fundacionjala.pivotal.pages.workspace.CreateWorkspace;
import org.testng.Assert;

/**
 * Class WorkspaceSteps to execute functions of features.
 */
public class WorkspaceSteps {
    private CreateWorkspace createWorkspace;
    private Navigator nav;

    /**
     * Constructor for AccountSteps class.
     * @param nav Navigator.
     * @param createWorkspace Account object.
     */
    public WorkspaceSteps(final CreateWorkspace createWorkspace, final Navigator nav) {
        this.createWorkspace = createWorkspace;
        this.nav = nav;
    }

    /**
     * Method for return to dashboard.
     */
    @Given("^I return to Dashboard and go to workspace tab$")
    public void iReturnToDashboardAndGoToWorkspaceTab() {
        nav.returnToDashboardFromProjWork();
        nav.clickTabWorkspace();
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
     * Method to verify the creation of a new workspace.
     */
    @Then("^I can verify the new workspace$")
    public void iCanVerifyTheNewWorkspace() {
        nav.returnToDashboardFromProjWork();
        nav.clickTabWorkspace();
        Assert.assertEquals(createWorkspace.getLastWorkspaceCreatedText(), createWorkspace.getWorkspaceName());
    }



}
