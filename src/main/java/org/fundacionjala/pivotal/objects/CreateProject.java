package org.fundacionjala.pivotal.objects;

import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.common.CommonMethods;
import org.fundacionjala.pivotal.common.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.pivotal.common.CommonMethods.waitWebElement;


/**
 * Class for create a Project.
 */
public class CreateProject extends Base {

    @FindBy(how = How.ID, using = "create-project-button")
    private WebElement buttonCreateProject;

    @FindBy(how = How.NAME, using = "project_name")
    private WebElement txtProjectName;

    @FindBy(how = How.XPATH, using = "//div[@class='tc-account-selector__header']")
    private WebElement txtSelectorAcccountCheck;

    ////td[text()='UserID']            @FindBy(how = How.CSS, using = "#view42 span.raw_context_name")
    @FindBy(how = How.CLASS_NAME, using = "raw_context_name")
    private WebElement txtVerifyName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modal_area\"]/div/div[2]/div/form/footer/button[2]")
    private WebElement buttonCreate;

    @FindBy(how = How.CSS, using = "#modal_area  span.tc-account-selector__create-account-text")
    private WebElement buttonCreateAccount;

    @FindBy(how = How.CSS, using = "#modal_area  input.tc-account-creator__name")
    private WebElement txtAccountName;

    /**
     * Method for verifyName.
     *
     * @return txtVerifyName.
     */
    public String verifyName() {
        waitWebElement(txtVerifyName);
        return txtVerifyName.getText();
    }

    /**
     * Method for set Privacy.
     *
     * @param privacy String.
     */
    private void setPrivacy(final String privacy) {
        if ("private".equalsIgnoreCase(privacy)) {
            driver.findElement(By.cssSelector(
                    "div#modal_area label:nth-child(2) > input[name=\"project_type\"]")).click();
        }
        if ("public".equalsIgnoreCase(privacy)) {
            driver.findElement(By.cssSelector(
                    "div#modal_area label:nth-child(3) > input[name=\"project_type\"]")).click();
        }
    }

    /**
     * Method for set Select an Account Specific.
     *
     * @param account String.
     */
    private void setTxtSelectorAcccountSpecific(final String account) {
        this.setTxtSelectorAcccountCheck();

        //these last comands permit to create a new Account from create project menu
        CommonMethods.clickWebElement(buttonCreateAccount);
        CommonMethods.setWebElement(txtAccountName, account);
    }

    /**
     * Method for Select Account Check.
     */
    private void setTxtSelectorAcccountCheck() {
        CommonMethods.clickWebElement(txtSelectorAcccountCheck);
    }

    /**
     * Method for set Button Create Project.
     */
    public void setButtonCreateProject() {
        CommonMethods.clickWebElement(buttonCreateProject);
    }

    /**
     * Method for set Project name.
     *
     * @param projectName String.
     */
    private void setTxtProjectName(final String projectName) {
        CommonMethods.setWebElement(txtProjectName, projectName);

    }

    /**
     * Method for set Button Create.
     */
    public void setButtonCreate() {
        CommonMethods.clickWebElement(buttonCreate);
    }

    /**
     * Method for Strategy Step Map.
     *
     * @param values Map<ProjectValues, Object>
     * @return strategyMap.
     */
    public final Map<ProjectValues, Steps> getStrategyStepMap(final Map<ProjectValues, String> values) {
        final Map<ProjectValues, Steps> strategyMap = new HashMap<>();
        strategyMap.put(ProjectValues.PROJECT_TITLE, () ->
                setTxtProjectName(values.get(ProjectValues.PROJECT_TITLE)));
        strategyMap.put(ProjectValues.PROJECT_ACCOUNT, ()
                -> setTxtSelectorAcccountSpecific(values.get(ProjectValues.PROJECT_ACCOUNT)));
        strategyMap.put(ProjectValues.PROJECT_VISIBLE, ()
                -> setPrivacy(values.get(ProjectValues.PROJECT_VISIBLE)));
        return strategyMap;
    }

}
