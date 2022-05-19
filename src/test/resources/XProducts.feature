Feature: Products Module
  I should be able to access products
  So that i can see and create new products


  Scenario: GET - All Products
    Given I set an endpoint to get all products
    When I send GET all products request
    Then I validate the status code for product is 200



  Scenario: POST - Create Product
    Given I set an endpoint to create new product
    When I request POST detail for create new product
    Then I validate the status code is 200 and validate the product detail



  Scenario: GET - Product by ID
    Given I set an endpoint to get product by id
    When I send GET product by id request
    Then I validate the status code is 200