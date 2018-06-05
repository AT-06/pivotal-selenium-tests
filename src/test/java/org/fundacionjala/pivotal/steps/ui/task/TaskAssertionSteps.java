package org.fundacionjala.pivotal.steps.ui.task;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.story.Story;
import org.fundacionjala.pivotal.pages.task.Task;
import org.fundacionjala.pivotal.util.Helper;
import org.testng.asserts.Assertion;

/**
 * Class that contains the assertion steps of Task feature.
 */

public class TaskAssertionSteps {
    private Story story;
    private Task task;
    private Assertion assertion;

    /**
     * Constructor for CreateTaskSteps class.
     *
     * @param story  object.
     * @param task   object.
     * @param helper object.
     */

    public TaskAssertionSteps(final Story story, final Task task, final Helper helper) {
        this.story = story;
        this.task = task;
        this.assertion = helper.getAssertion();
    }

    /**
     * Verify that the new task was created.
     *
     * @param taskName name of the task.
     */
    @Then("^I verify the new task \"([^\"]*)\" was created$")
    public void iVerifyTheNewTaskWasCreated(final String taskName) {
        story.clickSToryExpander();
        assertion.assertEquals(taskName, task.verifyTaskName());
        story.setButtonCloseEdit();
    }
}
