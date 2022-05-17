Feature: Categories
  As an admin
  I should be able to access categories
  So that i can see all the categories and
  Create Category

  Scenario: GET- Get all Categories
    Given I set an endpoint for Get all categories
    When I send Get all categories request
    Then I validate the status code is 200

  Scenario: POST - Create Category
    Given I set an endpoint to create category
    When I request POST detail for create new category
    Then I validate the status code after create category is 200