package org.fundacionjala.pivotal.core.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SauceTest {
    private static final String USERNAME = "SAUCE_USERNAME";
    private static final String ACCESS_KEY = "SAUCE_ACCESS_KEY";
    private static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = DesiredCapabilities.safari();
        caps.setCapability("platform", "MacOs  Sierra");
        caps.setCapability("version", "11");
        caps.setCapability("resolution", "1024x768");


        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        

        driver.quit();
    }
}
