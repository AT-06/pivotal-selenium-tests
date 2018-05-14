package org.fundacionjala.pivotal.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class CommonMethods.
 */
public final class CommonMethods {

    /**
     * Method for init Driver wait.
     */
    private static WebDriverWait driverWait = WebCommonDriver.getWebCommonDriver().getDriverWait();


    /**
     * Method for set WebElement.
     * @param webElement WebElement.
     * @param text String.
     */
    public static void setWebElement(WebElement webElement, String text) {
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }


    /**
     * Method for ClickElement.
     * @param webElement WebElement.
     */
    public static void clickWebElement(WebElement webElement) {
        driverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }


    /**
     * Method for wait Web element.
     * @param webElement WebElement.
     */
    public static void waitWebElement(WebElement webElement) {
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
