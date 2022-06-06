Feature: Login UI


Scenario: Login page title
    Given User is on login page
    When Page is loaded 
    Then Login page title should be "Dashboard2"
    
Scenario: Eamil and password textboxes
    Given User is on login page
    Then User should be able to see eamil textbox
    And User should be able to see password textbox

Scenario: Login button on login page
    Given User is on login page
    Then User should be able to see a login button
    
Scenario: Forgot your password link on login page 
    Given User is on login page
    Then User should be able to see "Forgot your password?" link