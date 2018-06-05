package org.fundacionjala.pivotal.hooks;


import com.jayway.restassured.path.json.JsonPath;
import cucumber.api.java.After;

import cucumber.api.java.Before;
import org.fundacionjala.pivotal.core.api.APIRequestManager;
import org.fundacionjala.pivotal.core.api.APICommons;
import org.fundacionjala.pivotal.pages.account.Account;
import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.fundacionjala.pivotal.util.Helper;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

/**
 * Hooks.java
 * Class that will have hooks for scenarios.
 */
public class Hooks {

    private final Helper feature;
    private final DashBoard dashboard;
    private final Account account;
    private Helper helper;

    /**
     * constructor.
     *
     * @param feature   object.
     * @param dashboard object.
     * @param account   object.
     * @param helper    object.
     */
    public Hooks(final Helper feature, final DashBoard dashboard, final Account account, final Helper helper) {
        this.feature = feature;
        this.dashboard = dashboard;
        this.account = account;
        this.helper = helper;
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

    /**
     * After hook to delete the project created in tests.
     */
    @After("@DeleteAccount")
    public void deleteAccount() {
        dashboard.setButtonDashborad();
        account.goToAccounts();
        account.delete();

    }


    /**
     * After hook to delete the project created in tests.
     */
    @After("@DeleteWorkspaceUI")
    public void deleteWorkspaceUI() {
        JsonPath jsonPath = new JsonPath(APIRequestManager.get("/my/workspaces").asString());
        List<Map<String, Object>> projectsList = jsonPath.get();
        for (final Map<String, Object> map : projectsList) {
            if (map.get("name").equals(feature.getWorkspaceName())) {
                APIRequestManager.delete(String.format("/my/workspaces/%s", map.get("id").toString()));
            }
        }

    }

    /**
     * Set a instance of Soft Assert to helper.
     */
    @Before("@SoftAssert")
    public void setSoftAssertion() {
        helper.setAssertion(new SoftAssert());
    }

    /**
     * Set to hard Assertion.
     */
    @Before
    public void setHardAssertion() {
        helper.setAssertion(new Assertion());
    }
}
