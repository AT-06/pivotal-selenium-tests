package org.fundacionjala.pivotal.steps.project;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.project.CreateProject;
import org.fundacionjala.pivotal.pages.project.ProjectDescription;
import org.fundacionjala.pivotal.steps.FeatureNames;
import org.testng.Assert;

import java.util.Map;

import static org.fundacionjala.pivotal.pages.project.ProjectDescription.PROJECT_TITLE;


/**
 * Class Project Steps for create a project.
 */
public class ProjectStep {
    private CreateProject createProject;
    private FeatureNames proyName;

    /**
     * Constructor for ProjectStep class.
     *
     * @param createProject object.
     */
    public ProjectStep(final CreateProject createProject, FeatureNames proyName) {
        this.createProject = createProject;
        this.proyName = proyName;
    }

    /**
     * Steps of Creating a Project.
     *
     * @param values for enter.
     */
    @Given("^I can create a new project with the following values$")
    public void iCanCreateANewProjectWithTheFollowingValues(final Map<ProjectDescription, String> values) {
        final Map<ProjectDescription, String> projects = values;
        createProject.setButtonCreateProject();
        projects.keySet().stream().forEach(step -> createProject.getStrategyStepMap(projects).get(step).execute());
        createProject.setButtonCreate();
        proyName.setProjectName(values.get(PROJECT_TITLE));
    }

    /**
     * Verify that is created the project.
     */
    @Then("^I can verify the new project with the project name$")
    public void iCanVerifyTheNewProjectWithProjectName() {
        Assert.assertEquals(proyName.getProjectName(), createProject.verifyName());
    }
}

