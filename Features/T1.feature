Feature: T1
  Scenario: To perform Google Search for T1
    Given User launches the chrome browser
    When User opens "google" url
    And Enters "maveric" into the Search Bar
    And clicks onto the Search Button
    And A Screenshot is taken of the response screen