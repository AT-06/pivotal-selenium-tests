package org.fundacionjala.pivotal.pages.common;

import org.fundacionjala.pivotal.utils.CommonActions;
import org.fundacionjala.pivotal.core.webdrivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * class navigator to return to dashboard from any place.
 */
public class Navigator extends Base {
    @FindBy(css = "div.Dashboard__Tabs> span:nth-child(2)")
    private WebElement tabWorkspace;

    @FindBy(css = ".tc_projects_dropdown_link")
    private WebElement comboProjectWorkspaces;

    @FindBy(css = ".tc_projects_menu_dashboard")
    private WebElement buttonDashboard;

    /**
     * Method for get Workspace tab.
     *
     * @return tab workspace.
     */
    private WebElement getTabWorkspace() {
        return CommonActions.waitWebElement(tabWorkspace);
    }

    /**
     * Method for get top dropdown.
     *
     * @return tab workspace.
     */
    private WebElement getComboProjectWorkspaces() {
        return CommonActions.waitWebElement(comboProjectWorkspaces);

    }

    /**
     * Method for get dashboard button.
     *
     * @return dashboard button.
     */
    private WebElement getButtonDashboard() {
        return CommonActions.waitWebElement(buttonDashboard);

    }

    /**
     * Method for press click tab workspace.
     */
    public void clickTabWorkspace() {
        CommonActions.clickWebElement(this.getTabWorkspace());
    }

    /**
     * Method for press click top dropdown.
     */
    public void clickComboProjectWorkspaces() {
        CommonActions.clickWebElementWithJavascriptExecutor(getComboProjectWorkspaces());
        CommonActions.clickWebElement(getComboProjectWorkspaces());


    }

    /**
     * Method for press click over dashboard button.
     */
    public void clickButtonDashboard() {
        CommonActions.clickWebElement(this.getButtonDashboard());
    }

    /**
     * Method for press click over dashboard button.
     */
    public void returnToDashboardFromProjWork() {
        DriverManager.getInstance().getDriver().navigate().to("https://www.pivotaltracker.com");
    }
}
