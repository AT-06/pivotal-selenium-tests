package org.fundacionjala.pivotal.core.webdrivers;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Class for set capabilities for testing in Browserstack remote driver.
 */
public class Browserstack extends RemoteBrowser implements Browser {
    /**
     * @param url .
     */

    public static final String URL = String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub",
            USERNAME, ACCESS_KEY);
    private static final String BROWSER = "browser";
    private static final String VERSION = "browser_version";
    private static final String OS = "os";
    private static final String OS_VERSION = "os_version";
    private static final String RESOLUTION = "resolution";


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
        caps.setCapability(BROWSER, PROPERTIES.getRemoteBrowser());
        caps.setCapability(VERSION, PROPERTIES.getPlatformVersion());
        caps.setCapability(OS, PROPERTIES.getRemotePlatform());
        caps.setCapability(OS_VERSION, PROPERTIES.getOSVersion());
        caps.setCapability(RESOLUTION, PROPERTIES.getRemoteResolution());
        return caps;
    }
}
