package org.fundacionjala.pivotal.steps.ui.project;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.fundacionjala.pivotal.pages.project.EditProject;
import org.fundacionjala.pivotal.pages.project.ProjectDescription;
import org.fundacionjala.pivotal.util.Helper;

import java.util.Map;

/**
 * Class por Edit Project Steps.
 */
public class EditProjectSteps {
    private EditProject editProject;
    private DashBoard dashBoard;
    private Helper feature;

    /**
     * Constructor for EditProjectSteps class.
     *
     * @param editProject object.
     * @param dashBoard   object.
     * @param feature     object.
     */
    public EditProjectSteps(final EditProject editProject, final DashBoard dashBoard, final Helper feature) {
        this.editProject = editProject;
        this.dashBoard = dashBoard;
        this.feature = feature;
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
        final Map<ProjectDescription, String> descriptions = values;
        descriptions.keySet()
                .forEach(step -> editProject.getStrategyStepMap(descriptions)
                        .get(step).execute());
        editProject.setSaveEditProject();
    }
}
