package org.fundacionjala.pivotal.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class Web common Driver.
 */
public final class WebCommonDriver {

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
        final int thirty = 30;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.pivotaltracker.com/signin");
        driverWait = new WebDriverWait(driver, thirty);
    }


    /**
     * Method for get Web common driver.
     * @return webCommonDriver.
     */
    public static WebCommonDriver getWebCommonDriver() {
        if (webCommonDriver == null) {
            webCommonDriver = new WebCommonDriver();
        }
        return webCommonDriver;
    }


    /**
     * Method for get Driver.
     * @return driver.
     */
    public WebDriver getDriver() {
        return driver;
    }


    /**
     * Method get WebDriver.
     * @return driverWait.
     */
    public WebDriverWait getDriverWait() {
        return driverWait;
    }
}
