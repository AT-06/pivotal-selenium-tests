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
     * Method for Base for declared DriverManager.
     */
    public Base() {
        driver = DriverManager.getInstance().getDriver();
        driverWait = DriverManager.getInstance().getDriverWait();
        PageFactory.initElements(driver, this);
    }
}
