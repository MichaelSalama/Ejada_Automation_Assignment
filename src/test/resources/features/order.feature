Feature: Order a product

  @RunThis
  Scenario: Successful order
    Given I am logged in as "standard_user"
    When I add a product to the cart and complete the checkout
    Then I should see the order confirmation