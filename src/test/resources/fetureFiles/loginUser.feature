
Feature: User Login Test
  
  
  Scenario Outline: Verify the user login to dashboard application
    Given User on login page
    When user enters "<email address>" and "<password>"
    And click on Login button
    Then User should be landed on home page
    

    Examples: 
      | email address  | password |
      | dashboard@aimbeyond.com |123456| 
      | dashboard@aimbeyond.com |12345|
      
          
