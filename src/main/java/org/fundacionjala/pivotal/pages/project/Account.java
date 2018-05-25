package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.core.e2e.CommonMethods;
import org.fundacionjala.pivotal.pages.common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    /**
     * Set verify the account name.
     *
     * @return txtVerifyAccountName in the display.
     */
    private Boolean setTxtVerifyAccountName() {
        CommonMethods.waitWebElement(txtVerifyAccountName);
        return txtVerifyAccountName.isDisplayed();
    }

    /**
     * Set Button for create.
     */
    private void setCreateButton() {
        CommonMethods.clickWebElement(createButton);
    }

    /**
     * Set txtAccountName.
     *
     * @param accountName String.
     */
    private void setTxtAccountName(final String accountName) {
        CommonMethods.setWebElement(txtAccountName, accountName);
    }

    /**
     * Set account Button.
     */
    private void setCreateAccounButton() {
        CommonMethods.clickWebElement(createAccounButton);
    }

    /**
     * Set Profile Button.
     */
    private void setProfileButton() {
        CommonMethods.clickWebElement(profileButton);
    }

    /**
     * Set account Button.
     */
    private void setAccountButton() {
        CommonMethods.clickWebElement(accountButton);
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
}
