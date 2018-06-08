package org.fundacionjala.pivotal.core.webdrivers;

import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;

/**
 * Class created in order to recognize the webDriver type.
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
        map.put(DriverType.DOCKER_CHROME, new DockerChromeBrowser());
        map.put(DriverType.DOCKER_FIREFOX, new DockerFirefoxBrowser());
        map.put(DriverType.SAUCELABS, new SauceLabs());
        map.put(DriverType.BROWSER_STACK, new BrowserConnectionStack());
        return map.get(driverType).getBrowser();
    }
}
