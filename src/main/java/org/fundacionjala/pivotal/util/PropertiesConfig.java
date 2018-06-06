package org.fundacionjala.pivotal.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
            throw new NoConfigPropertiesFound("Class PropertiesConfig: ", e);
        }
    }

    /**
     * @return User.
     */
    public String getUser() {
        return getEnv("User");
    }

    /**
     * @return Password.
     */
    public String getPassword() {
        return getEnv("Password");
    }

    /**
     * Method to get token to use API.
     *
     * @return the token read from properties file.
     */
    public String getAPIToken() {
        return getEnv("APIToken");
    }

    /**
     * Method to get Name user of sauceLabs.
     *
     * @return the Username SauceLabs read from properties file.
     */
    public String getSauceUserName() {
        return getEnv("UserName");
    }

    /**
     * Method to get key of sauceLabs.
     *
     * @return the key SauceLabs read from properties file.
     */
    public String getSauceKey() {
        return getEnv("Key");
    }

    /**
     * Method to get Remote Browser of sauceLabs.
     *
     * @return the browser SauceLabs selected read from properties file.
     */
    public String getRemoteBrowser() {
        return getEnv("remoteBrowser");
    }

    /**
     * Method to get OS of sauceLabs.
     *
     * @return the OS SauceLabs selected read from properties file.
     */
    public String getRemotePlatform() {
        return getEnv("remotePlatform");
    }

    /**
     * Method to get Browser version of sauceLabs.
     *
     * @return the Browser version of SauceLabs  selected read from properties file.
     */
    public String getPlatformVersion() {
        return getEnv("remotePlatformVersion");
    }

    /**
     * Method to get resolution of sauceLabs.
     *
     * @return the resolution SauceLabs selected read from properties file.
     */
    public String getRemoteResolution() {
        return getEnv("remoteResolution");
    }

    /**
     * Method to return the docker url from the environment properties.
     *
     * @return the docker url in a string object.
     */
    public String getDockerUrl() {
        return getEnv("dockerUrl");
    }

    /**
     * Method to return the browser from the environments properties.
     *
     * @return the browser.
     */
    public String getBrowser() {
        return getEnv("browser");
    }

    /**
     * Getter for the OS version for Browserstack remote driver.
     *
     * @return the version OS.
     */
    public String getOSVersion() {
        return getEnv("OSVersion");
    }

    /**
     * This method return the string for a specific environment property.
     *
     * @param env is the property string.
     * @return the specified property.
     */
    private String getEnv(final String env) {
        String property = System.getProperty(env);
        if (property == null) {
            return properties.getProperty(env);
        }
        return property;
    }
}


