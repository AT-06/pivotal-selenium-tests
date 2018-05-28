package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.core.e2e.DriverManager;
import org.fundacionjala.pivotal.pages.common.Base;
import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class for PageLogin.
 */
public class PageLogin extends Base {

    @FindBy(name = "credentials[username]")
    private WebElement txtUsername;

    @FindBy(name = "credentials[password]")
    private WebElement txtPassword;

    @FindBy(name = "action")
    private WebElement txtButton;

    @FindBy(id = "projects-search-bar")
    private WebElement txtSearch;

    @FindBy(css = "a.tc_header_logo")
    private WebElement logoPivotal;

    private DashBoard dashBoard;

    public PageLogin(final DashBoard dashBoard) {
        this.dashBoard = dashBoard;
    }
    /**
     * Method for set txt User Name.
     *
     * @param username String.
     */
    private void setTxtUsername(final String username) {
        driverWait.until(ExpectedConditions.visibilityOf(txtUsername));
        txtUsername.sendKeys(username);
    }

    private WebElement getLogoPivotal() {

        return logoPivotal;
    }

    /**
     * Method for set txt Password.
     *
     * @param password String.
     */
    private void setTxtPassword(final String password) {
        driverWait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.sendKeys(password);
    }

    /**
     * Method for set txt Button.
     */
    private void setTxtButton() {
        driverWait.until(ExpectedConditions.visibilityOf(txtButton));
        txtButton.submit();
    }

    /**
     * Method for check Page Login.
     *
     * @return txtSearch is Displayed.
     */
    public boolean checkPageLogin() {
        driverWait.until(ExpectedConditions.visibilityOf(txtSearch));
        return txtSearch.isDisplayed();
    }

    /**
     * Method for use User Name and Password.
     *
     * @param username String.
     * @param password String.
     */
    public void signIn(final String username, final String password) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, 5);
            shortWait.until(ExpectedConditions.visibilityOf(txtUsername));
            setFieldsLogin(username, password);
        } catch (TimeoutException k) {
            dashBoard.setButtonDashborad();
        } catch (NoSuchElementException e) {
            dashBoard.setButtonDashborad();
        }

    }
    /**
     * Method for use User Name and Password.
     *
     * @param username String.
     * @param password String.
     */
    public void setFieldsLogin(final String username, final String password) {
        setTxtUsername(username);
        setTxtButton();
        setTxtPassword(password);
        setTxtButton();
    }
}
