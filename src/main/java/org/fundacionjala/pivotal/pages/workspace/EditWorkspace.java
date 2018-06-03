package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.utils.CommonActions;
import org.fundacionjala.pivotal.pages.common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class editworkspace contains methods to edit a workspace.
 */
public class EditWorkspace extends Base {

    @FindBy(css = "div.WorkspaceTile:last-child .SettingsIcon__cog")
    private WebElement lastWorkspaceCreatedLink;


    @FindBy(id = "workspace_name")
    private WebElement txtWorkspaceName;

    @FindBy(css = ".save_bar__submit")
    private WebElement buttonSaveWorkspace;

    @FindBy(id = "save_success_bar")
    private WebElement successMessage;

    @FindBy(id = "delete_link")
    private WebElement buttonDeleteWorkspace;

    @FindBy(id = "confirm_delete")
    private WebElement buttonConfirmDeleteWorkspace;

    @FindBy(id = "notice")
    private WebElement successDeleteMessage;



    /**
     * Method for get the last workspace created.
     *
     * @return lastWorspaceCreatedLink.
     */
    public WebElement getLastWorkspaceCreatedLink() {
        return CommonActions.waitWebElement(lastWorkspaceCreatedLink);

    }

    /**
     * Method for get the last workspace created.
     *
     * @return lastWorspaceCreatedLink.
     */
    public WebElement getSuccessDeleteMessage() {
        return CommonActions.waitWebElement(successDeleteMessage);

    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getTxtWorkspaceName() {
        return CommonActions.waitWebElement(txtWorkspaceName);

    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getButtonSaveWorkspace() {
        return CommonActions.waitWebElement(buttonSaveWorkspace);
    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getButtonDeleteWorkspace() {
        return CommonActions.waitWebElement(buttonDeleteWorkspace);
    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getButtonConfirmDeleteWorkspace() {
        return CommonActions.waitWebElement(buttonConfirmDeleteWorkspace);
    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    public WebElement getSuccessMessage() {
        return CommonActions.waitWebElement(successMessage);
    }

    /**
     * Method for set Workspace name.
     *
     * @param workspaceName String.
     */
    private void setWorkspaceName(final String workspaceName) {
        CommonActions.setWebElement(getTxtWorkspaceName(), workspaceName);
    }

    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonSaveWorkspace() {
        CommonActions.clickWebElement(this.getButtonSaveWorkspace());
    }

    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonDeleteWorkspace() {
        CommonActions.clickWebElement(this.getButtonDeleteWorkspace());
    }

    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonConfirmDeleteWorkspace() {
        CommonActions.clickWebElement(this.getButtonConfirmDeleteWorkspace());
    }

    /**
     * Method to Create workspace .
     *
     * @param workspaceName String.
     */
    public void editWorkspace(final String workspaceName) {

        CommonActions.clickWebElementWithJavascriptExecutor(getLastWorkspaceCreatedLink());

        this.setWorkspaceName(workspaceName);
        this.clickButtonSaveWorkspace();
    }

    /**
     * Method to delete a workspace.
     */
    public void deleteLastWorkspace() {
        CommonActions.clickWebElementWithJavascriptExecutor(getLastWorkspaceCreatedLink());
        this.clickButtonDeleteWorkspace();
        this.clickButtonConfirmDeleteWorkspace();
    }
}
