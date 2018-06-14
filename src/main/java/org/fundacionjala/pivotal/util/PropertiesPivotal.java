package org.fundacionjala.pivotal.util;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties Pivotal class.
 */
public final class PropertiesPivotal {

    private static PropertiesPivotal propertiesPivotal;
    private Properties properties;
    private static final Logger LOGGER = Logger.getLogger(PropertiesPivotal.class.getName());

    /**
     * Constructor, private to apply singleton pattern.
     */
    private PropertiesPivotal() {
        init();
    }

    /**
     * Static method to get an class instance.
     *
     * @return instance.
     */
    public static PropertiesPivotal getInstance() {
        if (propertiesPivotal == null) {
            propertiesPivotal = new PropertiesPivotal();
        }
        return propertiesPivotal;
    }

    /**
     * Initialize Properties object.
     */
    private void init() {
        properties = new Properties();
        try (InputStream input = new FileInputStream("gradle.properties")) {
            properties.load(input);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Gets Url Login.
     *
     * @return String url login.
     */
    public String getAPIToken() {
        return getEnvValue("APIToken");
    }

    /**
     * Gets Url Login.
     *
     * @param var variable obtained of gradle.properties.
     * @return the enviroment value.
     */
    private String getEnvValue(final String var) {
        String property = System.getProperty(var);
        return property == null ? properties.getProperty(var) : property;
    }

}
