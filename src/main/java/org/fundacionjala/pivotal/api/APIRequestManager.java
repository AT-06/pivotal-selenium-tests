package org.fundacionjala.pivotal.api;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

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
    private static RequestSpecification requestSpecificacion;

    /**
     * Method to post a request.
     * @param values map.
     * @param endpoint to request to.
     */
    public static void post(final Map<String, String> values, final String endpoint) {
        requestSpecificacion = APIManager.getInstance().getRequestSpecification();
        response = given()
                .spec(requestSpecificacion)
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
