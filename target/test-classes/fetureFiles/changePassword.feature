
Feature: Change Password
 
  Scenario Outline: Change your password
    Given User is on home page "<email>" and "<password>"
    When User clicks on my profile menu
    And User clicks on change password
    And User enters "<old password>" "<new password>" "<confirm password>"
    When User clicks on submit button
    Then User should be able to see change password confirmation popup and password should be changed
   
    Examples: 
      |email|               password| old password  | new password | confirm password  |
      |dashboard@aimbeyond.com|12345| 12345       |     123456  | 123456          |
      
