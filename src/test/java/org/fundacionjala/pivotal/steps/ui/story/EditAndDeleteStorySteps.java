package org.fundacionjala.pivotal.steps.ui.story;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.story.DescriptionsStory;
import org.fundacionjala.pivotal.pages.story.Story;
import org.fundacionjala.pivotal.steps.FeatureNames;
import org.testng.Assert;

import java.util.Map;

import static org.fundacionjala.pivotal.pages.story.DescriptionsStory.STORY_NAME;

/**
 * EditAndDeleteStorySteps class that edit and delete a story.
 */
public class EditAndDeleteStorySteps {
    private Story story;
    private FeatureNames feature;

    /**
     * Constructor for EditAndDeleteStorySteps class.
     * @param story object.
     * @param feature object.
     */
    public EditAndDeleteStorySteps(final Story story, final FeatureNames feature) {
        this.story = story;
        this.feature = feature;
    }

    /**
     * First step to delete a story.
     */
    @Given("^I delete the story$")
    public void iDeleteTheStory() {
        story.deleteStory();
    }

    /**
     * Verify that the story was deleted.
     */
    @Then("^I verify that the story was deleted$")
    public void iVerifyThatTheStoryWasDeleted() {
        Assert.assertTrue(story.deleteMessageIsDisplayed());
    }

    /**
     * First step to edit a story.
     *
     * @param values parameters to edit.
     */
    @When("^I edit the next parameters$")
    public void iEditTheNextParameters(final Map<DescriptionsStory, String> values) {
        story.clickSToryExpander();
        values.keySet().stream().forEach(step -> story.getStrategyStepMap(values).get(step).execute());
        story.setButtonCloseEdit();
        feature.setStoryName(values.get(STORY_NAME));
    }

    /**
     * Verify that the parameters were edited.
     */
    @Then("^I verify the parameters were edited$")
    public void iVerifyTheParametersOfWereEdited() {
        Assert.assertEquals(feature.getStoryName(), story.verifyStoryName());

    }


}
