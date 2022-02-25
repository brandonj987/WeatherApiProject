Feature: Coords
  The Coordinates Data

  @GetLatitude
  Scenario Get Latitude
    Given I have a Coords
    When I get the latitude
    Then the latitude should be within range of -180 and 180

  @GetLongitude
  Scenario: Get Longitude
    Given I have a Coords
    When I get the longitude
    Then the longitude should be within the range of -90 and 90