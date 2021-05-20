
Feature: Test link page Guru99

  Scenario: Click on first link
    Given Open the page
    When Click on first link
    Then I should see "Google"

  Scenario: Click on second link
    Given Open the page
    When Click on second link
    Then I should see logo "Facebook"


  Scenario: Navigate with link
    Given Open the page
    When Click on first link
    Then I should see "Google"
    And Go back
    When Click on second link
    Then I should see logo "Facebook"
    And Go back
    Then I should see the link
