package org.fundacionjala.pivotal.hooks;

import com.jayway.restassured.response.Response;
import cucumber.api.java.After;

import org.fundacionjala.pivotal.core.api.APIRequestManager;
import org.fundacionjala.pivotal.core.api.APICommons;
import org.fundacionjala.pivotal.core.api.APIResponseName;

import java.util.Map;

/**
 * Hooks.java
 * Class that will have hooks for scenarios.
 */
public class Hooks {

    private final APIResponseName date;

    /**
     * Constructor.
     * @param date object utility instance.
     */
    public Hooks(final APIResponseName date) {
        this.date = date;
    }

    /**
     * After hook to delete the project created in tests.
     */
    @After("@PostConditionProject")
    public void afterCreatingProject() {
        Response resaux = APICommons.getRequestResponse().get(String.format("%s%s","Project" , date.getDate()));
      //  System.out.println(String.format("%s%s", "/projects/", APICommons.getElement(resaux, "id")));
        APIRequestManager.delete(String.format("%s%s", "/projects/", APICommons.getElement(resaux, "id")));


    }
}
