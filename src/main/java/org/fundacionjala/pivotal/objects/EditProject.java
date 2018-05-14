package org.fundacionjala.pivotal.objects;

import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.common.CommonMethods;
import org.fundacionjala.pivotal.common.Meth;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.HashMap;
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
     * @param date String.
     */
    private void setTxtDateProject(final String date) {
        CommonMethods.setWebElement(txtDateProject, date);
    }

    /**
     * Method for set txt Project week.
     * @param day String.
     */
    private void setTxtProjectWeek(final String day) {
        CommonMethods.clickWebElement(txtProjectWeek);
        CommonMethods.setWebElement(txtProjectWeek, day);
    }

    /**
     * Method for Message saved.
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
     * @param check String.
     */
    private void setTxtPublic(final String check) {
        if (check.equalsIgnoreCase("false")) {
            CommonMethods.clickWebElement(txtPublic);
        }
    }

    /**
     *
     * Method for txt Project Description.
     * @param description String.
     */
    private void setTxtProjectDescription(final String description) {
        CommonMethods.setWebElement(txtProjectDescription, description);
    }

    /**
     * Method for txt Task.
     * @param check String.
     */
    private void setTxtTask(final String check) {
        if (check.equalsIgnoreCase("false")) {
            CommonMethods.clickWebElement(txtTask);
        }
    }

    /**
     * Method for get Strategy Step Map.
     * @param values Map<DescriptionValues, Object>.
     * @return strategyMap.
     */
    public Map<DescriptionValues, Meth> getStrategyStepMap(final Map<DescriptionValues, Object> values) {
        Map<DescriptionValues, Meth> strategyMap = new HashMap<>();
        strategyMap.put(DescriptionValues.DESCRIPTION, () ->
                this.setTxtProjectDescription(String.valueOf(values.get(DescriptionValues.DESCRIPTION))));
        strategyMap.put(DescriptionValues.ENABLE_TASKS, () ->
                this.setTxtTask(String.valueOf(values.get(DescriptionValues.ENABLE_TASKS))));
        strategyMap.put(DescriptionValues.PUBLIC_ACCESS, () ->
                this.setTxtPublic((String.valueOf(values.get(DescriptionValues.PUBLIC_ACCESS)))));
        strategyMap.put(DescriptionValues.START_ITERATION, () ->
                this.setTxtProjectWeek(String.valueOf(values.get(DescriptionValues.START_ITERATION))));
        strategyMap.put(DescriptionValues.PROJECT_START_DATE, () ->
                this.setTxtDateProject(String.valueOf(values.get(DescriptionValues.PROJECT_START_DATE))));

        return strategyMap;
    }

}
