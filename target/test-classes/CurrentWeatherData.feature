Feature: Current Weather Data
  The Current Weather Data

  @NoRain
  Scenario: No Rain
    Given I have Current Weather Data
    When The weather is clear
    And I get the Rain
    Then I should expect it to be null

  @NoClouds
  Scenario: No Clouds
    Given I have Current Weather Data
    When The weather is clear
    And I get the Clouds
    Then I should expect it to be null


  @NoSnow
  Scenario: No Snow
    Given I have Current Weather Data
    When The weather is clear
    And I get the Snow
    Then I should expect it to be null

  @AWeatherEvent
  Scenario: A weather Event
    Given I have Current Weather Data
    When The weather is clear
    And I have a weather Event

  @GetTimezone
  Scenario: Get Timezone
    Given I have Current Weather Data
    When The weather is clear
    And I get the Timezone
    Then The integer value should be between -43200 and 50400


  @WeatherListSize
  Scenario: Get Weather List Size
    Given I have Current Weather Data
    When The weather is clear
    And I get Weather
    Then I should expect it not to be null
