Feature: Form Authentication Demo

  Scenario: Form Authentication Test
    Given I open main page
    And I navigate to "Form Authentication" page
    Then the Form Authentication page should be open
    When I login with valid credentials
    Then the Secure Area page should be open
    And the successful login message "You logged into a secure area!" is displayed
    When I click logout
    Then the Form Authentication page should be open after logout
