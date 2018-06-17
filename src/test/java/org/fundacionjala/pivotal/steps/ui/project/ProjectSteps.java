package org.fundacionjala.pivotal.steps.ui.project;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotal.api.APICommons;
import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.fundacionjala.pivotal.pages.project.CreateProject;
import org.fundacionjala.pivotal.pages.project.DeleteProject;
import org.fundacionjala.pivotal.pages.project.EditProject;
import org.fundacionjala.pivotal.pages.project.ProjectDescription;
import org.fundacionjala.pivotal.util.Helper;

import static org.fundacionjala.pivotal.pages.project.ProjectDescription.PROJECT_TITLE;

/**
 * Class Project Steps for create a project.
 */
public class ProjectSteps {
    private CreateProject createProject;
    private EditProject editProject;
    private DeleteProject deleteProject;
    private DashBoard dashBoard;
    private Helper feature;

    /**
     * Constructor for ProjectSteps class.
     *
     * @param createProject object.
     * @param editProject object.
     * @param deleteProject object.
     * @param dashBoard object.
     * @param feature object.
     */
    public ProjectSteps(final CreateProject createProject, final EditProject editProject,
                        final DeleteProject deleteProject, final DashBoard dashBoard, final Helper feature) {
        this.createProject = createProject;
        this.editProject = editProject;
        this.deleteProject = deleteProject;
        this.dashBoard = dashBoard;
        this.feature = feature;
    }

    /**
     * Steps of Creating a Project.
     *
     * @param values for enter.
     */
    @Given("^I can create a new project with the following values$")
    public void iCanCreateANewProjectWithTheFollowingValues(final Map<ProjectDescription, String> values) {
        createProject.setButtonCreateProject();
        values.keySet().forEach(step -> createProject.getStrategyStepMap(values).get(step).execute());
        createProject.setButtonCreate();
        feature.setProjectName(values.get(PROJECT_TITLE));
    }

    /**
     * Method for select any project.
     */
    @When("^I select the created project")
    public void iSelectTheCreatedProject() {
        dashBoard.setButtonDashborad();
        dashBoard.searchProject(feature.getProjectName());
    }

    /**
     * Method for edit the project.
     *
     * @param values Map<ProjectDescription, Object>.
     */
    @And("^I can edit the project$")
    public void iCanEditTheProject(final Map<ProjectDescription, String> values) {
        values.keySet()
                .forEach(step -> editProject.getStrategyStepMap(values).get(step).execute());
        editProject.setSaveEditProject();
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

