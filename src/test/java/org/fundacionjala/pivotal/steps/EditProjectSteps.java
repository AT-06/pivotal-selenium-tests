package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.objects.DashBoard;
import org.fundacionjala.pivotal.objects.DescriptionValues;
import org.fundacionjala.pivotal.objects.EditProject;
import org.testng.Assert;
import java.util.Map;

/**
 * Class por Edit Project Steps.
 */
public class EditProjectSteps extends Base {

    /**
     * Init editProject objects.
     */
    private EditProject editProject = new EditProject();

    /**
     * Init DashBoard objects.
     */
    private DashBoard dashBoard = new DashBoard();

    /**
     * Init Map of DescriptionValues objects.
     */
    private Map<DescriptionValues, Object> descriptions;

    /**
     * Method for select any project.
     * @param projectName String.
     */
    @When("^I select any project \"([^\"]*)\"$")
    public void iSelectAnyProject(String projectName) {
        // Write code here that turns the phrase above into concrete actions
        dashBoard.searchProject(projectName);
    }

    /**
     * Method for edit the project.
     * @param values Map<DescriptionValues, Object>.
     */
    @And("^I can edit the project$")
    public void iCanEditTheProject(Map<DescriptionValues, Object> values) {
        // Write code here that turns the phrase above into concrete actions
        this.descriptions = values;
        descriptions.keySet().stream().forEach(step -> editProject.getStrategyStepMap(descriptions).get(step).execute());
        editProject.setSaveEditProject();
    }

    /**
     * Method for Verify the message of saved changes.
     * @param message String.
     */
    @Then("^I can verify the message saved \"([^\"]*)\"$")
    public void iCanVerifyTheMessageSaved(String message) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(message, editProject.setMessageSaved());
        dashBoard.setButtonDashborad();
    }
}
