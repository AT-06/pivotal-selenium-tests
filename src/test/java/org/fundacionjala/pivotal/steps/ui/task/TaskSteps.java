package org.fundacionjala.pivotal.steps.ui.task;

import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.story.Story;
import org.fundacionjala.pivotal.pages.task.DescriptionsTask;
import org.fundacionjala.pivotal.pages.task.Task;

import java.util.Map;

/**
 * TaskSteps class that create a task.
 */
public class TaskSteps {
    private Story story;
    private Task task;

    /**
     * Constructor for TaskSteps class.
     *
     * @param story object.
     * @param task  object.
     */

    public TaskSteps(final Story story, final Task task) {
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
        values.keySet().forEach(step -> task.getStrategyStepMap(values).get(step).execute());
        task.setAddTaskButton();
        story.setButtonCloseEdit();
    }

    /**
     * First step to edit a task.
     *
     * @param values parameters to edit.
     */
    @When("^I edit the task content$")
    public void iEditTheTaskContent(final Map<DescriptionsTask, String> values) {
        story.clickSToryExpander();
        task.clickOnTaskCreated();
        task.clickOnTaskTextArea();
        values.keySet().forEach(step -> task.getStrategyStepMap(values).get(step).execute());
        task.setSaveTaskButton();
        story.setButtonCloseEdit();
    }
}
