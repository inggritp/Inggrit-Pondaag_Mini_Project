Feature: As an Admin
  I should be able to access  in Transactions
  So that i can see and create order


  Scenario: POST - Create order
    Given I set an endpoint for create order
    When I send post detail for create order
    Then I validate the status code is 200 after create order and the detail


  Scenario: GET -  Get all orders
    Given I set an endpoint for get all orders
    When I request to get all orders
    Then I validate the status code is 200 and detail


 Scenario: POST - Invalid request for create order
   Given I set an endpoint for create order
   When I send invalid post detail for create order
   Then I validate the status code for invalid request is 400