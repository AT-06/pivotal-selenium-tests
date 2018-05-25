package org.fundacionjala.pivotal.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesConfig is class for read config.properties.
 */
public final class PropertiesConfig {


    /**
     * instance.
     */
    private static PropertiesConfig instance = new PropertiesConfig();

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
    public static PropertiesConfig getPropertiesConfig() {
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
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new NoConfigPropertiesFound("Class PropertiesConfig: ", e);
        }
    }

    /**
     * @return instance.
     */
    public static PropertiesConfig getInstance() {
        return instance;
    }

    /**
     * @return User.
     */
    public String getUser() {
        return properties.getProperty("User");
    }

    /**
     * @return Password.
     */
    public String getPassword() {
        return properties.getProperty("Password");
    }

    /**
     * Method to get token to use API.
     * @return the token read from properties file.
     */
    public String getAPIToken() {
        return properties.getProperty("APIToken");
    }

    /**
     * Method to get Name user of sauceLabs.
     * @return the Username SauceLabs read from properties file.
     */
    public String getSauceUserName() {
        return  properties.getProperty("sauceUserName");
    }

    /**
     * Method to get key of sauceLabs.
     * @return the key SauceLabs read from properties file.
     */
    public String getSauceKey() {
        return properties.getProperty("sauceKey");
    }
}
