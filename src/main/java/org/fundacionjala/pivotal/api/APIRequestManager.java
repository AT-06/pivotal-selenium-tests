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
     * Response attribute to get request.
     */
    private static Response response;

    /**
     * Method to post a request.
     * @param values map.
     * @param endpoint to request to.
     */
    public static void post(final Map<String, String> values, final String endpoint) {
        response = given()
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
        response = given()
                .spec(APIManager.getInstance().getRequestSpecification())
                .when()
                .delete(endpoint);
    }

    /**
     * Method to post a request.
     * @param values map.
     * @param endpoint to request to.
     */
    public static void put(final Map<String, String> values, final String endpoint) {
        response = given()
                .spec(APIManager.getInstance().getRequestSpecification())
                .params(values)
                .when()
                .put(endpoint);
    }
    /**
     * Method to get a request.
     * @param endpoint string.
     * @return a response list.
     */
    public static Response get(final String endpoint) {
        return given()
                .spec(APIManager.getInstance().getRequestSpecification())
                .when()
                .get(endpoint);
    }

    /**
     * Method to get status code.
     * @return status code.
     */
    public static int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Method to get response from request.
     * @return the response.
     */
    public static Response getResponse() {
        return response;
    }
}
