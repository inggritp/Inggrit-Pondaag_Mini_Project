Feature: As an Admin
  I should be able to access comments
  So that i can write comment to a product and
  get comments of the product

  Scenario: POST - write comment to a product
    Given I set comment endpoint
    When I send post detail for write comment to a product
    Then I validate the status code after write comment is 200 and the detail


  Scenario: GET - Get product's comments
    I set comment endpoint
    When I send get request to get product's comments
    Then I validate the status code is 200 and validate the comment