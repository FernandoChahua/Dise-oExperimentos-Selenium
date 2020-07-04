Feature: Add product to cart

  Scenario Outline: Verification that the shopping cart shows the total cost of the order is correct
    Given I am a customer with "<username>" and "<password>"
    When I select a category and product
    And Set the quantity and click Add to Cart
    And I open cart
    Then I am shown the total cost of my purchase
    Examples:
      |username|password|
      |test10@gmail.com|12345|


