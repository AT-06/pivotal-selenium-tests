package org.fundacionjala.pivotal.common;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.fundacionjala.pivotal.objects.CreateProject;

import java.util.Map;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.baseURI;

/**
 * APIMethods.java
 * Class that implements the methods to get, post, delete and put through Pivotal API.
 */
public class APIMethods {
    private Response response;

    /**
     * Constructor.
     */
    public APIMethods() {
        setBaseURI("https://www.pivotaltracker.com/services/v5");
    }

    /**
     * Method to post a request.
     * @param values map.
     */
    public void postNewProject(final Map<String, String> values) {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("X-TrackerToken", PropertiesConfig.getPropertiesConfig().getAPIToken())
                .build();
        response = given().spec(requestSpecification).params(values).when().post("/projects");
    }

    /**
     * Method to delete a request.
     */
    public void deleteProject() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("X-TrackerToken", PropertiesConfig.getPropertiesConfig().getAPIToken())
                .build();
        response = given().spec(requestSpecification).when().delete("/projects/" + CreateProject.newProjectId);

    }

    /**
     * Method to get status code.
     * @return status code.
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Method to get body of response.
     * @return the body of response.
     */
    public void getResponseBody() {
        JsonPath jsonPathEvaluator = response.jsonPath();
        CreateProject.setNewProjectId(jsonPathEvaluator.get("id").toString());
    }

    /**
     * Method to set URI.
     * @param uri string.
     */
    public static void setBaseURI(final String uri) {
        baseURI = uri;
    }
}
