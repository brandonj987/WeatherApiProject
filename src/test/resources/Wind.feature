Feature: Wind
  Wind Data

  @NoGust
  Scenario: No Gust
    Given I have Wind Data
    When I have no Gust data
    Then I should expect Gust to be null