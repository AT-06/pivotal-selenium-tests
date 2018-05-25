package org.fundacionjala.pivotal.core.e2e;

import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;

/**
 * Class created in order to recognize the driver type.
 */
public final class DriverFactory {


    /**
     * Private Constructor for the DriverFactory utility class.
     */
    private DriverFactory() {
    }

    /**
     * Return the WebDriver instance specified by the environment properties.
     *
     * @param driverType Enum value specified from DriverType.
     * @return a WebDriver instance.
     */
    public static WebDriver getDriverManager(final DriverType driverType) {
        Map<DriverType, Browser> map = new EnumMap<>(DriverType.class);
        map.put(DriverType.CHROME, new ChromeBrowser());
        map.put(DriverType.FIREFOX, new FirefoxBrowser());
        map.put(DriverType.IEXPLORER, new MicrosoftBrowser());
        map.put(DriverType.DOCKER_CHROME, new DockerChromeBrowser());
        map.put(DriverType.SAUCELABS, new SauceTest());
        return map.get(driverType).getBrowser();
    }
}
