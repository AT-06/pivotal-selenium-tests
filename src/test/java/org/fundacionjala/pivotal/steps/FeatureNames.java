package org.fundacionjala.pivotal.steps;


/**
 * Class FeatureNames that save the name of the stories, projects.
 */
public class FeatureNames {

    private String projectName;
    private String storyName;


    /**
     * Method setProjectName to save the project name.
     * @param projectVariable string.
     */
    public void setProjectName(final String projectVariable) {
        this.projectName = projectVariable;
    }

    /**
     * Method getProjectName to get the project saved.
     * @return the project name.
     */
    public String getProjectName() {
        return projectName;
    }
    /**
     * Method setProjectName to save the story name.
     * @param storyName string.
     */
    public void setStoryName(final String storyName) {
        this.storyName = storyName;
    }

    /**
     * Method getProjectName to get the story saved.
     * @return the story name.
     */
    public String getStoryName() {
        return storyName;
    }
}
