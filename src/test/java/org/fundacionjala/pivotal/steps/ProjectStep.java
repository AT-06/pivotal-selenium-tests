package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.objects.CreateProject;
import org.fundacionjala.pivotal.objects.ProjectValues;
import org.testng.Assert;

import java.util.Map;


/**
 * Class Project Steps for create a project.
 */
public class ProjectStep {
    private CreateProject createProject = new CreateProject();


    /**
     * Steps of Creating a Project.
     *
     * @param values for enter.
     */
    @Given("^I can create a new project with the following values$")
    public void iCanCreateANewProjectWithTheFollowingValues(final Map<ProjectValues, String> values) {
        final Map<ProjectValues, String> projects = values;
        createProject.setButtonCreateProject();
        projects.keySet().stream().forEach(step -> createProject.getStrategyStepMap(projects).get(step).execute());
        createProject.setButtonCreate();

    }

    /**
     * Verify taht is created the project.
     *
     * @param projectName name of project.
     */
    @Then("^I can verify the new project with \"([^\"]*)\" project name$")
    public void iCanVerifyTheNewProjectWithProjectName(final String projectName) {
        Assert.assertEquals(projectName, createProject.verifyName());
    }
}

