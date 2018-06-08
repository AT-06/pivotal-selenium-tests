package org.fundacionjala.pivotal.core.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by pivotal-test Team.
 */
public class ChromeBrowser implements Browser {

    /**
     * Get the Chrome webDriver.
     *
     * @return the ChromeDriver.
     */
    @Override
    public WebDriver getBrowser() {
        return new ChromeDriver();
    }
}
