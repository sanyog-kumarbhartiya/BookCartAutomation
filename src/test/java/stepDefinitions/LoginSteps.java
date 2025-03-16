package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import base.BaseTest;
import utils.ConfigReader;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(BaseTest.getDriver());

    @Given("the user is logged in to Amazon")
    public void the_user_is_logged_in_to_amazon() {
        if (!loginPage.isLoginSuccessful()) {
            String email = ConfigReader.getProperty("amazon.email");
            String password = ConfigReader.getProperty("amazon.password");
            loginPage.login(email, password);
            Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
        }
    }
}
