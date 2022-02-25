Feature: Current Weather Data
  The Current Weather Data

  @NoRain
  Scenario: No Rain
    Given I have Current Weather Data for clear weather
    When I get the Rain
    Then I should expect the object reference to be null

  @NoClouds
  Scenario: No Clouds
    Given I have Current Weather Data for clear weather
    When I get the Clouds
    Then I should expect the object reference to be null


  @NoSnow
  Scenario: No Snow
    Given I have Current Weather Data for clear weather
    When I get the Snow
    Then I should expect the object reference to be null
