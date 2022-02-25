Feature: Main

  @TempMaxGreaterThanTempMin
  Scenario: Temperature Range
    Given I have Main
    When I have the minimum and the maximum temperature
    Then The maximum tempurature should be greater Than or equal to the minimum Temperature


