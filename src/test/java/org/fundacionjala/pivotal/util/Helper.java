package org.fundacionjala.pivotal.util;

import org.testng.asserts.Assertion;

/**
 * Class Helper that save the name of the stories, projects.
 */
public class Helper {

    private String projectName;
    private String storyName;
    private String accountName;
    private String workspaceName;
    private Assertion assertion;

    /**
     * Class constructor.
     *
     * @param assertion object.
     */
    public Helper(final Assertion assertion) {
        this.assertion = assertion;

    }

    /**
     * Method setProjectName to save the project name.
     *
     * @param workspaceName string.
     */
    public void setWorkspaceName(final String workspaceName) {
        this.workspaceName = workspaceName;
    }

    /**
     * Method getProjectName to get the project saved.
     *
     * @return the project name.
     */
    public String getWorkspaceName() {
        return workspaceName;
    }

    /**
     * Method setProjectName to save the project name.
     *
     * @param accountName string.
     */
    public void setAccountName(final String accountName) {
        this.accountName = accountName;
    }

    /**
     * Method getProjectName to get the project saved.
     *
     * @return the project name.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Method setProjectName to save the project name.
     *
     * @param projectVariable string.
     */
    public void setProjectName(final String projectVariable) {
        this.projectName = projectVariable;
    }

    /**
     * Method getProjectName to get the project saved.
     *
     * @return the project name.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Method setProjectName to save the story name.
     *
     * @param storyName string.
     */
    public void setStoryName(final String storyName) {
        this.storyName = storyName;
    }

    /**
     * Method getProjectName to get the story saved.
     *
     * @return the story name.
     */
    public String getStoryName() {
        return storyName;
    }

    /**
     * Get Assertion.
     *
     * @return a instance of Assertion.
     */
    public Assertion getAssertion() {
        return assertion;
    }

    /**
     * Set assertion instance.
     *
     * @param assertion a instance of Soft Assertion.
     */
    public void setAssertion(final Assertion assertion) {
        this.assertion = assertion;
    }
}
