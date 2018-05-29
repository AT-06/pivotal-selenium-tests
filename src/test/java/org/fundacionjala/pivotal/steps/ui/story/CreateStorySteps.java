package org.fundacionjala.pivotal.steps.story;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.story.DescriptionsStory;
import org.fundacionjala.pivotal.pages.story.Story;
import org.fundacionjala.pivotal.steps.FeatureNames;
import org.testng.Assert;

import java.util.Map;

import static org.fundacionjala.pivotal.pages.story.DescriptionsStory.STORY_NAME;

/**
 * CreateStorySteps class that create a story.
 */
public class CreateStorySteps {
    private Story createStory;
    private FeatureNames feature;

    /**
     * Constructor for CreateStorySteps class.
     * @param createStory object.
     * @param feature object.
     */
    public CreateStorySteps(final Story createStory, final FeatureNames feature) {
        this.createStory = createStory;
        this.feature = feature;
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
        feature.setStoryName(values.get(STORY_NAME));
    }

    /**
     * Verify that the new story was created.
     */
    @Then("^I verify the new story was created$")
    public void iVerifyTheNewStoryWasCreated() {

        Assert.assertEquals(feature.getStoryName(), createStory.verifyStoryName());
    }

}
