package org.fundacionjala.pivotal.pages.common;

import org.fundacionjala.pivotal.core.e2e.CommonMethods;
import org.fundacionjala.pivotal.core.e2e.DriverManager;
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
        return CommonMethods.waitWebElement(tabWorkspace);
    }

    /**
     * Method for get top dropdown.
     *
     * @return tab workspace.
     */
    private WebElement getComboProjectWorkspaces() {
        return CommonMethods.waitWebElement(comboProjectWorkspaces);

    }

    /**
     * Method for get dashboard button.
     *
     * @return dashboard button.
     */
    private WebElement getButtonDashboard() {
        return CommonMethods.waitWebElement(buttonDashboard);

    }

    /**
     * Method for press click tab workspace.
     */
    public void clickTabWorkspace() {
        CommonMethods.clickWebElement(this.getTabWorkspace());
    }

    /**
     * Method for press click top dropdown.
     */
    public void clickComboProjectWorkspaces() {
        CommonMethods.clickWebElementWithJavascriptExecutor(getComboProjectWorkspaces());
        CommonMethods.clickWebElement(getComboProjectWorkspaces());


    }

    /**
     * Method for press click over dashboard button.
     */
    public void clickButtonDashboard() {
        CommonMethods.clickWebElement(this.getButtonDashboard());
    }

    /**
     * Method for press click over dashboard button.
     */
    public void returnToDashboardFromProjWork() {
        DriverManager.getInstance().getDriver().navigate().to("https://www.pivotaltracker.com");
    }
}
