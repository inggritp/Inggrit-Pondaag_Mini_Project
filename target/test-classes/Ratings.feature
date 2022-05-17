Feature: As an Admin
  I should be able to
  See product's ratings and
  Give ratings to a product


  Scenario: POST - Give ratings to a product
    Given I set an endpoint for ratings
    When I post give ratings detail
    Then I validate the status code is 200 and ratings detail


  Scenario: GET - get product's ratings
    Given I set an endpoint for ratings
    When I send get product's ratings request
    Then I validate the status code is 200 and data detail after get ratings
