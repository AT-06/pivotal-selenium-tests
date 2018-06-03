package org.fundacionjala.pivotal.core.webdrivers;

import org.fundacionjala.pivotal.utils.PropertiesConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class Web utils Driver.
 */
public final class DriverManager {

    /**
     * WebDriver driver declared.
     */
    private WebDriver driver;

    /**
     * WebDriverWait driverWait declared.
     */
    private WebDriverWait driverWait;

    /**
     * DriverManager instance declared.
     */
    private static DriverManager instance;

    /**
     * Method Web utils Driver.
     * Use Singleton Pattern.
     */
    private DriverManager() {
        final int explicitWaitTimeOut = 30;
        DriverType driverType = DriverType.valueOf(PropertiesConfig.getInstance().getBrowser());
        driver = DriverFactory.getDriverManager(driverType);
        driver.navigate().to("https://www.pivotaltracker.com/signin");
        driverWait = new WebDriverWait(driver, explicitWaitTimeOut);
    }

    /**
     * Method for get Web utils driver.
     *
     * @return instance.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Method for get Driver.
     *
     * @return driver.
     */
    public WebDriver getDriver() {
        return driver;
    }


    /**
     * Method get WebDriver.
     *
     * @return driverWait.
     */
    public WebDriverWait getDriverWait() {
        return driverWait;
    }
}
