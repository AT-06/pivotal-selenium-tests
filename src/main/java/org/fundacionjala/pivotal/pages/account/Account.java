package org.fundacionjala.pivotal.pages.account;

import org.fundacionjala.pivotal.utils.CommonActions;
import org.fundacionjala.pivotal.pages.common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class account for start the Project.
 */
public class Account extends Base {

    @FindBy(xpath = "//*[contains(@aria-label,'Profile Dropdown')]")
    private WebElement profileButton;

    @FindBy(css = "#shared_header a:nth-child(4).Dropdown__option.Dropdown__option--link")
    private WebElement accountButton;

    @FindBy(id = "new_account_link")
    private WebElement createAccounButton;

    @FindBy(css = "#modal_area input.tc-form__input")
    private WebElement txtAccountName;

    @FindBy(css =
            "#modal_area button.zWDds__Button.pvXpn__Button--positive.zWDds__Button.pvXpn__Button--positive")
    private WebElement createButton;

    @FindBy(css = "#main  h2.account_name")
    private WebElement txtVerifyAccountName;

    @FindBy(css = "button[aria-label='Profile Dropdown']")
    private WebElement profileDropdown;

    @FindBy(linkText = "Accounts")
    private WebElement linkAccounts;

    @FindBy(css = "div.tabular_data:last-child a.header_button:last-child")
    private WebElement manageAccount;

    @FindBy(css = ".subnav li:nth-child(2) a")
    private WebElement settingsButton;

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteLink;

    /**
     * Set verify the account name.
     *
     * @return txtVerifyAccountName in the display.
     */
    private Boolean setTxtVerifyAccountName() {
        CommonActions.waitWebElement(txtVerifyAccountName);
        return txtVerifyAccountName.isDisplayed();
    }

    /**
     * Set do click in the settings account button.
     *
     */
    private void setSettingsButton() {
        CommonActions.clickWebElement(settingsButton);
    }
    /**
     * Set do click in the settings account button.
     *
     */
    private void setDeleteLink() {
        CommonActions.clickWebElement(deleteLink);
    }

    /**
     * Set do click in the dropdown profile.
     *
     */
    private void setManageAccount() {
        CommonActions.clickWebElement(manageAccount);
    }

    /**
     * Set do click in the dropdown profile.
     *
     */
    private void setProfileDropdown() {
        CommonActions.clickWebElement(profileDropdown);
    }

    /**
     * click over accounts.
     *
     */
    private void setLinkAccounts() {
        CommonActions.clickWebElement(linkAccounts);
    }

    /**
     * Set Button for create.
     */
    private void setCreateButton() {
        CommonActions.clickWebElement(createButton);
    }

    /**
     * Set txtAccountName.
     *
     * @param accountName String.
     */
    private void setTxtAccountName(final String accountName) {
        CommonActions.setWebElement(txtAccountName, accountName);
    }

    /**
     * Set account Button.
     */
    private void setCreateAccounButton() {
        CommonActions.clickWebElement(createAccounButton);
    }

    /**
     * Set Profile Button.
     */
    private void setProfileButton() {
        CommonActions.clickWebElement(profileButton);
    }

    /**
     * Set account Button.
     */
    private void setAccountButton() {
        CommonActions.clickWebElement(accountButton);
    }

    /**
     * Set Create account all previous setter declared.
     *
     * @param accountName String.
     */
    public final void createAccount(final String accountName) {
        this.setProfileButton();
        this.setAccountButton();
        this.setCreateAccounButton();
        this.setTxtAccountName(accountName);
        this.setCreateButton();
    }

    /**
     * Set verify account Name.
     *
     * @return setTxtVerifyAccountName.
     */
    public Boolean verifyTheAccountName() {
        return this.setTxtVerifyAccountName();
    }
    /**
     * go to accounts.
     */
    public void goToAccounts() {
        setProfileDropdown();
        setLinkAccounts();
    }
    /**
     * Delete account.
     *
     */
    public void delete() {
        setManageAccount();
        setSettingsButton();
        setDeleteLink();
        clickDeleteAlert();
    }

    /**
     * clickDeleteAlert.
     */
    public void clickDeleteAlert() {
        Alert alert = driverWait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
