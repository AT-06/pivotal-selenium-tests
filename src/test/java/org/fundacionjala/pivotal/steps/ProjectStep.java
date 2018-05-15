package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.objects.CreateProject;
import org.fundacionjala.pivotal.objects.DashBoard;
import org.fundacionjala.pivotal.objects.ProjectValues;
import org.junit.Assert;
import java.util.Map;

/**
 * Class Project Steps for create a project
 */
public class ProjectStep {
    private CreateProject createProject = new CreateProject();
    private Map<ProjectValues, Object> projects;
    private DashBoard dashBoard = new DashBoard();

    /**
     * Steps of Creating a Project.
     *
     * @param values for enter.
     */
    @Given("^I can create a new project with the following values$")
    public void iCanCreateANewProjectWithTheFollowingValues(Map<ProjectValues, Object> values) {
        // Write code here that turns the phrase above into concrete actions
        this.projects = values;
        createProject.setButtonCreateProject();
        projects.keySet().stream().forEach((step) -> createProject.getStrategyStepMap(projects).get(step).execute());
        createProject.setButtonCreate();

    }

    /**
     * Verify taht is created the project.
     *
     * @param projectName name of project.
     */
    @Then("^I can verify the new project with \"([^\"]*)\" project name$")
    public void iCanVerifyTheNewProjectWithProjectName(String projectName) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(projectName, createProject.verifyName());
        //dashBoard.setButtonDashborad();
        //createProject.setGoToDashBoard();
    }

    /**
     * Method for Create a new project with the following Values and exits account.
     * @param values Map<ProjectValues, Object>.
     */
    @Given("^I can create a new project with the following values and exist Account$")
    public void iCanCreateANewProjectWithTheFollowingValuesAndExistAccount(Map<ProjectValues, Object> values) {
        // Write code here that turns the phrase above into concrete actions

        this.projects = values;
        createProject.setButtonCreateProject();
        projects.keySet().stream().forEach((step) -> createProject.getStrategyStepMap(projects).get(step).execute());
        createProject.setButtonCreate();
    }
}
