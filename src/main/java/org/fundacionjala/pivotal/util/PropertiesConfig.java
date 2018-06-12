package org.fundacionjala.pivotal.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * PropertiesConfig is class for read config.properties.
 */
public final class PropertiesConfig {

    /**
     * properties.
     */
    private Properties properties;

    /**
     * PropertiesConfig.
     */
    private static PropertiesConfig propertiesConfig;

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * @return a instance of PropertiesConfig.
     */
    public static PropertiesConfig getInstance() {
        if (propertiesConfig == null) {
            propertiesConfig = new PropertiesConfig();
        }
        return propertiesConfig;
    }

    /**
     * Constructor.
     */
    private PropertiesConfig() {
        init();
    }

    /**
     * This method initialize properties and input stream.
     */
    private void init() {

        try (InputStream inputStream = new FileInputStream("gradle.properties")) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            String message = "Not instance driver";
            LOGGER.error(message);
            LOGGER.info(e);
            throw new NoConfigPropertiesFound(message, e);
        }
    }

    /**
     * @return User.
     */
    public String getUser() {
        return getEnvValue("User");
    }

    /**
     * @return Url.
     */
    public String getUrl() {
        return getEnvValue("urlLogin");
    }

    /**
     * @return Password.
     */
    public String getPassword() {
        return getEnvValue("Password");
    }

    /**
     * Method to get token to use API.
     *
     * @return the token read from properties file.
     */
    public String getAPIToken() {
        return getEnvValue("APIToken");
    }

    /**
     * Method to get Name user of sauceLabs.
     *
     * @return the Username SauceLabs read from properties file.
     */
    public String getSauceUserName() {
        return getEnvValue("UserName");
    }

    /**
     * Method to get key of sauceLabs.
     *
     * @return the key SauceLabs read from properties file.
     */
    public String getSauceKey() {
        return getEnvValue("Key");
    }

    /**
     * Method to get Remote Browser of sauceLabs.
     *
     * @return the browser SauceLabs selected read from properties file.
     */
    public String getRemoteBrowser() {
        return getEnvValue("remoteBrowser");
    }

    /**
     * Method to get OS of sauceLabs.
     *
     * @return the OS SauceLabs selected read from properties file.
     */
    public String getRemotePlatform() {
        return getEnvValue("remotePlatform");
    }

    /**
     * Method to get Browser version of sauceLabs.
     *
     * @return the Browser version of SauceLabs  selected read from properties file.
     */
    public String getPlatformVersion() {
        return getEnvValue("remotePlatformVersion");
    }

    /**
     * Method to get resolution of sauceLabs.
     *
     * @return the resolution SauceLabs selected read from properties file.
     */
    public String getRemoteResolution() {
        return getEnvValue("remoteResolution");
    }

    /**
     * Method to return the docker url from the environment properties.
     *
     * @return the docker url in a string object.
     */
    public String getDockerUrl() {
        return getEnvValue("dockerUrl");
    }

    /**
     * Method to return the browser from the environments properties.
     *
     * @return the browser.
     */
    public String getBrowser() {
        return getEnvValue("browser");
    }

    /**
     * Getter for the OS version for Browserstack remote driver.
     *
     * @return the version OS.
     */
    public String getOSVersion() {
        return getEnvValue("OSVersion");
    }

    /**
     * This method return the string for a specific environment property.
     *
     * @param env is the property string.
     * @return the specified property.
     */
    private String getEnvValue(final String env) {
        String property = System.getProperty(env);
        return property == null ? properties.getProperty(env) : property;
    }
}


