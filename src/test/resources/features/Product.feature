Feature: Product
  As a user
  I want to buy new product
  So that i can process my transaction


  Scenario: Buy first product
    Given I am on product page
    When I click buy button on first product
    Then first product added to my shopping cart


  Scenario: Buy second product
    Given I am on product page
    When I click buy button on second product
    Then second product added to my shopping cart

  Scenario: When i don't buy anything on product page
    Given I am on product page
    When I dont click any buy button on product title
    Then My shopping cart is empty

  Scenario: Using category bar
    Given I am on product page
    When I click category bar
    And I click category that i want
    Then I can see is the category has items or not