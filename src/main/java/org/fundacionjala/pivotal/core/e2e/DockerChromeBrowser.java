package org.fundacionjala.pivotal.core.e2e;

import org.fundacionjala.pivotal.utils.NoConfigPropertiesFound;
import org.fundacionjala.pivotal.utils.PropertiesConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DockerChromeBrowser class that implements IBrowsers.
 */
public class DockerChromeBrowser implements Browser {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        Capabilities chromeCapabilities = DesiredCapabilities.chrome();
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(PropertiesConfig.getInstance().getDockerUrl()), chromeCapabilities);
        } catch (MalformedURLException e) {
            String message = "URL malformed";
            throw new NoConfigPropertiesFound(message, e);
        }
        return driver;
    }
}
