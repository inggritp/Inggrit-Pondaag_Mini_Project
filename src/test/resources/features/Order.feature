Feature: Change item's quantity on my shopping cart
  As a user
  I should be able to change the quantity of the item on my shopping cart
  So that i can do transaction


  Scenario: I add quantity of an item
    Given I am already on product page
    When I click buy first product button on product page
    And I click shopping cart button
    And I click + sign on the product
    Then The total quantity of the product is equal to 2

  Scenario: I reduce quantity of an item
    Given I am on product page
    When I click buy second product button on product page
    And I click shopping cart button
    And I click + sign on the product
    And I click - sign on the product
    Then The total quantity of the product is equal to 1

  Scenario: I remove the item in my shopping cart
    Given I am on product page
    When I click buy first product button on product page
    And I click shopping cart button
    And I click - sign on the product
    Then I validate the product is removed

  Scenario: I click Bayar button on product page
    Given I am on product page
    When I click buy button on second product
    And I click shopping cart button
    And I click Bayar button
    Then I go to transactions page
