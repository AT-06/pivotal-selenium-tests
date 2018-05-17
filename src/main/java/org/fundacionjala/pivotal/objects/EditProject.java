package org.fundacionjala.pivotal.objects;

import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.common.CommonMethods;
import org.fundacionjala.pivotal.common.Steps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.EnumMap;
import java.util.Map;

/**
 * Class for edit Project Page Objects.
 */
public class EditProject extends Base {

    //project_description
    @FindBy(how = How.ID, using = "project_description")
    private WebElement txtProjectDescription;

    //#project_enable_tasks
    @FindBy(how = How.CSS, using = "#project_enable_tasks")
    private WebElement txtTask;

    //#project_public
    @FindBy(how = How.CSS, using = "#project_public")
    private WebElement txtPublic;

    //#project_week_start_day
    @FindBy(how = How.CSS, using = "#project_week_start_day")
    private WebElement txtProjectWeek;

    //#settings_form  input.save_bar__submit
    @FindBy(how = How.CSS, using = "#settings_form  input.save_bar__submit")
    private WebElement saveEditProject;

    @FindBy(how = How.CSS, using = "#save_success_bar div.message")
    private WebElement messageSaved;

    @FindBy(how = How.CSS, using = "#project_start_date")
    private WebElement txtDateProject;

    /**
     * Method for set Date Project.
     *
     * @param date String.
     */
    private void setTxtDateProject(final String date) {
        CommonMethods.setWebElement(txtDateProject, date);
    }

    /**
     * Method for set txt Project week.
     *
     * @param day String.
     */
    private void setTxtProjectWeek(final String day) {
        CommonMethods.clickWebElementWithJavascriptExecutor(txtProjectWeek);
        CommonMethods.setWebElement(txtProjectWeek, day);
    }

    /**
     * Method for Message saved.
     *
     * @return messageSaved.
     */
    public String setMessageSaved() {
        CommonMethods.waitWebElement(messageSaved);
        return messageSaved.getText();
    }

    /**
     * Method for SAve edit Project.
     */
    public void setSaveEditProject() {
        CommonMethods.clickWebElement(saveEditProject);
    }

    /**
     * Method for txt Public.
     *
     * @param check String.
     */
    private void setTxtPublic(final String check) {
        if (check.equalsIgnoreCase("false")) {
            CommonMethods.clickWebElement(txtPublic);
        }
    }

    /**
     * Method for txt Project Description.
     *
     * @param description String.
     */
    private void setTxtProjectDescription(final String description) {
        CommonMethods.setWebElement(txtProjectDescription, description);
    }

    /**
     * Method for txt Task.
     *
     * @param check String.
     */
    private void setTxtTask(final String check) {
        if (check.equalsIgnoreCase("false")) {
            CommonMethods.clickWebElement(txtTask);
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
