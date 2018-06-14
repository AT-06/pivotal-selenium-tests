package org.fundacionjala.pivotal.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to set the creation date of the reponse.
 */
public class APIResponseName {
    private String date;

    /**
     * Method to get the creation date.
     * @return the creationdate.
     */
    public String getDate() {
        return date;
    }

    /**
     * Method to generate the creation date.
     * @return the creationdate.
     */
    public String generateDate() {
        Date newDate = new Date();
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatDate.format(newDate);
    }
    /**
     * Method to set creationDate.
     * @param date return the creation date.
     */
    public void setDate(final String date) {
        this.date = date;
    }

}
