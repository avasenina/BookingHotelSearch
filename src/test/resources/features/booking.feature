Feature: Booking search test

  Scenario: search Belarus Hotel box
    Given I want Search is "Belarus Hotel"
    When I click SearchButton
    Then I get bookingPage "Belarus Hotel" is on the first page with rating "8.6"

