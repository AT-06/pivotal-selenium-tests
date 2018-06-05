package org.fundacionjala.pivotal.steps.api;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.core.api.APICommons;
import org.fundacionjala.pivotal.core.api.APIRequestManager;
import org.fundacionjala.pivotal.util.Helper;
import org.testng.Assert;
import java.util.Map;


/**
 * APIProjectSteps.java
 * Class with steps for test feature.
 */
public class APIProjectSteps {

    private Helper proyName;

    /**
     * Constructor for ProjectSteps class.
     *
     * @param proyName object.
     */
    public APIProjectSteps(final Helper proyName) {
        this.proyName = proyName;
    }

    /**
     * And step to post a project.
     * @param feature the feature.
     * @param endpoint to send request.
     * @param values the map with values to create the project.
     */
    @And("^I post a new \"([^\"]*)\" to \"([^\"]*)\" endpoint$")
    public void iPostANewToEndpoint(final String feature, final String endpoint, final Map<String, String> values) {
        APIRequestManager.post(values, APICommons.buildEndPoint(endpoint));
        if (feature.compareTo("project") == 0) {
            proyName.setProjectName(values.get("name"));
            proyName.setAccountName(values.get("new_account_name"));
        }
        if (feature.compareTo("story") == 0) {
            proyName.setStoryName(values.get("name"));
        }
        if (feature.compareTo("workspace") == 0) {
            proyName.setWorkspaceName(values.get("name"));
        }
    }

    /**
     * Method to save response.
     *
     * @param variableName the key to save.
     */
    @And("^save the response as \"([^\"]*)\"$")
    public void saveTheResponseAs(final String variableName) {
        APICommons.saveResponse(variableName, APIRequestManager.getResponse());
    }
    /**
     * Then, when a post is made.
     * @param status is the response status.
     */
    @Then("^I validate the status code (\\d+)$")
    public void iValidateTheStatusCode(int status) {
        final int expectedStatus = status;
        Assert.assertEquals(APIRequestManager.getStatusCode(), expectedStatus);
    }

    /**
     * Then, when a post is made.
     * @param feature is the feature to test.
     * @param endpoint is the endpoint.
     * @param values is the data map.
     */
    @When("^I put a \"([^\"]*)\" to \"([^\"]*)\" endpoint$")
    public void iPutAToEndpoint(final String feature, final String endpoint, final Map<String, String> values) {
        APIRequestManager.put(values, APICommons.buildEndPoint(endpoint));
    }


    /**
     * Then, when a post is made.
     * @param feature is the feature to test.
     * @param endpoint is the endpoint.
     */
    @When("^I delete a \"([^\"]*)\" with \"([^\"]*)\" endpoint$")
    public void iDeleteAWithEndpoint(final String feature, final String endpoint) {
        APIRequestManager.delete(APICommons.buildEndPoint(endpoint));
    }
}
