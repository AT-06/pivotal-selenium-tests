package org.fundacionjala.pivotal.api;

import com.jayway.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * APICommons.java
 * Class with common method to execute an API request.
 */
public final class APICommons {
    private static Map<String, Response> requestResponse;
    private static String endPoint;

    /**
     * Constructor.
     */
    private APICommons() {
    }

    /**
     * Method to get an element from the response.
     *
     * @param mapSaved the response from request.
     * @param element the element needed.
     * @return the body of response.
     */
    public static String getElementResponse(final Map<String, Response> mapSaved, final String element) {
        String[] elementSplit = element.split("\\.");
        Response res = mapSaved.get(elementSplit[0]);
        return getElement(res, elementSplit[1]);
    }

    /**
     * Method to get an element from a response.
     * @param res the response from request.
     * @param element the element needed from response
     * @return the element value as string.
     */
    public static String getElement(final Response res, final String element) {
        return res.jsonPath().get(element).toString();
    }

    /**
     * Method to save response from request into a hashmap.
     * @param variableName the key name of the response.
     * @param response the response from request.
     */
    public static void saveResponse(final String variableName, final Response response) {
        requestResponse = new HashMap<>();
        requestResponse.put(variableName, response);
    }

    /**
     * Method to get map with response.
     * @return the map.
     */
    public static Map getRequestResponse() {
        return requestResponse;
    }

    /**
     * Method to build endpoint.
     * @param res the response to a request.
     */
    public static void buildEndPoint(final Response res) {
        endPoint = String.format("%s%s%s", endPoint, "/", getElement(res, "id"));
    }

    /**
     * Method to set end point.
     * @param end the endpoint.
     */
    public static void setEndPoint(final String end) {
        endPoint = end;
    }

    /**
     * Method to get endpoint.
     * @return the endpoint.
     */
    public static String getEndPoint() {
        return endPoint;
    }
}

