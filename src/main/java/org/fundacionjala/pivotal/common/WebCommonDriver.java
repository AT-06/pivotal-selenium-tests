package org.fundacionjala.pivotal.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class Web common Driver.
 */
public class WebCommonDriver {

    /**
     * WebDriver driver declared.
     */
    private WebDriver driver;

    /**
     * WebDriverWait driverWait declared.
     */
    private WebDriverWait driverWait;

    /**
     * WebCommonDriver webCommonDriver declared.
     */
    private static WebCommonDriver webCommonDriver;

    /**
     * Method Web common Driver.
     * Use Singleton Pattern.
     */
    private WebCommonDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.pivotaltracker.com/signin");
        driverWait = new WebDriverWait(driver,30);
    }

    /**
     * Method for get Web common driver.
     */
    public static WebCommonDriver getWebCommonDriver() {
        if (webCommonDriver == null) {
            webCommonDriver = new WebCommonDriver();
        }
        return webCommonDriver;
    }

    /**
     * Method for getDriver.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Method for getDriverWait.
     */
    public WebDriverWait getDriverWait() {
        return driverWait;
    }
}
