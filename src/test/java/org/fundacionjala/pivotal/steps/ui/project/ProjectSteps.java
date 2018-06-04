package org.fundacionjala.pivotal.steps.ui.project;

import cucumber.api.java.en.Given;
import org.fundacionjala.pivotal.pages.project.CreateProject;
import org.fundacionjala.pivotal.pages.project.ProjectDescription;
import org.fundacionjala.pivotal.steps.FeatureNames;

import java.util.Map;

import static org.fundacionjala.pivotal.pages.project.ProjectDescription.PROJECT_TITLE;


/**
 * Class Project Steps for create a project.
 */
public class ProjectSteps {
    private CreateProject createProject;
    private FeatureNames proyName;

    /**
     * Constructor for ProjectSteps class.
     *
     * @param createProject object.
     * @param proyName      object.
     */
    public ProjectSteps(final CreateProject createProject, final FeatureNames proyName) {
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
}

