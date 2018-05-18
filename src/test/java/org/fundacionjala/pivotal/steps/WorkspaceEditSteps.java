package org.fundacionjala.pivotal.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.objects.Navigator;
import org.fundacionjala.pivotal.workspace.CreateWorkspace;
import org.fundacionjala.pivotal.workspace.EditWorkspace;
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
     * @param editWorkspace Account object.
     */
    public WorkspaceEditSteps(final EditWorkspace editWorkspace, Navigator nav) {
        this.editWorkspace = editWorkspace;
        this.nav = nav;
    }

    @And("^I go to workspace tab$")
    public void iGoToWorkspaceTab() {
        nav.clickTabWorkspace();
    }


    @And("^I select the last workspace created and I edit the workspace name \"([^\"]*)\" and press save$")
    public void iSelectTheLastWorkspaceCreatedAndIEditTheWorkspaceNameAndPressSave(String name) {
        editWorkspace.editWorkspace(name);
    }

    @Then("^Then I can verify the edit workspace$")
    public void thenICanVerifyTheEditWorkspace() {
        Assert.assertTrue(editWorkspace.getSuccessMessage().isDisplayed());
    }

    @Given("^I select the last workspace created and I delete the workspace$")
    public void iSelectTheLastWorkspaceCreatedAndIDeleteTheWorkspace() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
