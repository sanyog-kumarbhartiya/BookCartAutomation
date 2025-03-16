package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By addToCartButton = By.id("a-autoid-2");  
    private By cartSubtotal = By.id("nav-cart-count");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
        this.js = (JavascriptExecutor) driver;
    }

    public void searchForProduct(String product) {
        System.out.println("Searching for product: " + product);

        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchField.clear();
        searchField.sendKeys(product);

        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();

        System.out.println("Search completed for '" + product + "'");
    }

    public void addProductToCart() {
        System.out.println("Adding product to the cart...");

        try {
            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", addToCart);
            addToCart.click();
            System.out.println("Product added to cart successfully!");
        } catch (TimeoutException e) {
            throw new RuntimeException("'Add to Cart' button not found or clickable.", e);
        }
    }

    public void verifyCartNotEmpty() {
        System.out.println("Verifying cart is not empty...");

        try {
            // Get the initial cart count before adding the item
            String initialCartCount = driver.findElement(cartSubtotal).getText();
            int initialCount = Integer.parseInt(initialCartCount.trim());

            // Wait until the cart count increases
            wait.until(ExpectedConditions.textToBePresentInElementLocated(cartSubtotal, String.valueOf(initialCount + 1)));
            System.out.println("Cart updated successfully! New count: " + (initialCount + 1));
        } catch (NumberFormatException | TimeoutException e) {
            throw new RuntimeException("Cart count did not update as expected.", e);
        }
    }
}