package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.objects.Navigator;
import org.fundacionjala.pivotal.workspace.CreateWorkspace;
import org.fundacionjala.pivotal.workspace.EditWorkspace;
import org.testng.Assert;

/**
 * Class WorkspaceSteps to execute functions of features.
 */
public class WorkspaceSteps {
    private CreateWorkspace createWorkspace;
    private Navigator nav;
    private String workspaceName;

    /**
     * Constructor for AccountSteps class.
     * @taram nav Navigator.
     * @param createWorkspace Account object.
     */
    public WorkspaceSteps(final CreateWorkspace createWorkspace, Navigator nav) {
        this.createWorkspace = createWorkspace;
        this.nav = nav;
    }

    /**
     * Method for create an account.
     */
    @Given("^I return to Dashboard and go to workspace tab$")
    public void iReturnToDashboardAndGoToWorkspaceTab() {
        nav.returnToDashboardFromProjWork();
        nav.clickTabWorkspace();
    }


    @And("^I can create a new \"([^\"]*)\" workspace$")
    public void iCanCreateANewWorkspace(String workspaceName) {
        createWorkspace.createWorkspace(workspaceName);
        createWorkspace.setWorkspaceName(workspaceName);
    }

    @Then("^I can verify the new workspace$")
    public void iCanVerifyTheNewWorkspace() {
        nav.returnToDashboardFromProjWork();
        nav.clickTabWorkspace();
        Assert.assertEquals(createWorkspace.getLastWorkspaceCreatedText(), createWorkspace.getWorkspaceName());
    }



}
