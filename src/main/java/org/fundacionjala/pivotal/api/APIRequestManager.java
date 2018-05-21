package org.fundacionjala.pivotal.api;

import com.jayway.restassured.response.Response;
import java.util.Map;
import static com.jayway.restassured.RestAssured.given;

/**
 * APIRequestManager.java
 * Class that implements the methods to get, post, delete and put through Pivotal API.
 */
public final class APIRequestManager {
    /**
     * Constructor.
     */
    private APIRequestManager() {
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
    public static void post(final Map<String, String> values, final String endpoint) {
        APIRequestManager.response = given()
                .spec(APIManager.getInstance().getRequestSpecification())
                .params(values)
                .when()
                .post(endpoint);
    }

    /**
     * Method to delete a request.
     * @param endpoint to request to.
     */
    public static void delete(final String endpoint) {
        APIRequestManager.response = given()
                .spec(APIManager.getInstance().getRequestSpecification())
                .when()
                .delete(endpoint);
    }

    /**
     * Method to get status code.
     * @return status code.
     */
    public static int getStatusCode() {
        return APIRequestManager.response.getStatusCode();
    }

    /**
     * Method to set project id.
     * @param projectId from current project.
     */
    public static void setProjectId(final String projectId) {
        APIRequestManager.projectId = projectId;
    }

    public static Response getResponse() {
        return APIRequestManager.response;
    }
}
