package org.fundacionjala.pivotal.steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.Map;
import static com.jayway.restassured.RestAssured.given;

/**
 * TestSteps.java
 * Class with steps for test feature.
 */
public class TestSteps {
    private Response response;

    /**
     * Given.
     * @param values received as maps.
     */
    @Given("^I post a new project$")
    public void iPostANewProject(final Map<String, String> values) {
        RestAssured.baseURI = "https://www.pivotaltracker.com/services/v5";
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("X-TrackerToken", "258466c57f75a05782ac59d33b50c9fa")
                .build();
        response = given().spec(requestSpecification).params(values).when().post("/projects");
    }

    /**
     * Then.
     */
    @Then("^I get body of the answer$")
    public void iGetBodyOfTheAnswer() {
        System.out.println(String.format("%s %s", "Body: ", response.asString()));

    }

}
