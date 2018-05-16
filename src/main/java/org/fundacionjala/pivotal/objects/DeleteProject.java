package org.fundacionjala.pivotal.objects;

import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.common.CommonMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Class for Deleted Project Page Object.
 */
public class DeleteProject extends Base {

    @FindBy(how = How.ID, using = "confirm_delete")
    private WebElement buttonConfirmDelete;

    @FindBy(how = How.CSS, using = "#notice")
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
     * Method for ScrollPane.
     */
    private void scrollPane() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonConfirmDelete);

    }

    /**
     * Method for delete Project.
     */
    public void deleteProject() {
        this.scrollPane();

    }
}
