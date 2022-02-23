package com.sparta.weatherapiproject.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord{

	@JsonProperty("lon")
	private int lon;

	@JsonProperty("lat")
	private double lat;

	public int getLon(){
		return lon;
	}

	public double getLat(){
		return lat;
	}
}