
Feature: Home Page menus


  Scenario Outline: Validate the Home Page menus
    Given User logged in "<email>" "<password>"
    When User is on home page
    Then all menus should be present 

    Examples: 
      | email                 | password |
      |dashboard@aimbeyond.com|12345|
      
      
