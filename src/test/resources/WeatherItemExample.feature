Feature: WeatherItem
  The WeatherItem DTO

  @Icon
  Scenario: Icon
    Given I have a weather item
    And description is few clouds
    When I get Icon
    Then The value should be either "02d" or "02n"