package org.fundacionjala.pivotal.steps.ui.task;

import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.story.Story;
import org.fundacionjala.pivotal.pages.task.DescriptionsTask;
import org.fundacionjala.pivotal.pages.task.Task;

import java.util.Map;

/**
 * EditAndDeleteTaskSteps class that edit and delete a task.
 */
public class EditAndDeleteTaskSteps {
    private Story story;
    private Task task;

    /**
     * Constructor method.
     *
     * @param story object.
     * @param task  object.
     */
    public EditAndDeleteTaskSteps(final Story story, final Task task) {
        this.story = story;
        this.task = task;
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
        values.keySet().stream().forEach(step -> task.getStrategyStepMap(values).get(step).execute());
        task.setSaveTaskButton();
        story.setButtonCloseEdit();
    }
}
