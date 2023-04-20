language #en
Feature: user can login to Demo app with specific credentials

  Scenario Outline: Successful login
    Given I'm on "login" page
    And fill user name with "user"
    And fill password with "password"
    When I click on "Login" button
    Then I should be loggined successfully
    And I should be redirected on "home" page
    And be happy
    Examples: