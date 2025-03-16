package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AmazonCartPage;
import pages.AmazonSearchResultsPage;
import utils.DriverFactory;

import static org.junit.Assert.assertEquals;

public class AmazonSteps {
    private WebDriver driver;
    private AmazonSearchResultsPage searchResultsPage;
    private AmazonCartPage cartPage;
    
    public AmazonSteps() {
        this.driver = DriverFactory.getDriver(); 
        this.searchResultsPage = new AmazonSearchResultsPage(driver); 
        this.cartPage = new AmazonCartPage(driver);
    }

    @And("I add the first 5 items to the cart")
    public void addProductsToCart() {
        searchResultsPage.addFirstFiveProductsToCart(); 
    }

    @Then("I should see the correct total price in the cart")
    public void verifyTotalPrice() {
        double totalPrice = cartPage.getCartTotal();
        System.out.println("Total Cart Price: ₹" + totalPrice);
    }

    @When("I remove the first item from the cart")
    public void removeFirstItem() {
        cartPage.removeFirstItem();
    }

    @Then("the cart total should update correctly")
    public void verifyUpdatedCartTotal() {
        double updatedPrice = cartPage.getCartTotal();
        System.out.println("Updated Cart Price: ₹" + updatedPrice);
    }
}
