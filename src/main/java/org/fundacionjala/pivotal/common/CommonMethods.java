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
     * Constructor Private.
     */
    private CommonMethods() {
    }

    /**
     * Method for set WebElement.
     *
     * @param webElement WebElement.
     * @param text       String.
     */
    public static void setWebElement(final WebElement webElement, final String text) {
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }


    /**
     * Method for ClickElement.
     *
     * @param webElement WebElement.
     */
    public static void clickWebElement(final WebElement webElement) {
        driverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }


    /**
     * Method for wait Web element.
     *
     * @param webElement WebElement.
     */
    public static void waitWebElement(final WebElement webElement) {
        driverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
