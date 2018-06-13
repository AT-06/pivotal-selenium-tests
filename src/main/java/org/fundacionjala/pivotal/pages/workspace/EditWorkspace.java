package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.core.selenium.Base;
import org.fundacionjala.core.selenium.CommonWebActions;
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
        return CommonWebActions.waitWebElementVisible(lastWorkspaceCreatedLink);
    }

    /**
     * Method for get the last workspace created.
     *
     * @return lastWorspaceCreatedLink.
     */
    public WebElement getSuccessDeleteMessage() {
        return CommonWebActions.waitWebElementVisible(successDeleteMessage);

    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getTxtWorkspaceName() {
        return CommonWebActions.waitWebElementVisible(txtWorkspaceName);

    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getButtonSaveWorkspace() {
        return CommonWebActions.waitWebElementVisible(buttonSaveWorkspace);
    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getButtonDeleteWorkspace() {
        return CommonWebActions.waitWebElementVisible(buttonDeleteWorkspace);
    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getButtonConfirmDeleteWorkspace() {
        return CommonWebActions.waitWebElementVisible(buttonConfirmDeleteWorkspace);
    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    public WebElement getSuccessMessage() {
        return CommonWebActions.waitWebElementVisible(successMessage);
    }

    /**
     * Method for set Workspace name.
     *
     * @param workspaceName String.
     */
    private void setWorkspaceName(final String workspaceName) {
        CommonWebActions.setTextElement(getTxtWorkspaceName(), workspaceName);
    }

    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonSaveWorkspace() {
        CommonWebActions.clickElement(this.getButtonSaveWorkspace());
    }

    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonDeleteWorkspace() {
        CommonWebActions.clickElement(this.getButtonDeleteWorkspace());
    }

    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonConfirmDeleteWorkspace() {
        CommonWebActions.clickElement(this.getButtonConfirmDeleteWorkspace());
    }

    /**
     * Method to Create workspace .
     *
     * @param workspaceName String.
     */
    public void editWorkspace(final String workspaceName) {

        CommonWebActions.jsClickElement(getLastWorkspaceCreatedLink());

        this.setWorkspaceName(workspaceName);
        this.clickButtonSaveWorkspace();
    }

    /**
     * Method to delete a workspace.
     */
    public void deleteLastWorkspace() {
        CommonWebActions.jsClickElement(getLastWorkspaceCreatedLink());
        this.clickButtonDeleteWorkspace();
        this.clickButtonConfirmDeleteWorkspace();
    }
}
