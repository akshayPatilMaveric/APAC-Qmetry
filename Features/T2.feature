Feature: T2
  Scenario: To perform Google Search for T2
    Given User launches the chrome browser
    When User opens "google" url
    And Enters "Pune" into the Search Bar
    And clicks onto the Search Button
    And A Screenshot is taken of the response screen