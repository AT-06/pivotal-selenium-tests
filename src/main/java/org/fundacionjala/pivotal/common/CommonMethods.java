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
    private static WebDriverWait DRIVER_WAIT = WebCommonDriver.getWebCommonDriver().getDriverWait();

    /**
     * Method for set Web Element.
     */
    public static void setWebElement(WebElement webElement, String text) {
        DRIVER_WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    /**
     * Method for Click Web Element.
     */
    public static void clickWebElement(WebElement webElement) {
        DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Method for wait web element.
     */
    public static void waitWebElement(WebElement webElement) {
        DRIVER_WAIT.until(ExpectedConditions.visibilityOf(webElement));
    }

}
