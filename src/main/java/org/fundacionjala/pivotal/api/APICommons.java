package org.fundacionjala.pivotal.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.fundacionjala.pivotal.common.PropertiesConfig;

/**
 * APICommons.java
 * Class with common method to execute an API request.
 */
public final class APICommons {

    /**
     * Constructor.
     */
    private APICommons() {
    }

    /**
     * Method to get an element from the response.
     *
     * @param res the response from request.
     * @param element the element needed.
     * @return the body of response.
     */
    public static String getElementResponse(final Response res, final String element) {
        JsonPath jsonPathEvaluator = res.jsonPath();
        return jsonPathEvaluator.get(element).toString();
    }

    /**
     * Method to build request header.
     *
     * @return the request specification.
     */
    public static RequestSpecification
    buildRequestHeader() {
        return new RequestSpecBuilder()
                .setBaseUri("https://www.pivotaltracker.com/services/v5")
                .addHeader("X-TrackerToken", PropertiesConfig.getPropertiesConfig().getAPIToken())
                .build();
    }
}

