Feature: Delete Customer Guru99
  I am a user and i want to delete my customer Id
  on the page Delete Customer of Guru99

  Scenario Outline: Delete a customer
    Given Open Delete Customer page
    When Insert Customer ID "<customerId>"
    And Click Submit button
    And I should see Confirm alert
    And Click Confirm button
    And I should see Success alert
    And Click Confirm button
    Then I should see Home Page

    Examples:
    | customerId |
    | 1234       |
    | bac        |



  Scenario: Cancel Delete Customer
    Given Open Delete Customer page
    When Insert Customer ID "1234"
    And Click Submit button
    And I should see Confirm alert
    And Click Cancel button
    Then I should see Home Page

    Scenario: Reset Input Customer Id
      Given Open Delete Customer page
      When Insert Customer ID "1234"
      And Click Reset button
      Then I should see blank Input