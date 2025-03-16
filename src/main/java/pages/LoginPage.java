package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By signInButton = By.id("nav-link-accountList");
    private By emailField = By.id("ap_email");
    private By continueButton = By.id("continue");
    private By passwordField = By.id("ap_password");
    private By loginButton = By.id("signInSubmit");
    private By accountIcon = By.id("nav-link-accountList");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void openLoginPage() {
        driver.get("https://www.amazon.in");
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void login(String email, String password) {
        openLoginPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginSuccessful() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(accountIcon)).isDisplayed();
        } catch (Exception e) {
            return false; // Login failed or session expired
        }
    }
}
