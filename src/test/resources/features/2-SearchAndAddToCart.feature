Feature: Search and Add Product to Cart

  Scenario: Search and Add Product to Cart
    Given the user is logged in to Amazon
    When the user searches for a product "watch for man"
    And the user adds the product to the cart
    Then the item should be added to the cart successfully
