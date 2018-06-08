package org.fundacionjala.pivotal.pages.common;

import org.fundacionjala.pivotal.core.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class Base.
 */
public class Base {
    protected WebDriver webDriver;
    protected WebDriverWait driverWait;

    /**
     * Method for Base for declared DriverManager.
     */
    public Base() {
        this.webDriver = DriverManager.getInstance().getDriver();
        driverWait = DriverManager.getInstance().getWaiter();
        PageFactory.initElements(this.webDriver, this);
    }
}
