package org.fundacionjala.pivotal.core.webdrivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.pivotal.util.NoConfigPropertiesFound;
import org.fundacionjala.pivotal.util.PropertiesConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class RemoteBrowserConnection.
 */
public abstract class RemoteBrowserConnection implements Browser {

    static final PropertiesConfig PROPERTIES_MANAGER = PropertiesConfig.getInstance();
    static final String USERNAME = PROPERTIES_MANAGER.getRemoteUserName();
    static final String ACCESS_KEY = PROPERTIES_MANAGER.getRemoteAccessKey();
    private static final Logger LOGGER = LogManager.getLogger();
    private final String url;

    /**
     * Set Capabilities.
     *
     * @return capabilities of sauceLabs.
     */
    abstract DesiredCapabilities setCapabilities();

    /**
     * @param url .
     */
    public RemoteBrowserConnection(final String url) {
        this.url = url;
    }

    /**
     * @return .
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(url), setCapabilities());
        } catch (MalformedURLException e) {
            String message = "URL not valid";
            LOGGER.error(message);
            LOGGER.info(e);
            throw new NoConfigPropertiesFound(message, e);
        }
        return driver;
    }
}
