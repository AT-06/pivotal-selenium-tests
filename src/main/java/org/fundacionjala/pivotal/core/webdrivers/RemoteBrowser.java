package org.fundacionjala.pivotal.core.webdrivers;

import org.fundacionjala.pivotal.util.NoConfigPropertiesFound;
import org.fundacionjala.pivotal.util.PropertiesConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class RemoteBrowser.
 */
public abstract class RemoteBrowser implements Browser {

    static final PropertiesConfig PROPERTIES = PropertiesConfig.getInstance();
    static final String USERNAME = PROPERTIES.getSauceUserName();
    static final String ACCESS_KEY = PROPERTIES.getSauceKey();
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
    public RemoteBrowser(final String url) {
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
            throw new NoConfigPropertiesFound(message, e);
        }
        return driver;
    }
}
