@CartTest
Feature: Amazon Cart Functionality

  Scenario: Add products to cart and verify total price
    Given the user is logged in to Amazon
    When the user searches for a product "watch for man"
    And I add the first 5 items to the cart
    Then I should see the correct total price in the cart
    When I remove the first item from the cart
    Then the cart total should update correctly
