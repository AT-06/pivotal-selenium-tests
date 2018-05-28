package org.fundacionjala.pivotal.steps.project;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.fundacionjala.pivotal.pages.project.EditProject;
import org.fundacionjala.pivotal.pages.project.ProjectDescription;
import org.fundacionjala.pivotal.steps.FeatureNames;
import org.testng.Assert;
import java.util.Map;

/**
 * Class por Edit Project Steps.
 */
public class EditProjectSteps  {
    private EditProject editProject;
    private DashBoard dashBoard;
    private FeatureNames feature;

    /**
     * Constructor for EditProjectSteps class.
     *
     * @param editProject object.
     * @param dashBoard   object.
     */
    public EditProjectSteps(final EditProject editProject, final DashBoard dashBoard, final FeatureNames feature) {
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

    /**
     * Method for Verify the message of saved changes.
     *
     * @param message String.
     */
    @Then("^I can verify the message saved \"([^\"]*)\"$")
    public void iCanVerifyTheMessageSaved(final String message) {
        Assert.assertEquals(message, editProject.setMessageSaved());
    }


}
