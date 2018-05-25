package org.fundacionjala.pivotal.core.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by pivotal-test Team.
 */
public class FirefoxBrowser implements Browser {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        return new FirefoxDriver();
    }
}
