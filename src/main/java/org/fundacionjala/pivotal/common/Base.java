package org.fundacionjala.pivotal.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class Base.
 */
public class Base {
    protected WebDriver driver;
    protected WebDriverWait driverWait;

    /**
     * Method for Base for declared WebCommonDriver.
     */
    public Base() {
        driver = WebCommonDriver.getWebCommonDriver().getDriver();
        driverWait = WebCommonDriver.getWebCommonDriver().getDriverWait();
        PageFactory.initElements(driver, this);
    }
}
