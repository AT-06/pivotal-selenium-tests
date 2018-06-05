package org.fundacionjala.pivotal.core.webdrivers;

import org.fundacionjala.pivotal.util.NoConfigPropertiesFound;
import org.fundacionjala.pivotal.util.PropertiesConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DockerChromeBrowser class.
 */
public class DockerChromeBrowser implements Browser {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(PropertiesConfig.getInstance().getDockerUrl()), new ChromeOptions());
        } catch (MalformedURLException e) {
            String message = "URL bad created";
            throw new NoConfigPropertiesFound(message, e);
        }
        return driver;
    }
}
