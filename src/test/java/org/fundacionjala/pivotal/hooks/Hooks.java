package org.fundacionjala.pivotal.hooks;


import cucumber.api.java.After;

import org.fundacionjala.pivotal.core.api.APIRequestManager;
import org.fundacionjala.pivotal.core.api.APICommons;

/**
 * Hooks.java
 * Class that will have hooks for scenarios.
 */
public class Hooks {

    /**
     * After hook to delete the project created in tests.
     */
    @After("@DeleteProject")
    public void deleteProject() {
        APIRequestManager.delete(APICommons.buildEndPoint("/projects/[Project.id]"));
    }

    /**
     * After hook to delete the project created in tests.
     */
    @After("@DeleteStory")
    public void deleteStory() {
        APIRequestManager.delete(APICommons.buildEndPoint("/projects/[Project.id]/stories/[Story.id]"));
    }


    /**
     * After hook to delete the project created in tests.
     */
    @After("@deleteWorkspace")
    public void deleteWorkspace() {
        APIRequestManager.delete(APICommons.buildEndPoint("/my/workspaces/[Workspace.id]"));
    }
}
