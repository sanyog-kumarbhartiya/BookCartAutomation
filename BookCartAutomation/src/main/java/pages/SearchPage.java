package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    // **Locators**
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By addToCartButton = By.id("a-autoid-2");  // ✅ Updated Add to Cart button ID
    private By cartSubtotal = By.id("nav-cart-count");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // ✅ Increased timeout
        this.js = (JavascriptExecutor) driver;
    }

    /**
     * Searches for a product and waits for results.
     */
    public void searchForProduct(String product) {
        System.out.println("🔍 Searching for product: " + product);

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchField.clear();
        searchField.sendKeys(product);

        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();

        // ✅ Wait for 20 seconds after search
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Search completed for '" + product + "'");
    }

    /**
     * Adds a product to the cart.
     */
    public void addProductToCart() {
        System.out.println("🛒 Adding product to the cart...");

        try {
            // ✅ Wait for the Add to Cart button to be clickable
            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", addToCart);
            addToCart.click();
            System.out.println("✅ Product added to cart successfully!");
        } catch (TimeoutException e) {
            throw new RuntimeException("❌ 'Add to Cart' button not found or clickable.", e);
        }
    }

    /**
     * Verifies if the cart contains at least one item.
     */
    public void verifyCartNotEmpty() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(cartSubtotal, "1"));
        System.out.println("✅ Item successfully added to the cart.");
    }
}
