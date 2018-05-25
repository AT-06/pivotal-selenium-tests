package org.fundacionjala.pivotal.steps.api;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.fundacionjala.pivotal.core.api.APICommons;
import org.fundacionjala.pivotal.core.api.APIRequestManager;
import org.fundacionjala.pivotal.core.api.APIResponseName;
import org.testng.Assert;
import java.util.Map;

/**
 * APIProjectSteps.java
 * Class with steps for test feature.
 */
public class APIProjectSteps {
    private final APIResponseName date;


    public APIProjectSteps(final APIResponseName date) {
        this.date = date;
    }


    /**
     * And step to post a project.
     * @param feature the feature.
     * @param endpoint to send request.
     * @param values the map with values to create the project.
     */
    @And("^I post a new \"([^\"]*)\" to \"([^\"]*)\" endpoint$")
    public void iPostANewToEndpoint(String feature, String endpoint, final Map<String, String> values){
        //APICommons.setEndPoint(endpoint);
        String newEndpoint = APICommons.buildEndPoint(endpoint);
        System.out.println(newEndpoint);
        APIRequestManager.post(values, newEndpoint);
    }

    /**
     * Method to save response.
     *
     * @param variableName the key to save.
     */
    @And("^save the response as \"([^\"]*)\"$")
    public void saveTheResponseAs(final String variableName) {
       // date.setDate(date.generateDate());
       // System.out.println(date.getDate());
        APICommons.saveResponse(variableName, APIRequestManager.getResponse());
        //APICommons.buildEndPoint(APIRequestManager.getResponse());
    }
    /**
     * Then, when a post is made.
     */
    @Then("^I validate the status code (\\d+)$")
    public void iValidateTheStatusCode(int status) {
        final int expectedStatus = status;
        Assert.assertEquals(APIRequestManager.getStatusCode(), expectedStatus);
    }
}