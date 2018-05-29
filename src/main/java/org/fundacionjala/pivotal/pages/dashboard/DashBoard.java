package org.fundacionjala.pivotal.pages.dashboard;

import org.fundacionjala.pivotal.core.e2e.CommonMethods;
import org.fundacionjala.pivotal.pages.common.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to Dashboard for return of any page to Dashboard.
 */
public class DashBoard extends Base {

    @FindBy(css = "#elm-root  a.SettingsIcon__cog.projectTileHeader__hoverable")
    private WebElement buttonEditProject;

    @FindBy(id = "projects-search-bar")
    private WebElement searchProjectButton;

    @FindBy(xpath = "//*[contains(@href,'/dashboard')] ")
    private WebElement buttonDashborad;

    @FindBy(css = "li.projectTile:first-child a[data-aid='project-name']")
    private WebElement projectTitle;



    /**
     * Set Button DashBoard.
     */
    public void setButtonDashborad() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonDashborad);
    }
    /**
     * Set Button DashBoard.
     */
    public void setProjectTitle() {
        CommonMethods.clickWebElement(projectTitle);
    }

    /**
     * Set Button Edit Project.
     */
    private void setButtonEditProject() {
        CommonMethods.clickWebElement(buttonEditProject);
    }

    /**
     * Set Button for Search Project.
     *
     * @param nameProject String.
     */
    private void setSearchProjectButton(final String nameProject) {
        CommonMethods.setWebElement(searchProjectButton, nameProject);
    }

    /**
     * Set Project name for a search.
     *
     * @param projectName String.
     */
    public void searchProject(final String projectName) {
        this.setSearchProjectButton(projectName);
        this.setButtonEditProject();

    }
    /**
     * Set Project name for a search.
     *
     * @param projectName String.
     */
    public void searchOnlyProject(final String projectName) {
        this.setSearchProjectButton(projectName);

    }
}
