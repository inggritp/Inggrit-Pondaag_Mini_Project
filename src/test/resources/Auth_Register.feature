Feature: Regist in Authentication Module
  I should be able to create new user
  So that i can use other features

  Scenario: POST - Create user with new email
    Given I set an endpoint for register new user
    When I send post detail with unregistered email
    Then I validate the register status code is 200


  Scenario: POST - Create user using registered email
    Given I set an endpoint for register new user
    When I send post detail with registered email
    Then I validate the status code is 400 and message
















