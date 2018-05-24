package org.fundacionjala.pivotal.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class APIResponseName {
    private String date;

    public String getDate() {

        return date;
    }

    /**
     * Method to get the creation date.
     * @return the creationdate.
     */
    public String generateDate() {
        Date date = new Date();
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatDate.format(date);
    }
    /**
     * Method to set creationDate.
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

}
