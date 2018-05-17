package org.fundacionjala.pivotal.steps.api;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.api.APIProjectsRequests;
import org.testng.Assert;
import java.util.Map;

/**
 * APIProjectSteps.java
 * Class with steps for test feature.
 */
public class APIProjectSteps {
    public static final String PROJECT_ENDPOINT = "/projects/";

    /**
     * Given.
     * @param values received as maps.
     */
    @Given("^I post a new project$")
    public void iPostANewProject(final Map<String, String> values) {
        APIProjectsRequests.postNewProject(values, PROJECT_ENDPOINT);
    }

    /**
     * Then, when a post is made.
     */
    @Then("^I get body of the answer$")
    public void iGetBodyOfTheAnswer() {
        final int expectedStatus = 200;
        Assert.assertEquals(APIProjectsRequests.getStatusCode(), expectedStatus);
        APIProjectsRequests.getResponseBody();
    }

    /**
     * Given.
     * @param values map.
     */
    @Given("^I delete a project$")
    public void iDeleteAProject(final Map<String, String> values) {
        APIProjectsRequests.deleteProject(PROJECT_ENDPOINT);
    }

    /**
     * Then.
     * @param arg0 param.
     */
    @Then("^status code is (\\d+)$")
    public void statusCodeIs(int arg0) {
        final int expectedStatus = 204;
        Assert.assertEquals(APIProjectsRequests.getStatusCode(), expectedStatus);
    }
}
