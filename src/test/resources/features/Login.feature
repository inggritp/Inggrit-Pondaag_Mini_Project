Feature: Login
  As a user
  I have to be able to login
  So that i can buy products


  Scenario Outline: Login
    Given I am on qa.alta.id login page
    When I input "<email>"
    And Input "<password>"
    And Click login button
    Then I get "<result>"
    Examples:
    |email|password|result|
    |inggrit@gmail.com|Passwordtest321|product_page|
    |rosieposieee@wpdork.com  |Password123    |Alert symbol: record not found |
    |pondaaginggrit1@gmail.com|               |Alert message: password is required                    |
    |    |               |Alert message: email is required                     |
    |pondaaginggrit1@gmail.com|Password4444   |Alert message: email or password is invalid|