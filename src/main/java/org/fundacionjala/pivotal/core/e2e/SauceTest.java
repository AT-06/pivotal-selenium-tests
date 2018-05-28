package org.fundacionjala.pivotal.core.e2e;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *Class SauceTest.
 */
public class SauceTest extends Connection implements Browser {

    private static final String URL = "https://"
            + SAUCE_USERNAME + ":"
            + SAUCE_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    private static final String BROWSER_NAME = "browserName";
    private static final String PLATFORM = "platform";
    private static final String RESOLUTION = "resolution";
    private static final String VERSION = "version";


    /**
     * SauceTest Set url.
     */
    public SauceTest() {
        super(URL);
    }

    /**
     * @return .
     */
    @Override
    DesiredCapabilities setCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(BROWSER_NAME, PROPERTIES.getRemoteBrowser());
        caps.setCapability(PLATFORM, PROPERTIES.getRemotePlatform());
        caps.setCapability(VERSION, PROPERTIES.getPlatformVersion());
        caps.setCapability(RESOLUTION, PROPERTIES.getRemoteResolution());
        return caps;
    }

}
