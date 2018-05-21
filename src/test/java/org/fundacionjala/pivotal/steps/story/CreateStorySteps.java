package org.fundacionjala.pivotal.steps.story;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.objects.story.Story;
import org.fundacionjala.pivotal.objects.story.DescriptionsStory;
import org.testng.Assert;

import java.util.Map;

/**
 * CreateStorySteps class that create a story.
 */
public class CreateStorySteps {
    private Story createStory;

    /**
     * Constructor for CreateStorySteps class.
     *
     * @param createStory object.
     */
    public CreateStorySteps(final Story createStory) {
        this.createStory = createStory;
    }

    /**
     * First step to create a story.
     *
     * @param values parameters to create a story.
     */
    @When("^I create a new story$")
    public void iCreateANewStory(final Map<DescriptionsStory, String> values) {
        createStory.setButtonCreateStory();
        values.keySet().stream().forEach(step -> createStory.getStrategyStepMap(values).get(step).execute());
        createStory.setButtonSaveStory();
    }

    /**
     * Verify that the new story was created.
     *
     * @param nameStory name of the story.
     */
    @Then("^I verify the new story \"([^\"]*)\" was created$")
    public void iVerifyTheNewStoryWasCreated(final String nameStory) {
        Assert.assertEquals(nameStory, createStory.verifyStoryName());
    }

}
