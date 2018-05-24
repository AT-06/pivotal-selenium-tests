package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.core.e2e.CommonMethods;
import org.fundacionjala.pivotal.pages.common.Base;
import org.fundacionjala.pivotal.pages.common.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

import static org.fundacionjala.pivotal.core.e2e.CommonMethods.waitWebElement;


/**
 * Class for create a Project.
 */
public class CreateProject extends Base {

    @FindBy(id = "create-project-button")
    private WebElement buttonCreateProject;

    @FindBy(name = "project_name")
    private WebElement txtProjectName;

    @FindBy(xpath = "//div[@class='tc-account-selector__header']")
    private WebElement txtSelectorAcccountCheck;

    @FindBy(className = "raw_context_name")
    private WebElement txtVerifyName;

    @FindBy(xpath = "//*[@id=\"modal_area\"]/div/div[2]/div/form/footer/button[2]")
    private WebElement buttonCreate;

    @FindBy(css = "#modal_area  span.tc-account-selector__create-account-text")
    private WebElement buttonCreateAccount;

    @FindBy(css = "#modal_area  input.tc-account-creator__name")
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
     * @param values Map<ProjectDescription, Object>
     * @return strategyMap.
     */
    public final Map<ProjectDescription, Steps> getStrategyStepMap(final Map<ProjectDescription, String> values) {
        final EnumMap<ProjectDescription, Steps> strategyMap = new EnumMap<>(ProjectDescription.class);
        strategyMap.put(ProjectDescription.PROJECT_TITLE, () ->
                setTxtProjectName(values.get(ProjectDescription.PROJECT_TITLE)));
        strategyMap.put(ProjectDescription.PROJECT_ACCOUNT, ()
                -> setTxtSelectorAcccountSpecific(values.get(ProjectDescription.PROJECT_ACCOUNT)));
        strategyMap.put(ProjectDescription.PROJECT_VISIBLE, ()
                -> setPrivacy(values.get(ProjectDescription.PROJECT_VISIBLE)));
        return strategyMap;
    }

    /**
     * Method to extract new project's id from url.
     *
     * @return the project's id extracted from URL.
     */
    public String extractProjectIdFromUrl() {
        return this.driver.getCurrentUrl().substring(this.driver.getCurrentUrl().lastIndexOf("/") + 1);
    }
}
