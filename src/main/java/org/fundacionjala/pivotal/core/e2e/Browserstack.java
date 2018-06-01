package org.fundacionjala.pivotal.core.e2e;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Class for set capabilities for testing in Browserstack remote driver.
 */
public class Browserstack extends Connection implements Browser {
    /**
     * @param url .
     */

    public static final String URL = String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub",
            BROWSERSTACK_USERNAME, BROWSERSTACK_KEY);
    private static final String BROWSER_NAME = "browser";
    private static final String BROWSER_VERSION = "browser_version";
    private static final String BROWSER_OS = "os";
    private static final String BROWSER_OS_VERSION = "os_version";
    private static final String BROWSER_RESOLUTION = "resolution";


    /**
     * BrowserStack Set url.
     */
    public Browserstack() {
        super(URL);
    }

    /**
     * @return .
     */
    @Override
    DesiredCapabilities setCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(BROWSER_NAME, PROPERTIES.getBrowserName());
        caps.setCapability(BROWSER_VERSION, PROPERTIES.getBrowserVersion());
        caps.setCapability(BROWSER_OS, PROPERTIES.getOSName());
        caps.setCapability(BROWSER_OS_VERSION, PROPERTIES.getOSVersion());
        caps.setCapability(BROWSER_RESOLUTION, PROPERTIES.getBrowserResolution());
        return caps;
    }
}
