package org.fundacionjala.pivotal.steps.ui.task;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.story.Story;
import org.fundacionjala.pivotal.pages.task.DescriptionsTask;
import org.fundacionjala.pivotal.pages.task.Task;
import org.testng.Assert;

import java.util.Map;

/**
 * CreateTaskSteps class that create a task.
 */
public class CreateTaskSteps {
    private Story story;
    private Task task;

    /**
     * Constructor for CreateTaskSteps class.
     *
     * @param story object.
     * @param task  object.
     */

    public CreateTaskSteps(final Story story, final Task task) {
        this.story = story;
        this.task = task;
    }

    /**
     * First step to create a task.
     *
     * @param values parameters to create a task.
     */
    @When("^I create a new task$")
    public void iCreateANewTask(final Map<DescriptionsTask, String> values) {
        story.clickSToryExpander();
        task.clickAddTask();
        values.keySet().stream().forEach(step -> task.getStrategyStepMap(values).get(step).execute());
        task.setAddTaskButton();
        story.setButtonCloseEdit();
    }

    /**
     * Verify that the new task was created.
     *
     * @param taskName name of the task.
     */
    @Then("^I verify the new task \"([^\"]*)\" was created$")
    public void iVerifyTheNewTaskWasCreated(final String taskName) {
        story.clickSToryExpander();
        Assert.assertEquals(taskName, task.verifyTaskName());
        story.setButtonCloseEdit();
    }
}