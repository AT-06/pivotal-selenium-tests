package org.fundacionjala.pivotal.pages.common;

import org.fundacionjala.core.driver.DriverManager;
import org.fundacionjala.core.selenium.Base;
import org.fundacionjala.core.selenium.CommonWebActions;
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
        return CommonWebActions.waitWebElementVisible(tabWorkspace);
    }

    /**
     * Method for get top dropdown.
     *
     * @return tab workspace.
     */
    private WebElement getComboProjectWorkspaces() {
        return CommonWebActions.waitWebElementVisible(comboProjectWorkspaces);

    }

    /**
     * Method for get dashboard button.
     *
     * @return dashboard button.
     */
    private WebElement getButtonDashboard() {
        return CommonWebActions.waitWebElementVisible(buttonDashboard);

    }

    /**
     * Method for press click tab workspace.
     */
    public void clickTabWorkspace() {
        CommonWebActions.clickElement(this.getTabWorkspace());
    }

    /**
     * Method for press click top dropdown.
     */
    public void clickComboProjectWorkspaces() {
        CommonWebActions.jsClickElement(getComboProjectWorkspaces());
        CommonWebActions.clickElement(getComboProjectWorkspaces());
    }

    /**
     * Method for press click over dashboard button.
     */
    public void clickButtonDashboard() {
        CommonWebActions.clickElement(this.getButtonDashboard());
    }

    /**
     * Method for press click over dashboard button.
     */
    public void returnToDashboardFromProjWork() {
        DriverManager.getInstance().getDriver().navigate().to("https://www.pivotaltracker.com");
    }
}
