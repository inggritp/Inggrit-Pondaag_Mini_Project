Feature: Login in Authentication Module
  I should be able to login
  So that I can do other requests


  Scenario: POST- Login with valid email and password
    Given I set login endpoint
    When I send post request with valid email and password
    Then I validate the status code is 200 and data detail


  Scenario: POST - Login with valid email but invalid password
    Given I set login endpoint
    When I send post request with valid email but invalid password
    Then I validate the status code is 400 and data detail

  Scenario: POST - Login with invalid email and password
    Given I set login endpoint
    When I send post request with invalid email and password
    Then I validate the status code is 400 and data detail
