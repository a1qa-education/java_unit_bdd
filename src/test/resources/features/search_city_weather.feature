@scenario1
Feature: Search City Weather

  Scenario: Search for New York weather
    Given I open the url "https://www.timeanddate.com"
    When I click the link with class "site-nav__title" and text "Weather"
    And I verify the page title contains "Weather"
    Then I clear the input
    And I type "New York" into the input with class "picker-city__input"
    Given I wait 2 seconds for the dropdown to appear
    When I click element number 2 in the list
    When the text of element contains "New York"
