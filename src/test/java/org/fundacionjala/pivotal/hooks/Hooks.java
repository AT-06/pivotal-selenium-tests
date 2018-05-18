package org.fundacionjala.pivotal.hooks;

import cucumber.api.java.After;
import org.fundacionjala.pivotal.api.APIRequestManager;

import static org.fundacionjala.pivotal.steps.api.APIProjectSteps.PROJECT_ENDPOINT;

/**
 * Hooks.java
 * Class that will have hooks for scenarios.
 */
public class Hooks {

    /**
     * After hook to delete the project created in tests.
     */
    @After("@PostConditionProject")
    public void afterCreatingProject() {
        APIRequestManager.delete(PROJECT_ENDPOINT);
    }
}
