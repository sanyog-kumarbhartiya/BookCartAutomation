package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AmazonHomePage;
import pages.AmazonSearchResultsPage;
import pages.AmazonCartPage;
import java.time.Duration;

public class AmazonCartTest {
    public static void main(String[] args) {
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); 
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        AmazonHomePage homePage = new AmazonHomePage(driver);
        AmazonSearchResultsPage searchResultsPage = new AmazonSearchResultsPage(driver);
        AmazonCartPage amazonCart = new AmazonCartPage(driver);

        try {
            // Search for "watch for man"
            homePage.searchProduct("watch for man");

            // Add first 5 products to the cart
            searchResultsPage.addFirstFiveProductsToCart();

            // Go to cart and verify total price
            amazonCart.goToCart();
            double cartTotal = amazonCart.getCartTotal();
            System.out.println("Total Cart Price: ₹" + cartTotal);

            // Remove first item and verify new total
            double removedPrice = amazonCart.removeFirstItem();
            Thread.sleep(3000); 
            double updatedCartTotal = amazonCart.getCartTotal();

            System.out.println("Removed item price: ₹" + removedPrice);
            System.out.println("New Cart Total: ₹" + updatedCartTotal);

            //  Validate total price update
            if (updatedCartTotal == (cartTotal - removedPrice)) {
                System.out.println("Cart updated correctly after item removal.");
            } else {
                System.out.println("Cart update mismatch!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
