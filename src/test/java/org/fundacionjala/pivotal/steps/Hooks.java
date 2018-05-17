package org.fundacionjala.pivotal.steps;

import cucumber.api.java.After;
import org.fundacionjala.pivotal.common.APIMethods;

public class Hooks {
    private APIMethods methods;

    @After
    public void afterCreatingProject() {
        methods = new APIMethods();
        methods.deleteProject();
    }
}
