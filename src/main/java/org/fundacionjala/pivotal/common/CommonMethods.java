package org.fundacionjala.pivotal.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class CommonMethods.
 */
public final class CommonMethods {

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
        waitWebElement(webElement).sendKeys(text);
    }


    /**
     * Method for ClickElement.
     *
     * @param webElement WebElement.
     */
    public static void clickWebElement(final WebElement webElement) {
        waitWebElement(webElement).click();
    }


    /**
     * Method for wait Web element.
     *
     * @param webElement WebElement.
     * @return the element.
     */
    public static WebElement waitWebElement(final WebElement webElement) {
        return DriverManager.getInstance().getDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

}