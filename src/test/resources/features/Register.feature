Feature: Register
  As a user
  I should be able to create new account
  So that i can do transactions


  Scenario Outline: Register
    Given I am on register page
    When I input fullname "<nama_lengkap>"
    And I input email "<email>"
    And I input pass "<password>"
    And click register button
    Then I get the "<result>"
    Examples:
    |nama_lengkap|email|password|result|
    |Inggrit     |new|Rosieeposie45|login_page|
    |Inggrit     |pondaaginggrit1@gmail.com|Password3211|alert symbol|
    |            |                        |            |alert symbol|
    |            |jichuuu@gmail.com                    |Halloo321   |alert message: fullname is required|
    |Kim Jisoo   |                         |Halloo321   |alert message: email is required   |
    |Kim Jisoo   |jichuuu@gmail.com                     |            |alert message: password is required|
