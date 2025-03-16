package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Arrays;

public class BaseTest {
    protected static WebDriver driver;  // Ensuring static WebDriver instance
    private static final String CHROME_DRIVER_PATH =  "C:/Users/chromedriver-win64/chromedriver.exe";
  // Local ChromeDriver path
    private static final String URL = "https://www.amazon.in/"; // Change to your target URL

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);  // Set ChromeDriver path
            
            ChromeOptions options = new ChromeOptions();
            
            // Fix "403 Forbidden" WebSocket error and prevent detection
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(URL);  // Open the specified URL
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
