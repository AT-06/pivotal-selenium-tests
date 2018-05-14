package org.fundacionjala.pivotal.objects;

import org.fundacionjala.pivotal.common.Base;
import org.fundacionjala.pivotal.common.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Class Account for start the Project.
 */
public class Account extends Base {

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Profile Dropdown')]")
    private WebElement profileButton;

    @FindBy(how = How.CSS, using = "#shared_header a:nth-child(4).Dropdown__option.Dropdown__option--link")
    private WebElement accountButton;

    @FindBy(how = How.ID, using = "new_account_link")
    private WebElement createAccounButton;

    @FindBy(how = How.CSS, using = "#modal_area input.tc-form__input")
    private WebElement txtAccountName;

    @FindBy(how = How.CSS, using =
            "#modal_area button.zWDds__Button.pvXpn__Button--positive.zWDds__Button.pvXpn__Button--positive")
    private WebElement createButton;

    @FindBy(how = How.CSS, using = "#main  h2.account_name")
    private WebElement txtVerifyAccountName;

    /**
     * Set verify the account name.
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
     * @param accountName String.
     */
    private void setTxtAccountName(String accountName) {
        CommonMethods.setWebElement(txtAccountName, accountName);
    }

    /**
     * Set Account Button.
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
     * Set Account Button.
     */
    private void setAccountButton() {
        CommonMethods.clickWebElement(accountButton);
    }

    /**
     * Set Create Account all previous setter declared.
     * @param accountName String.
     */
    public final void createAccount(String accountName) {
        this.setProfileButton();
        this.setAccountButton();
        this.setCreateAccounButton();
        this.setTxtAccountName(accountName);
        this.setCreateButton();
    }

    /**
     * Set verify Account Name.
     * @return setTxtVerifyAccountName.
     */
    public Boolean verifyTheAccountName() {
        return this.setTxtVerifyAccountName();
    }
}
