package org.fundacionjala.pivotal.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import java.util.Map;
import static com.jayway.restassured.RestAssured.given;

/**
 * APIProjectsRequests.java
 * Class that implements the methods to get, post, delete and put through Pivotal API.
 */
public class APIProjectsRequests {

    private static String projectId = "0";
    private Response response;


    /**
     * Method to post a request.
     * @param values map.
     * @param endpoint to request to.
     */
    public void postNewProject(final Map<String, String> values, final String endpoint) {
        response = given()
                .spec(APICommons.buildRequestHeader())
                .params(values)
                .when()
                .post(endpoint);
    }

    /**
     * Method to delete a request.
     * @param endpoint to request to.
     */
    public void deleteProject(final String endpoint) {
        System.out.println("projectId:" + projectId);
        response = given()
                .spec(APICommons.buildRequestHeader())
                .when()
                .delete(String.format("%s%s", endpoint, projectId));
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
     */
    public void getResponseBody() {
        APIProjectsRequests.setProjectId(APICommons.getElementResponse(response, "id"));
    }

    /**
     * Method to set project id.
     * @param projectId from current project.
     */
    public static void setProjectId(final String projectId) {
        APIProjectsRequests.projectId = projectId;
    }

    /**
     * Method to set base URI.
     * @param uri to execute.
     */
    public static void setBaseUri(final String uri) {
        RestAssured.baseURI = uri;
    }

}
