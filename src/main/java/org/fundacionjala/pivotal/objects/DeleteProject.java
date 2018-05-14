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

    @FindBy(how = How.XPATH, using = "//*[contains(@href,'#') and  text()='Delete']")
    // //*[contains(@href,'#') and  text()='Delete']
    private WebElement buttonDeleteProject;

    @FindBy(how = How.ID, using = "confirm_delete")
    private WebElement buttonConfirmDelete;

    @FindBy(how = How.CSS, using = "#notice")
    private WebElement messageDelete;

    /**
     * Method for set Message Delete.
     * @return messageDeleted is Displayed.
     */
    public boolean setMessageDelete() {
        CommonMethods.waitWebElement(messageDelete);
        return messageDelete.isDisplayed();
    }

    /**
     * Method for set Button Delete Project.
     */
    public void setButtonDeleteProject() {
        CommonMethods.clickWebElement(buttonDeleteProject);
    }

    /**
     * Method for Button Confirm delete.
     */
    public void setButtonConfirmDelete() {
        CommonMethods.clickWebElement(buttonConfirmDelete);
    }

    /**
     * Method for ScrollPane.
     */
    public void scrollPane() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonConfirmDelete);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,2500)");
        CommonMethods.clickWebElement(buttonConfirmDelete);
    }
    /**
     * Method for delete Project.
     */
    public void deleteProject() {
        this.scrollPane();
        this.setButtonDeleteProject();
        this.setButtonConfirmDelete();
    }
}
