package org.fundacionjala.pivotal.core.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *Class SauceTest.
 */
public class SauceTest {
    private static final String BUILD = System.getenv("BUILD_TAG");
    private static final String USERNAME = "SAUCE_USERNAME";
    private static final String ACCESS_KEY = "SAUCE_ACCESS_KEY";
    private static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    /**
     * @param browser navigator.
     * @param version of os.
     * @param os is a System operative.
     * @throws MalformedURLException .
     */
     void createDriver(final String browser, final String version, final String os) throws MalformedURLException {

        DesiredCapabilities caps = DesiredCapabilities.safari();
        caps.setCapability(CapabilityType.BROWSER_NAME, browser);
        caps.setCapability(CapabilityType.VERSION, version);
        caps.setCapability(CapabilityType.PLATFORM_NAME, os);



        if (BUILD != null) {
            caps.setCapability("build", BUILD);
        }

        // Launch remote browser and set it as the current thread
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);




        driver.quit();
    }
}
