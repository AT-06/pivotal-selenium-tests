package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.utils.CommonActions;
import org.fundacionjala.pivotal.pages.common.Base;
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
        CommonActions.waitWebElement(messageDelete);
        return messageDelete.isDisplayed();
    }

    /**
     * Method for delete Project.
     */
    public void deleteProject() {
        CommonActions.clickWebElementWithJavascriptExecutor(buttonConfirmDelete);
    }
}

