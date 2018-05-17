package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.objects.DashBoard;
import org.fundacionjala.pivotal.objects.ProjectDescription;
import org.fundacionjala.pivotal.objects.EditProject;
import org.testng.Assert;

import java.util.Map;

/**
 * Class por Edit Project Steps.
 */
public class EditProjectSteps extends Base {
    private EditProject editProject;
    private DashBoard dashBoard;

    /**
     * Constructor for EditProjectSteps class.
     *
     * @param editProject object.
     * @param dashBoard   object.
     */
    public EditProjectSteps(final EditProject editProject, final DashBoard dashBoard) {
        this.editProject = editProject;
        this.dashBoard = dashBoard;
    }

    /**
     * Method for select any project.
     *
     * @param projectName String.
     */
    @When("^I select any project \"([^\"]*)\"$")
    public void iSelectAnyProject(final String projectName) {
        dashBoard.setButtonDashborad();
        dashBoard.searchProject(projectName);
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
