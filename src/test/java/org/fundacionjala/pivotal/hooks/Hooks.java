package org.fundacionjala.pivotal.hooks;


import com.jayway.restassured.path.json.JsonPath;
import cucumber.api.java.After;

import org.fundacionjala.pivotal.core.api.APIRequestManager;
import org.fundacionjala.pivotal.core.api.APICommons;
import org.fundacionjala.pivotal.steps.FeatureNames;

import java.util.List;
import java.util.Map;

/**
 * Hooks.java
 * Class that will have hooks for scenarios.
 */
public class Hooks {

    private final FeatureNames feature;

    /**
     * constructor.
     * @param feature object.
     */
    public Hooks(final FeatureNames feature) {
        this.feature = feature;
    }
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

    /**
     * After hook to delete the project created in tests.
     */
    @After("@DeleteProjectUI")
    public void deleteProjectUI() {
        JsonPath jsonPath = new JsonPath(APIRequestManager.get("/projects").asString());
        List<Map<String, Object>> projectsList = jsonPath.get();
        for (final Map<String, Object> map : projectsList) {
            if (map.get("name").equals(feature.getProjectName())) {
                APIRequestManager.delete(String.format("/projects/%s", map.get("id").toString()));
            }
        }
    }
}
