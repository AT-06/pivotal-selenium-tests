package org.fundacionjala.pivotal.core.e2e;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *Class SauceTest.
 */
public class SauceTest extends Connection implements Browser {

    private static final String URL = "https://"
            + SAUCE_USERNAME + ":"
            + SAUCE_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    private static final String PLATFORM = "platform";
    private static final String RESOLUTION = "resolution";
    private static final String REMOTE_PLATFORM = "MacOS High Sierra";
    private static final String REMOTE_PLATFORM_VERSION = "11";
    private static final String REMOTE_RESOLUTION = "1024x768";

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
        DesiredCapabilities caps = DesiredCapabilities.safari();
        caps.setCapability(PLATFORM, String.format("%s %s",
                REMOTE_PLATFORM,
                REMOTE_PLATFORM_VERSION));
        caps.setCapability(RESOLUTION, REMOTE_RESOLUTION);
        return caps;
    }

}
