package org.fundacionjala.pivotal.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;
import org.fundacionjala.pivotal.util.PropertiesPivotal;

/**
 * APIManager.java
 * Class that applies Singleton pattern to build and get request specification for API requests.
 */
public final class APIManager {
    private static APIManager apiManager;
    private RequestSpecification requestSpecification;

    /**
     * Constructor, it is private, because we only need one instance of the class.
     */
    private APIManager() {
        init();
    }

    /**
     * Method to build requestSpecification.
     */
    private void init() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://www.pivotaltracker.com/services/v5")
                .addHeader("X-TrackerToken", PropertiesPivotal.getInstance().getAPIToken())
                .build();
    }

    /**
     * Method to get instance of the class.
     *
     * @return the instance.
     */
    public static APIManager getInstance() {
        if (apiManager == null) {
            apiManager = new APIManager();
        }
        return apiManager;
    }

    /**
     * Method to get request specification.
     *
     * @return requestSpecification.
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
