package org.fundacionjala.pivotal.core.webdrivers;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *Class SauceLabs.
 */
public class SauceLabs extends RemoteBrowserConnection implements Browser {

    private static final String URL = String
            .format("https://%s:%s@ondemand.saucelabs.com:443/wd/hub", USERNAME, ACCESS_KEY);
    private static final String BROWSER_NAME = "browserName";
    private static final String PLATFORM = "platform";
    private static final String RESOLUTION = "resolution";
    private static final String VERSION = "version";


    /**
     * SauceLabs Set url.
     */
    public SauceLabs() {
        super(URL);
    }

    /**
     * @return .
     */
    @Override
    DesiredCapabilities setCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(BROWSER_NAME, PROPERTIES_MANAGER.getRemoteBrowserName());
        caps.setCapability(PLATFORM, PROPERTIES_MANAGER.getRemotePlatform());
        caps.setCapability(VERSION, PROPERTIES_MANAGER.getRemoteBrowserVersion());
        caps.setCapability(RESOLUTION, PROPERTIES_MANAGER.getRemoteResolution());
        return caps;
    }
}
