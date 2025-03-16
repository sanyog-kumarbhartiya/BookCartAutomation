package stepDefinitions; 

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pages.SearchPage;
import base.BaseTest;

public class SearchSteps {
    WebDriver driver = BaseTest.getDriver();
    SearchPage searchPage = new SearchPage(driver);

    @When("the user searches for a product {string}")
    public void searchForItem(String item) {
        searchPage.searchForProduct(item);
    }

    @When("the user adds the product to the cart")
    public void addProductToCart() {
        searchPage.addProductToCart();
    }

    @Then("the item should be added to the cart successfully")
    public void verifyCart() {
        searchPage.verifyCartNotEmpty();
    }
}
