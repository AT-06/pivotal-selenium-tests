package org.fundacionjala.pivotal.core.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by pivotal-test Team.
 */
public class ChromeBrowser implements Browser {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        return new ChromeDriver();
    }
}
