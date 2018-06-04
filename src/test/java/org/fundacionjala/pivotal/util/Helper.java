package org.fundacionjala.pivotal.util;

import org.testng.asserts.Assertion;

/**
 * Class Helper.
 */
public class Helper {
    private Assertion assertion;

    /**
     * Class constructor.
     *
     * @param assertion object.
     */
    public Helper(final Assertion assertion) {
        this.assertion = assertion;
    }

    /**
     * Get Assertion.
     *
     * @return a instance of Assertion.
     */
    public Assertion getAssertion() {
        return assertion;
    }

    /**
     * Set assertion instance.
     *
     * @param assertion a instance of Soft Assertion.
     */
    public void setAssertion(final Assertion assertion) {
        this.assertion = assertion;
    }
}
