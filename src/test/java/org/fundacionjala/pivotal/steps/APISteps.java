package org.fundacionjala.pivotal.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.common.APIMethods;
import org.testng.Assert;
import java.util.Map;

/**
 * APISteps.java
 * Class with steps for test feature.
 */
public class APISteps {
    private APIMethods methods;

    /**
     * Given.
     * @param values received as maps.
     */
    @Given("^I post a new project$")
    public void iPostANewProject(final Map<String, String> values) {
        methods = new APIMethods();
        methods.postNewProject(values);
    }

    /**
     * Then.
     */
    @Then("^I get body of the answer$")
    public void iGetBodyOfTheAnswer() {
        final int expectedStatus = 200;
        Assert.assertEquals(methods.getStatusCode(), expectedStatus);
        methods.getResponseBody();
    }

    /**
     * Given.
     * @param values map.
     */
    @Given("^I delete a project$")
    public void iDeleteAProject(final Map<String, String> values) {
        methods = new APIMethods();
        methods.deleteProject();
    }

    /**
     * Then.
     * @param arg0 param.
     */
    @Then("^status code is (\\d+)$")
    public void statusCodeIs(int arg0) {
        final int expectedStatus = 204;
        Assert.assertEquals(methods.getStatusCode(), expectedStatus);
    }
}
