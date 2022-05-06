Feature: Basic Syntax

  Scenario: This is scenario 1
    Given User is on the TS homepage
    When User clicks on the About Us button
    Then User is redirected to About Us page
    And Close the browser