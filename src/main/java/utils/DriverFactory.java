package utils;

import org.openqa.selenium.WebDriver;
import base.BaseTest;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BaseTest.getDriver();
        }
        return driver;
    }
}
