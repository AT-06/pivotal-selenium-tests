package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.core.selenium.Base;
import org.fundacionjala.core.selenium.CommonWebActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for Deleted Project Page Object.
 */
public class DeleteProject extends Base {

    @FindBy(id = "confirm_delete")
    private WebElement buttonConfirmDelete;

    @FindBy(css = "#notice")
    private WebElement messageDelete;

    /**
     * Method for set Message Delete.
     *
     * @return messageDeleted is Displayed.
     */
    public boolean setMessageDelete() {
        CommonWebActions.waitWebElementVisible(messageDelete);
        return messageDelete.isDisplayed();
    }

    /**
     * Method for delete Project.
     */
    public void deleteProject() {
        CommonWebActions.jsClickElement(buttonConfirmDelete);
    }
}

