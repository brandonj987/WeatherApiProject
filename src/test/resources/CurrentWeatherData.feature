Feature: Current Weather Data
  The Current Weather Data

  @NoRain
  Scenario: No Rain
    Given I have Current Weather Data
    When I get the Rain
    Then I should expect rain to be null

  @NoClouds
  Scenario: No Clouds
    Given I have Current Weather Data
    When I get the Clouds
    Then I should expect clouds to be null


  @NoSnow
  Scenario: No Snow
    Given I have Current Weather Data
    When I get the Snow
    Then I should expect snow to be null
