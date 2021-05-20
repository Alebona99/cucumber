Feature: Delete Customer Guru99

  Scenario Outline: Delete a customer
    Given Open Delete Customer page
    When Insert Customer ID <customerId>
    And Submit
    Then I should see Confirm alert
    And Click Confirm
    Then I should see Success alert
    And Click Confirm
    And See Home Page

    Examples:
    | customerId |
    | 1234       |
    | acd        |
    | abcd       |
    | 123bcv     |



  Scenario: Cancel Delete Customer
    Given Open Delete Customer page
    When Insert Customer ID "1234"
    And Submit
    Then I should see Confirm alert
    And Click Cancel
    Then See Home Page

    Scenario: Reset Input Customer Id
      Given Open Delete Customer page
      When Insert Customer ID "1234"
      And Click Reset
      Then I should see blank Input