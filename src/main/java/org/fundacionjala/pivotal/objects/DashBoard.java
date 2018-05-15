package org.fundacionjala.pivotal.objects;

import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.common.CommonMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Class to Dashboard for return of any page to Dashboard.
 */
public class DashBoard extends Base {

    @FindBy(how = How.CSS, using = "#elm-root  a.SettingsIcon__cog.projectTileHeader__hoverable")
    private WebElement buttonEditProject;

    @FindBy(how = How.ID, using = "projects-search-bar")
    private WebElement searchProjectButton;

    @FindBy(how = How.XPATH, using = "//*[contains(@href,'/dashboard')] ")
    private WebElement buttonDashborad;

    /**
     * Set Button DashBoard.
     */
    public void setButtonDashborad() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonDashborad);
        //CommonMethods.clickWebElement(buttonDashborad);
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
}
