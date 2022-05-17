Feature: As a user
  I should be able to logout
  From my account
  So that i can use another account


  Scenario: Logout from my account
    Given I successfully login
    And I directed to product page
    When I click menu button
    And I click logout button
    Then I directed to login page