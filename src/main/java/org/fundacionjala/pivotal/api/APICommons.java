package org.fundacionjala.pivotal.api;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * APICommons.java
 * Class with common method to execute an API request.
 */
public final class APICommons {
    private static Map<String, Response> requestResponse;

    /**
     * Constructor.
     */
    private APICommons() {
    }

    /**
     * Method to get an element from the response.
     *
     * @param mapSaved     the response from request.
     * @param element the element needed.
     * @return the body of response.
     */
    public static String getElementResponse(final Map<String, Response> mapSaved, String element) {
        String[] elementSplited = element.split("\\.");
        Response responseSaved = mapSaved.get(elementSplited[0]);
        JsonPath jsonPathEvaluator = responseSaved.jsonPath();
        return jsonPathEvaluator.get(elementSplited[1]).toString();
    }

    public static void saveResponse(String variableName, Response response) {
        requestResponse = new HashMap<>();
        requestResponse.put(variableName, response);
    }

    public static Map getRequestResponse() {
        System.out.println("2");
        return requestResponse;
    }
}

