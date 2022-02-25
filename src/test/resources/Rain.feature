Feature: Rain

  @getRainIn1Hour
  Scenario: Get Rain in 1 hour
    Given I have rain data
    When I get the rain over the past hour
    Then I should get the rain in the hour