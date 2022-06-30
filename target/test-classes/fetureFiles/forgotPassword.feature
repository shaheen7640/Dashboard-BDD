Feature: Fogot your password

  Scenario Outline: Verify forgot your password
    Given User login page
    When User clicks on forgot your password link
    Then User should be prompted to a forgot your password popup
    When User enters their registered "<email>" id into text box
    And clicks on Send Password button
    Then User should be prompted to a reset password confirmation popup
    And User should be received a mail which contains reset password link

Examples:
        |email|
        |dashboard@aimbeyond.com|
