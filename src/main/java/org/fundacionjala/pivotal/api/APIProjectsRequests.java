package org.fundacionjala.pivotal.api;

import com.jayway.restassured.response.Response;
import java.util.Map;
import static com.jayway.restassured.RestAssured.given;

/**
 * APIProjectsRequests.java
 * Class that implements the methods to get, post, delete and put through Pivotal API.
 */
public final class APIProjectsRequests {
    /**
     * Constructor.
     */
    private APIProjectsRequests() {
    }

    /**
     * static attribute to manage project's id through processes.
     */
    private static String projectId = "0";

    /**
     * Response attribute to get request.
     */
    private static Response response;

    /**
     * Method to post a request.
     * @param values map.
     * @param endpoint to request to.
     */
    public static void postNewProject(final Map<String, String> values, final String endpoint) {
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
    public static void deleteProject(final String endpoint) {
        response = given()
                .spec(APICommons.buildRequestHeader())
                .when()
                .delete(String.format("%s%s", endpoint, projectId));
    }

    /**
     * Method to get status code.
     * @return status code.
     */
    public static int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Method to get body of response.
     */
    public static void getResponseBody() {
        APIProjectsRequests.setProjectId(APICommons.getElementResponse(response, "id"));
    }

    /**
     * Method to set project id.
     * @param projectId from current project.
     */
    public static void setProjectId(final String projectId) {
        APIProjectsRequests.projectId = projectId;
    }
}
