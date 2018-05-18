package org.fundacionjala.pivotal.workspace;

import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.common.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditWorkspace extends Base {
    //project_description
    @FindBy(how = How.CSS, using = "div.WorkspaceTile:last-child .SettingsIcon__cog")
    private WebElement lastWorkspaceCreatedLink;


    @FindBy(how = How.ID, using = "workspace_name")
    private WebElement txtWorkspaceName;

    @FindBy(how = How.CSS, using = ".save_bar__submit")
    private WebElement buttonSaveWorkspace;

    @FindBy(how = How.ID, using = "save_success_bar")
    private WebElement successMessage;
   // delete_link


    /**
     * Method for get the last workspace created.
     * @return lastWorspaceCreatedLink.
     */
    public WebElement getLastWorkspaceCreatedLink() {
        return CommonMethods.waitWebElement(lastWorkspaceCreatedLink);

    }


    /**
     * Method for get the last workspace created.
     * @return the workspace name input.
     */
    private WebElement getTxtWorkspaceName() {
        return CommonMethods.waitWebElement(txtWorkspaceName);

    }

    /**
     * Method for get the last workspace created.
     * @return the workspace name input.
     */
    private WebElement getButtonSaveWorkspace() {
        return CommonMethods.waitWebElement(buttonSaveWorkspace);

    }
    /**
     * Method for get the last workspace created.
     * @return the workspace name input.
     */
    public WebElement getSuccessMessage() {
        return CommonMethods.waitWebElement(successMessage);

    }

    /**
     * Method for set Workspace name.
     * @param workspaceName String.
     */
    private void setWorkspaceName(final String workspaceName) {
        CommonMethods.setWebElement(getTxtWorkspaceName(), workspaceName);
    }

    /**
     * Method for press click over the last workspace created.
     */
    private void clickLastWorkspaceCreatedLink() {
        CommonMethods.clickWebElement(this.getLastWorkspaceCreatedLink());
    }



    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonSaveWorkspace() {
        CommonMethods.clickWebElement(this.getButtonSaveWorkspace());
    }

    /**
     * Method to Create workspace .
     * @param workspaceName String.
     */
    public final void editWorkspace(final String workspaceName) {

        CommonMethods.clickWebElementWithJavascriptExecutor(getLastWorkspaceCreatedLink());

        //   this.clickLastWorkspaceCreatedLink();
        this.setWorkspaceName(workspaceName);
        this.clickButtonSaveWorkspace();
    }

}
