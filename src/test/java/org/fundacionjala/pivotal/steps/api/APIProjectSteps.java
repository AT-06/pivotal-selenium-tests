package org.fundacionjala.pivotal.steps.api;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.api.APICommons;
import org.fundacionjala.pivotal.api.APIRequestManager;
import org.testng.Assert;
import java.util.Map;

/**
 * APIProjectSteps.java
 * Class with steps for test feature.
 */
public class APIProjectSteps {

    /**
     * And step to post a project.
     *
     * @param endpoint to send request.
     * @param values the map with values to create the project.
     */
    @And("^I post a new project to \"([^\"]*)\" endpoint$")
    public void iPostANewProjectToEndpoint(final String endpoint, final Map<String, String> values) {
        APICommons.setEndPoint(endpoint);
        APIRequestManager.post(values, endpoint);
    }

    /**
     * Method to save response.
     *
     * @param variableName the key to save.
     */
    @And("^save the response as \"([^\"]*)\"$")
    public void saveTheResponseAs(final String variableName) {
        APICommons.saveResponse(variableName, APIRequestManager.getResponse());
        //APICommons.buildEndPoint(APIRequestManager.getResponse());
    }

    /**
     * Then, when a post is made.
     */
    @Then("^I validate the status code$")
    public void iValidateTheStatusCode() {
        final int expectedStatus = 200;
        Assert.assertEquals(APIRequestManager.getStatusCode(), expectedStatus);
    }

    /**
     * Then.
     * @param arg0 param.
     */
    @Then("^status code is (\\d+)$")
    public void statusCodeIs(int arg0) {
        final int expectedStatus = 204;
        Assert.assertEquals(APIRequestManager.getStatusCode(), expectedStatus);
    }

    @When("^I post a new story to \"([^\"]*)\"$")
    public void iPostANewStoryTo(final String endpoint, final Map<String, String> values)  {

        String newEndpoint = APICommons.buildEndPoint(endpoint);//APIRequestManager.getResponse());
        //APICommons.setEndPoint(newEndpoint);
        APIRequestManager.post(values, newEndpoint);
    }
}
