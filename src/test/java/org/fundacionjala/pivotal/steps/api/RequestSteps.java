package org.fundacionjala.pivotal.steps.api;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import org.fundacionjala.pivotal.api.APICommons;
import org.fundacionjala.pivotal.api.APIRequestManager;
import org.fundacionjala.pivotal.util.Helper;


/**
 * RequestSteps.java
 * Class with steps for test feature.
 */
public class RequestSteps {

    private Helper helper;

    /**
     * Constructor for ProjectSteps class.
     *
     * @param helper object.
     */
    public RequestSteps(final Helper helper) {
        this.helper = helper;
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
        setHelperValues(feature, values);
    }

    /**
     * This need to be improved.
     *
     * @param feature object.
     * @param values object.
     */
    private void setHelperValues(final String feature, final Map<String, String> values) {
        if (feature.compareTo("project") == 0) {
            helper.setProjectName(values.get("name"));
            helper.setAccountName(values.get("new_account_name"));
        }
        if (feature.compareTo("story") == 0) {
            helper.setStoryName(values.get("name"));
        }
        if (feature.compareTo("workspace") == 0) {
            helper.setWorkspaceName(values.get("name"));
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
        Assert.assertEquals(APIRequestManager.getStatusCode(), status);
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
