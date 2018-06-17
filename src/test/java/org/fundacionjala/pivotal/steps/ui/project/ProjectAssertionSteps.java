package org.fundacionjala.pivotal.steps.ui.project;

import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.fundacionjala.pivotal.pages.project.CreateProject;
import org.fundacionjala.pivotal.pages.project.DeleteProject;
import org.fundacionjala.pivotal.pages.project.EditProject;
import org.fundacionjala.pivotal.util.Helper;

/**
 * Class that contains the assertion steps of Project feature.
 */
public class ProjectAssertionSteps {

    private final Assertion assertion;
    private EditProject editProject;
    private DashBoard dashBoard;
    private Helper feature;
    private CreateProject createProject;
    private DeleteProject deleteProject;

    /**
     * @param editProject   EditProject page object.
     * @param dashBoard     Dashboard page object.
     * @param deleteProject DeleteProject page object.
     * @param createProject CreateProject page object..
     * @param helper        Helper object.
     */

    public ProjectAssertionSteps(final EditProject editProject, final DashBoard dashBoard,
                                 final DeleteProject deleteProject, final CreateProject createProject,
                                 final Helper helper) {
        this.editProject = editProject;
        this.dashBoard = dashBoard;
        this.assertion = helper.getAssertion();
        this.feature = helper;
        this.createProject = createProject;
        this.deleteProject = deleteProject;
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
     * Verify that is created the project.
     */
    @Then("^I can verify the new project with the project name$")
    public void iCanVerifyTheNewProjectWithProjectName() {
        assertion.assertEquals(feature.getProjectName(), createProject.verifyName());
    }

    /**
     * Method for Expect Message was success full Deleted.
     */
    @Then("^I can verify the project deleted$")
    public void iCanVerifyTheProjectDeleted() {
        Assert.assertTrue(deleteProject.setMessageDelete());
    }

}
