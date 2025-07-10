Feature: SauceDemo Login

  @RunThis
  Scenario Outline: Login with different user types
    Given I am on the login page
    When I login with username "<username>" and password "<password>"
    Then I should see "<result>"

    Examples:
      | username        | password     | result                                                                    |
      | standard_user   | secret_sauce |                                                               |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | invalid_user    | wrong_pass   | Epic sadface: Username and password do not match any user in this service |