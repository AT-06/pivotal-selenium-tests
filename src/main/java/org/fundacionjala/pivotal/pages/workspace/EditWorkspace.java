package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.pages.common.Base;
import org.fundacionjala.pivotal.core.e2e.CommonMethods;
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
        return CommonMethods.waitWebElement(lastWorkspaceCreatedLink);

    }

    /**
     * Method for get the last workspace created.
     *
     * @return lastWorspaceCreatedLink.
     */
    public WebElement getSuccessDeleteMessage() {
        return CommonMethods.waitWebElement(successDeleteMessage);

    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getTxtWorkspaceName() {
        return CommonMethods.waitWebElement(txtWorkspaceName);

    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getButtonSaveWorkspace() {
        return CommonMethods.waitWebElement(buttonSaveWorkspace);
    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getButtonDeleteWorkspace() {
        return CommonMethods.waitWebElement(buttonDeleteWorkspace);
    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    private WebElement getButtonConfirmDeleteWorkspace() {
        return CommonMethods.waitWebElement(buttonConfirmDeleteWorkspace);
    }

    /**
     * Method for get the last workspace created.
     *
     * @return the workspace name input.
     */
    public WebElement getSuccessMessage() {
        return CommonMethods.waitWebElement(successMessage);
    }

    /**
     * Method for set Workspace name.
     *
     * @param workspaceName String.
     */
    private void setWorkspaceName(final String workspaceName) {
        CommonMethods.setWebElement(getTxtWorkspaceName(), workspaceName);
    }

    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonSaveWorkspace() {
        CommonMethods.clickWebElement(this.getButtonSaveWorkspace());
    }

    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonDeleteWorkspace() {
        CommonMethods.clickWebElement(this.getButtonDeleteWorkspace());
    }

    /**
     * Method for press click buttton for save a new workspace.
     */
    private void clickButtonConfirmDeleteWorkspace() {
        CommonMethods.clickWebElement(this.getButtonConfirmDeleteWorkspace());
    }

    /**
     * Method to Create workspace .
     *
     * @param workspaceName String.
     */
    public void editWorkspace(final String workspaceName) {

        CommonMethods.clickWebElementWithJavascriptExecutor(getLastWorkspaceCreatedLink());

        this.setWorkspaceName(workspaceName);
        this.clickButtonSaveWorkspace();
    }

    /**
     * Method to delete a workspace.
     */
    public void deleteLastWorkspace() {
        CommonMethods.clickWebElementWithJavascriptExecutor(getLastWorkspaceCreatedLink());
        this.clickButtonDeleteWorkspace();
        this.clickButtonConfirmDeleteWorkspace();
    }
}
