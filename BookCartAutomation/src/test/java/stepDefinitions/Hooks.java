package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        BaseTest.getDriver();
    }

    @After
    public void tearDown() {
        BaseTest.closeDriver();
    }
}
