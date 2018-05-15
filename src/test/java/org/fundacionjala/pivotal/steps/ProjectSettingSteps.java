package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.objects.DashBoard;
import org.fundacionjala.pivotal.objects.DeleteProject;
import org.testng.Assert;

/**
 * Class for Project Settings Steps.
 */
public class ProjectSettingSteps {
    private DeleteProject deleteProject = new DeleteProject();
    private DashBoard dashBoard = new DashBoard();

    /**
     * Method for Click Settings.
     *
     * @param projectName String.
     */
    @When("^I click \"([^\"]*)\" settings$")
    public void iClickSettings(final String projectName) {
        dashBoard.setButtonDashborad();
        dashBoard.searchProject(projectName);
        deleteProject.deleteProject();
    }

    /**
     * Method for Expect Message was success full Deleted.
     */
    @Then("^I can verify the project deleted$")
    public void iCanVerifyTheProjectDeleted() {
        Assert.assertTrue(deleteProject.setMessageDelete());
    }
}
