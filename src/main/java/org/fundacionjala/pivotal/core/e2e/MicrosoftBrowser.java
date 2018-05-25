package org.fundacionjala.pivotal.core.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by pivotal-test Team.
 */
public class MicrosoftBrowser implements Browser {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        return new InternetExplorerDriver();
    }
}
