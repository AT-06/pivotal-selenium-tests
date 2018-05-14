package org.fundacionjala.pivotal.common;

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
     * inputStream.
     */
    private InputStream inputStream;

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
     * This method initialize properties and input stream.
     */
    private PropertiesConfig() {
        try {
            properties = new Properties();
            inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);
        } catch (IOException e) {

        }
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
}
