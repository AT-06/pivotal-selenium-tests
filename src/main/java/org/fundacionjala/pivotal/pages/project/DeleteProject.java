package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.core.e2e.CommonMethods;
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
        CommonMethods.waitWebElement(messageDelete);
        return messageDelete.isDisplayed();
    }

    /**
     * Method for delete Project.
     */
    public void deleteProject() {
        CommonMethods.clickWebElementWithJavascriptExecutor(buttonConfirmDelete);
    }
}

