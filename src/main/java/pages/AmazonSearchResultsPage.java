package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonSearchResultsPage {
    private WebDriver driver;
    private By productList = By.cssSelector(".s-main-slot .s-result-item");

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstFiveProductsToCart() {
        List<WebElement> products = driver.findElements(productList);

        for (int i = 0; i < 1 && i < products.size(); i++) {
            try {
                // Click Add to Cart buttons
                driver.findElement(By.id("a-autoid-2")).click();
                driver.findElement(By.id("a-autoid-3")).click();
                driver.findElement(By.id("a-autoid-4")).click();
                driver.findElement(By.id("a-autoid-5")).click();
                driver.findElement(By.id("a-autoid-6")).click();
                driver.findElement(By.id("a-autoid-7")).click();

                
                Thread.sleep(20000);

            } catch (InterruptedException e) {
                e.printStackTrace(); // Print the exception if it occurs
            }
        }

        AmazonCartPage cartPage = new AmazonCartPage(driver);
        cartPage.goToCart();
        
    }
}
