package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.utils.CommonActions;
import org.fundacionjala.pivotal.pages.common.Base;
import org.fundacionjala.pivotal.pages.common.Steps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

/**
 * Class for edit Project Page Objects.
 */
public class EditProject extends Base {

    @FindBy(id = "project_description")
    private WebElement txtProjectDescription;

    @FindBy(css = "#project_enable_tasks")
    private WebElement txtTask;

    @FindBy(css = "#project_public")
    private WebElement txtPublic;

    @FindBy(css = "#project_week_start_day")
    private WebElement txtProjectWeek;

    @FindBy(css = "input.save_bar__submit")
    private WebElement saveEditProject;

    @FindBy(css = "#save_success_bar div.message")
    private WebElement messageSaved;

    @FindBy(css = "#project_start_date")
    private WebElement txtDateProject;

    @FindBy(css = "li.projectTile:last-child .projectTileHeader__projectName")
    private WebElement titleProject;

    /**
     * Method for get the last workspace created.
     *
     * @return title last project created.
     */
    public String getTitleProject() {
        return CommonActions.waitWebElement(titleProject).getText();
    }

    /**
     * Method for set Date Project.
     *
     * @param date String.
     */
    private void setTxtDateProject(final String date) {
        CommonActions.setWebElement(txtDateProject, date);
    }

    /**
     * Method for set txt Project week.
     *
     * @param day String.
     */
    private void setTxtProjectWeek(final String day) {
        CommonActions.clickWebElementWithJavascriptExecutor(txtProjectWeek);
        CommonActions.setWebElement(txtProjectWeek, day);
    }

    /**
     * Method for Message saved.
     *
     * @return messageSaved.
     */
    public String setMessageSaved() {
        CommonActions.waitWebElement(messageSaved);
        return messageSaved.getText();
    }

    /**
     * Method for SAve edit Project.
     */
    public void setSaveEditProject() {
        CommonActions.clickWebElement(saveEditProject);
    }

    /**
     * Method for txt Public.
     *
     * @param check String.
     */
    private void setTxtPublic(final String check) {
        if (check.equalsIgnoreCase("false")) {
            CommonActions.clickWebElement(txtPublic);
        }
    }

    /**
     * Method for txt Project Description.
     *
     * @param description String.
     */
    private void setTxtProjectDescription(final String description) {
        CommonActions.setWebElement(txtProjectDescription, description);
    }

    /**
     * Method for txt Task.
     *
     * @param check String.
     */
    private void setTxtTask(final String check) {
        if (check.equalsIgnoreCase("false")) {
            CommonActions.clickWebElement(txtTask);
        }
    }

    /**
     * Method for get Strategy Step Map.
     *
     * @param values Map<ProjectDescription, Object>.
     * @return strategyMap.
     */
    public Map<ProjectDescription, Steps> getStrategyStepMap(final Map<ProjectDescription, String> values) {
        final EnumMap<ProjectDescription, Steps> strategyMap = new EnumMap<>(ProjectDescription.class);
        strategyMap.put(ProjectDescription.DESCRIPTION, () ->
                this.setTxtProjectDescription(values.get(ProjectDescription.DESCRIPTION)));
        strategyMap.put(ProjectDescription.ENABLE_TASKS, () ->
                this.setTxtTask(values.get(ProjectDescription.ENABLE_TASKS)));
        strategyMap.put(ProjectDescription.PUBLIC_ACCESS, () ->
                this.setTxtPublic(values.get(ProjectDescription.PUBLIC_ACCESS)));
        strategyMap.put(ProjectDescription.START_ITERATION, () ->
                this.setTxtProjectWeek(values.get(ProjectDescription.START_ITERATION)));
        strategyMap.put(ProjectDescription.PROJECT_START_DATE, () ->
                this.setTxtDateProject(values.get(ProjectDescription.PROJECT_START_DATE)));

        return strategyMap;
    }
}
