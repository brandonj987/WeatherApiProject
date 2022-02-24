Feature: WeatherItem
  The Weather Item Object

  @GetId
  Scenario Get Id
    Given I have a weather item
    When I get the Id
    Then the id should be within a valid range

  @GetMain
  Scenario: Get Main
    Given I have a weather item
    When I get main
    Then main should be a valid weather type name


  @GetDescription
  Scenario Get Description:
    Given I have a weather item
    When I get the description
    Then the value should be a valid  weather description

  @GetIcon
  Scenario: Get Icon
    Given I have a weather item
    When I get Icon
    Then The value should be a member of a weather items type name"
