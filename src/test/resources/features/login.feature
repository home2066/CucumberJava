Feature: feature to test login functionality

  Scenario Outline: Check Login is successful with valid ceredentials
    Given Opens the Browser
    When Enters the <username> and <password>
    Then Close the Browser

    Examples: 
      | username                      | password     |
      | kakumanipujitha25@outlook.com | Gopal@190473 |
