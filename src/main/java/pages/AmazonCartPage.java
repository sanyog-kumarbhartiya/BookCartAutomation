package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AmazonCartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cartTotal = By.id("sc-subtotal-amount-buybox");
    private By itemPrices = By.cssSelector(".sc-apex-cart-price-to-pay");
    private By deleteButtons = By.xpath("//input[@value='Delete']");

    public AmazonCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void goToCart() {
        driver.get("https://www.amazon.in/gp/cart/view.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTotal));
    }

    public double getCartTotal() {
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartTotal));
        return Double.parseDouble(totalElement.getText().replace("₹", "").replace(",", "").trim());
    }

    public void printCartPrices() {
        List<WebElement> prices = driver.findElements(itemPrices);
        double sum = 0;
        for (WebElement price : prices) {
            double itemPrice = Double.parseDouble(price.getText().replace("₹", "").replace(",", "").trim());
            sum += itemPrice;
            System.out.println("Item Price: ₹" + itemPrice);
        }
        System.out.println("Expected Cart Total: ₹" + sum);
    }

    public double removeFirstItem() {
        List<WebElement> prices = driver.findElements(itemPrices);
        double removedItemPrice = Double.parseDouble(prices.get(0).getText().replace("₹", "").replace(",", "").trim());

        List<WebElement> deleteBtns = driver.findElements(deleteButtons);
        if (!deleteBtns.isEmpty()) {
            deleteBtns.get(0).click();
            wait.until(ExpectedConditions.stalenessOf(prices.get(0)));
        }
        return removedItemPrice;
    }
}
