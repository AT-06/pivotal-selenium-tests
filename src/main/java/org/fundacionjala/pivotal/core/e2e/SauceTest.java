package org.fundacionjala.pivotal.core.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SauceTest {
    private static final String USERNAME = "SAUCE_USERNAME";
    private static final String ACCESS_KEY = "SAUCE_ACCESS_KEY";
    private static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    public static void createDriver(String browser, String version,String os) throws Exception {

        DesiredCapabilities caps = DesiredCapabilities.safari();
        caps.setCapability(CapabilityType.BROWSER_NAME, browser);
        caps.setCapability(CapabilityType.VERSION, version);
        caps.setCapability(CapabilityType.PLATFORM_NAME, os);


        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        

        driver.quit();
    }
}
