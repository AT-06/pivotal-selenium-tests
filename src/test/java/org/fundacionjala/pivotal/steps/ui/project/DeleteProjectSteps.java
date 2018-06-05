package org.fundacionjala.pivotal.steps.ui.project;


import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotal.core.api.APICommons;
import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.fundacionjala.pivotal.pages.project.DeleteProject;

/**
 * Class for Project Settings Steps.
 */
public class DeleteProjectSteps {
    private DeleteProject deleteProject;
    private DashBoard dashBoard;

    /**
     * Constructor for DeleteProjectSteps class.
     *
     * @param deleteProject object.
     * @param dashBoard     object.
     */
    public DeleteProjectSteps(final DeleteProject deleteProject, final DashBoard dashBoard) {
        this.deleteProject = deleteProject;
        this.dashBoard = dashBoard;
    }

    /**
     * Method for Click Settings.
     *
     * @param projectName String.
     */
    @When("^I click \"([^\"]*)\" settings$")
    public void iClickSettings(final String projectName) {
        dashBoard.setButtonDashborad();
        dashBoard.searchProject(APICommons.getElementResponse(projectName));
        deleteProject.deleteProject();
    }


    /**
     * Method for delete the project.
     */
    @And("^I delete the project$")
    public void iDeleteTheProject() {
        deleteProject.deleteProject();
    }
}
